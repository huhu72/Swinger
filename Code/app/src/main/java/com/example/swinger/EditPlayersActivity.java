package com.example.swinger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditPlayersActivity extends AppCompatActivity {
    private Button removePlayer1;
    private Button removePlayer2;
    private Button removePlayer3;
    private Button removePlayer4;
    private Button save;
    String player1Name;
    String player2Name;
    String player3Name;
    String player4Name;
    private EditText player1;
    private EditText player2;
    private EditText player3;
    private EditText player4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_players);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            player1Name = extras.getString("p1");
        }
        removePlayer1 = findViewById(R.id.editPlayer_delete_player1_btn);
        removePlayer2 = findViewById(R.id.editPlayer_delete_player2_btn);
        removePlayer3 = findViewById(R.id.editPlayer_delete_player3_btn);
        removePlayer4 = findViewById(R.id.editPlayer_delete_player4_btn);
        save = findViewById(R.id.edit_players_saveBtn);
        player1 = findViewById(R.id.editPlayers_player1);
        player2 = findViewById(R.id.editPlayers_player2);
        player3 = findViewById(R.id.editPlayers_player3);
        player4 = findViewById(R.id.editPlayers_player4);
        player1.setText(player1Name);

    }
    public void removePlayer1(View view){
        player1.setText("");
    }
    public void removePlayer2(View view){
        player2.setText("");
    }
    public void removePlayer3(View view){
        player3.setText("");
    }
    public void removePlayer4(View view){
        player4.setText("");
    }
    public void save(View view){
        if(player1.getText().toString() != null) {
            player1Name = player1.getText().toString();
            player1.setText(player1Name);
        }
        if(player2.getText().toString() != null) {
            player2Name = player2.getText().toString();
            player2.setText(player2Name);
        }
        if(player3.getText().toString() != null) {
            player3Name = player3.getText().toString();
            player3.setText(player3Name);
        }
        if(player4.getText().toString() != null) {
            player4Name = player4.getText().toString();
            player4.setText(player4Name);
        }
    }

}