package com.example.swinger;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.HashMap;

public class Hole18Activity extends AppCompatActivity {


    public HoleConfig config = new HoleConfig(18);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hole18);
        Bundle extras = this.getIntent().getExtras();

        config.player1ScoreList = (HashMap<Integer, Integer>) extras.getSerializable("player1ScoreList");
        config.player2ScoreList = (HashMap<Integer, Integer>) extras.getSerializable("player2ScoreList");
        config.player3ScoreList = (HashMap<Integer, Integer>) extras.getSerializable("player3ScoreList");
        config.player4ScoreList = (HashMap<Integer, Integer>) extras.getSerializable("player4ScoreList");

        config.buildHole(this);


    }

    @Override
    protected void onResume() {
        super.onResume();
        config.updatePlayer(1, config.player1Name);
        config.updatePlayer(2, config.player2Name);
        config.updatePlayer(3, config.player3Name);
        config.updatePlayer(4, config.player4Name);
        config.reloadIntentArgs();
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

            Log.i("holeconfig log", "finish transmit");
        }
    }
}