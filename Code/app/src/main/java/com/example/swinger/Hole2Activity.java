package com.example.swinger;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class Hole2Activity extends AppCompatActivity {


    public HoleConfig config = new HoleConfig(2);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hole2);
        config.buildHole(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        config.reloadIntentArgs();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle extras = data.getExtras();

        if (resultCode == Activity.RESULT_OK && extras != null) {

            if (extras.containsKey("p1")){
//                newPlayers.set(0, extras.getString("p1"));
                Log.i("new player 1 name", extras.getString("p1"));
            }

            if (extras.containsKey("p2")){
//                newPlayers.set(1, extras.getString("p2"));
                Log.i("new player 2 name", extras.getString("p2"));

            }

            if (extras.containsKey("p3")){
//                newPlayers.set(2, extras.getString("p3"));
                Log.i("new player 3 name", extras.getString("p3"));

            }

            if (extras.containsKey("p4")){
//                newPlayers.set(3, extras.getString("p4"));
                Log.i("new player 4 name", extras.getString("p4"));

            }

            Log.i("holeconfig log", "finish transmit");
        }
    }

}