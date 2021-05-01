package com.example.swinger;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Hole18Activity extends AppCompatActivity {
    private TextView player1Score;
    private TextView player2Score;
    private TextView player3Score;
    private TextView player4Score;
    private ImageView player1Crown;
    private ImageView player2Crown;
    private ImageView player3Crown;
    private ImageView player4Crown;
    private ArrayList<Integer> playerHits = new ArrayList<>();
    private int highest = 0;
    private int winner = 0;
    private int currentPlayer = 1;

    public HoleConfig config = new HoleConfig(18);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hole18);
        config.buildHole(this);
        player1Score = findViewById(R.id.hole18_player1Score);
        player2Score = findViewById(R.id.hole18_player2Score);
        player3Score = findViewById(R.id.hole18_player3Score);
        player4Score = findViewById(R.id.hole18_player4Score);
        player1Crown = findViewById(R.id.player1Crown);
        player2Crown = findViewById(R.id.player2Crown);
        player3Crown = findViewById(R.id.player3Crown);
        player4Crown = findViewById(R.id.player4Crown);
    }

    @Override
    protected void onResume() {
        super.onResume();
        config.updatePlayer(1, config.player1Name);
        config.updatePlayer(2, config.player2Name);
        config.updatePlayer(3, config.player3Name);
        config.updatePlayer(4, config.player4Name);

    }
    public void finish(View view){
        playerHits.add(0, Integer.parseInt(player1Score.toString()));
        playerHits.add(1, Integer.parseInt(player2Score.toString()));
        playerHits.add(2, Integer.parseInt(player3Score.toString()));
        playerHits.add(3, Integer.parseInt(player4Score.toString()));
        playerHits.forEach(score->{
            if(score > highest){
                highest = score;
                winner = currentPlayer;
            }
            currentPlayer++;
        });
        switch (winner){
            case 1:
                player1Crown.setVisibility(View.VISIBLE);
                break;
            case 2:
                player2Crown.setVisibility(View.VISIBLE);
                break;
            case 3:
                player3Crown.setVisibility(View.VISIBLE);
                break;
            case 4:
                player4Crown.setVisibility(View.VISIBLE);
                break;
        }
        Log.i("Winner", playerHits.toString());

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