package com.example.swinger;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class SettingsActivity extends AppCompatActivity {
    boolean player1Exists;
    boolean player2Exists;
    boolean player3Exists;
    boolean player4Exists;


    String player1;
    String player2;
    String player3;
    String player4;
    ArrayList<String> newPlayers = new ArrayList();
    int requestCodeReturn;
    final int settingsRequestCode = 99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        newPlayers.add(0, "");
        newPlayers.add(1, "");
        newPlayers.add(2, "");
        newPlayers.add(3, "");

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            if (extras.containsKey("p1")){
                player1 = extras.getString("p1");
            }

            if (extras.containsKey("p2")){
                player2 = extras.getString("p2");
            }

            if (extras.containsKey("p3")){
                player3 = extras.getString("p3");
            }

            if (extras.containsKey("p4")){
                player4 = extras.getString("p4");
            }

            player1Exists = extras.getBoolean("player1Exists");
            player2Exists = extras.getBoolean("player2Exists");
            player3Exists = extras.getBoolean("player3Exists");
            player4Exists = extras.getBoolean("player4Exists");

            requestCodeReturn = Integer.parseInt(extras.getString("requestCode"));

        }
    }

    public void gotoEditPlayer(View view) {
        Bundle extras = getIntent().getExtras();
        Intent intent = new Intent(this, EditPlayersActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("p1", player1);
        bundle.putString("p2", player2);
        bundle.putString("p3", player3);
        bundle.putString("p4", player4);

        bundle.putBoolean("player1Exists", extras.getBoolean("player1Exists"));
        bundle.putBoolean("player2Exists", extras.getBoolean("player2Exists"));
        bundle.putBoolean("player3Exists", extras.getBoolean("player3Exists"));
        bundle.putBoolean("player4Exists", extras.getBoolean("player4Exists"));

        intent.putExtras(bundle);
        startActivityForResult(intent, settingsRequestCode);

    }

    public void save(View view) {
        Intent data = new Intent();
        Bundle bundle = new Bundle();

        if (!newPlayers.get(0).equals("")){
            bundle.putString("p1", newPlayers.get(0));
            data.putExtras(bundle);
        }
        if (!newPlayers.get(1).equals("")){
            bundle.putString("p2", newPlayers.get(1));
            data.putExtras(bundle);
        }
        if (!newPlayers.get(2).equals("")){
            bundle.putString("p3", newPlayers.get(2));
            data.putExtras(bundle);
        }
        if (!newPlayers.get(3).equals("")){
            bundle.putString("p4", newPlayers.get(3));
            data.putExtras(bundle);
        }

        bundle.putBoolean("player1Exists", player1Exists);
        bundle.putBoolean("player2Exists", player2Exists);
        bundle.putBoolean("player3Exists", player3Exists);
        bundle.putBoolean("player4Exists", player4Exists);
        data.putExtras(bundle);

        setResult(Activity.RESULT_OK, data);
        finish();
    }

    public String capitalize(String name){
        return name.toUpperCase();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle extras = data.getExtras();
        Log.i("return from result", "return from result");

        if (resultCode == Activity.RESULT_OK && extras != null) {
            Log.i("p1 extras", extras.getString("p1"));
            Log.i("p2 extras", extras.getString("p2"));

            player1Exists = extras.getBoolean("player1Exists");
            player2Exists = extras.getBoolean("player2Exists");
            player3Exists = extras.getBoolean("player3Exists");
            player4Exists = extras.getBoolean("player4Exists");

                if (extras.containsKey("p1")){
                    newPlayers.set(0, extras.getString("p1"));
                }

                if (extras.containsKey("p2")){
                    newPlayers.set(1, extras.getString("p2"));
                }

                if (extras.containsKey("p3")){
                    newPlayers.set(2, extras.getString("p3"));
                }

                if (extras.containsKey("p4")){
                    newPlayers.set(3, extras.getString("p4"));
                }
        }
    }
}

