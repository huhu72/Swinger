package com.example.swinger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.TextKeyListener;
import android.view.View;
import android.widget.EditText;

import java.util.HashMap;

public class SetUpActivity extends AppCompatActivity {
    private EditText name;
    public int[] holeHits = new int[18]; // array to tracks hits for player 1 on each hole

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up);
        name = findViewById(R.id.playerName);
    }

    public void gotoHole1(View view) {
        Intent intent = new Intent(this, Hole1Activity.class);

        HashMap<Integer, Integer> player1ScoreList = new HashMap<>();
        HashMap<Integer, Integer> player2ScoreList = new HashMap<>();
        HashMap<Integer, Integer> player3ScoreList = new HashMap<>();
        HashMap<Integer, Integer> player4ScoreList = new HashMap<>();

        intent.putExtra("player1ScoreList", player1ScoreList);
        intent.putExtra("player2ScoreList", player2ScoreList);
        intent.putExtra("player3ScoreList", player3ScoreList);
        intent.putExtra("player4ScoreList", player4ScoreList);

        intent.putExtra("player1Name", capitalize(name));
//        intent.putExtra("player1HoleHits", holeHits);

        intent.putExtra("player2Name","Player2");
//        intent.putExtra("player2HoleHits", holeHits);

        intent.putExtra("player3Name", "Player3");
//        intent.putExtra("player3HoleHits", holeHits);

        intent.putExtra("player4Name", "Player4");
//        intent.putExtra("player4HoleHits", holeHits);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }

    public void goHome(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }

    public String capitalize(EditText name){
        return name.getText().toString().substring(0, 1).toUpperCase() + name.getText().toString().substring(1);
    }
}