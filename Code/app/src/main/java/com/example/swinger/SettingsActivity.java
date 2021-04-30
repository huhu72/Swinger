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
    String player1="NA";
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
           player1 = extras.getString("p1");
           requestCodeReturn = Integer.parseInt(extras.getString("requestCode"));
        }
    }

    /*
        TO DO:
            1. Check for all the players, not just the first
            2. Pass all players that exist, not just the first
            3. Inside <EditPlayersActivity />, build all players, not just the first
     */
    public void gotoEditPlayer(View view) {
        Intent intent = new Intent(this, EditPlayersActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("p1", capitalize(player1));
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

