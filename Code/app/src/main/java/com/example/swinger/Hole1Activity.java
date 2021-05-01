package com.example.swinger;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class Hole1Activity extends AppCompatActivity {


    public HoleConfig config = new HoleConfig(1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hole1);
        config.buildHole(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        config.updatePlayer(1, config.player1Name);
        config.updatePlayer(2, config.player2Name);
        config.updatePlayer(3, config.player3Name);
        config.updatePlayer(4, config.player4Name);

        Log.i("Hole 1 return Player 1 on Resume", String.valueOf(config.player1Exists));
        Log.i("Hole 1 return Player 2 on Resume", String.valueOf(config.player2Exists));
        Log.i("Hole 1 return Player 3 on Resume", String.valueOf(config.player3Exists));
        Log.i("Hole 1 return Player 4 on Resume", String.valueOf(config.player4Exists));

        if(!config.player1Exists){
            config.deletePlayer(1);
        }

        if(!config.player2Exists){
            config.deletePlayer(2);

        }

        if(!config.player3Exists){
            config.deletePlayer(3);
        }

        if(!config.player4Exists){
            config.deletePlayer(4);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle extras = data.getExtras();

        if (resultCode == Activity.RESULT_OK && extras != null) {

            if (extras.containsKey("p1")){
                Log.i("new player 1 name", extras.getString("p1"));
                config.player1Name = extras.getString("p1");
            }

            if (extras.containsKey("p2")){
                Log.i("new player 2 name", extras.getString("p2"));
                config.player2Name = extras.getString("p2");
            }

            if (extras.containsKey("p3")){
                Log.i("new player 3 name", extras.getString("p3"));
                config.player3Name = extras.getString("p3");
            }

            if (extras.containsKey("p4")){
                Log.i("new player 4 name", extras.getString("p4"));
                config.player4Name = extras.getString("p4");
            }

            Log.i("Hole 1 return player 1", String.valueOf(config.player1Exists));
            if(extras.containsKey("player1Exists")){
                config.player1Exists = extras.getBoolean("player1Exists");
                Log.i("Hole 1 return player 1 in if statement", String.valueOf(config.player1Exists));
            }

            Log.i("Hole 1 return player 2", String.valueOf(config.player3Exists));
            if(extras.containsKey("player2Exists")){
                config.player2Exists = extras.getBoolean("player2Exists");
                Log.i("Hole 1 return player 2 in if statement", String.valueOf(config.player2Exists));

            }
//
            Log.i("Hole 1 return player 3", String.valueOf(config.player3Exists));
            if(extras.containsKey("player3Exists")){
                config.player3Exists = extras.getBoolean("player3Exists");
                Log.i("Hole 1 return player 3 in if statement", String.valueOf(config.player3Exists));
            }
////
            Log.i("Hole 1 return player 4", String.valueOf(config.player4Exists));
            if(extras.containsKey("player4Exists")){
                config.player4Exists = extras.getBoolean("player4Exists");
                Log.i("Hole 1 return player 4 in if statement", String.valueOf(config.player4Exists));
            }

            Log.i("holeconfig log", "finish transmit");
        }
    }
}