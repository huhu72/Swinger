package com.example.swinger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EditPlayersActivity extends AppCompatActivity implements View.OnClickListener {
    private Button removePlayer1;
    private Button removePlayer2;
    private Button removePlayer3;
    private Button removePlayer4;
    private TextView player1;
    private TextView player2;
    private TextView player3;
    private TextView player4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_players);
        removePlayer1 = findViewById(R.id.editPlayer_delete_player1_btn);
        removePlayer2 = findViewById(R.id.editPlayer_delete_player2_btn);
        removePlayer3 = findViewById(R.id.editPlayer_delete_player3_btn);
        removePlayer4 = findViewById(R.id.editPlayer_delete_player4_btn);
        player1 = findViewById(R.id.editPlayers_player1);
        player2 = findViewById(R.id.editPlayers_player2);
        player3 = findViewById(R.id.editPlayers_player3);
        player4 = findViewById(R.id.editPlayers_player4);
        removePlayer1.setOnClickListener(this);
        removePlayer2.setOnClickListener(this);
        removePlayer3.setOnClickListener(this);
        removePlayer4.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.editPlayer_delete_player1_btn:
                removePlayer1.setVisibility(View.GONE);
                player1.setVisibility(View.GONE);
                break;
            case R.id.editPlayer_delete_player2_btn:
                removePlayer2.setVisibility(View.GONE);
                player2.setVisibility(View.GONE);
                break;
            case R.id.editPlayer_delete_player3_btn:
                removePlayer3.setVisibility(View.GONE);
                player3.setVisibility(View.GONE);
                break;
            case R.id.editPlayer_delete_player4_btn:
                removePlayer4.setVisibility(View.GONE);
                player4.setVisibility(View.GONE);
                break;

            default:
                break;
        }
    }


}