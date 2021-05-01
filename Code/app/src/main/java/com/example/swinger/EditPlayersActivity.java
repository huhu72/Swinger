package com.example.swinger;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditPlayersActivity extends AppCompatActivity {
    private Button removePlayer1;
    private Button removePlayer2;
    private Button removePlayer3;
    private Button removePlayer4;

    private boolean player1Exists;
    private boolean player2Exists;
    private boolean player3Exists;
    private boolean player4Exists;

    private Button save;
    String player1Name;
    String player2Name;
    String player3Name;
    String player4Name;
    private EditText player1;
    private EditText player2;
    private EditText player3;
    private EditText player4;

    private View.OnClickListener player1Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            player1Exists = false;
        }
    };

    private View.OnClickListener player2Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            player2Exists = false;
        }
    };

    private View.OnClickListener player3Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            player3Exists = false;
        }
    };

    private View.OnClickListener player4Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            player4Exists = false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_players);

        player1 = findViewById(R.id.editPlayers_player1);
        player2 = findViewById(R.id.editPlayers_player2);
        player3 = findViewById(R.id.editPlayers_player3);
        player4 = findViewById(R.id.editPlayers_player4);

        Bundle extras = getIntent().getExtras();

        player1Exists = extras.getBoolean("player1Exists");
        Log.i("Player 1 Created in Edit Players", String.valueOf(extras.getBoolean("player1Exists")) );
        player2Exists = extras.getBoolean("player2Exists");
        Log.i("Player 2 Created in Edit Players", String.valueOf(extras.getBoolean("player2Exists")) );
        player3Exists = extras.getBoolean("player3Exists");
        Log.i("Player 3 Created in Edit Players", String.valueOf(extras.getBoolean("player3Exists")) );
        player4Exists = extras.getBoolean("player4Exists");
        Log.i("Player 4 Created in Edit Players", String.valueOf(extras.getBoolean("player4Exists")) );

        if (extras != null) {
            if (extras.containsKey("p1")){
                player1Name = extras.getString("p1");
                player1.setText(player1Name);

            }
            if (extras.containsKey("p2")){
                player2Name = extras.getString("p2");
                player2.setText(player2Name);
            }
            if (extras.containsKey("p3")){
                player3Name = extras.getString("p3");
                player3.setText(player3Name);

            }
            if (extras.containsKey("p4")){
                player4Name = extras.getString("p4");
                player4.setText(player4Name);

            }
        }
        removePlayer1 = findViewById(R.id.editPlayer_delete_player1_btn);
        removePlayer2 = findViewById(R.id.editPlayer_delete_player2_btn);
        removePlayer3 = findViewById(R.id.editPlayer_delete_player3_btn);
        removePlayer4 = findViewById(R.id.editPlayer_delete_player4_btn);

        save = findViewById(R.id.edit_players_saveBtn);

//        Bundle extras = data.getExtras();

        removePlayer1.setOnClickListener(player1Listener);
        removePlayer2.setOnClickListener(player2Listener);
        removePlayer3.setOnClickListener(player3Listener);
        removePlayer4.setOnClickListener(player4Listener);
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
//        if(player1.getText().toString() != null) {
            player1Name = player1.getText().toString();
            player1.setText(player1Name);
//        }
//        if(player2.getText().toString() != null) {
            player2Name = player2.getText().toString();
            player2.setText(player2Name);
//        }
//        if(player3.getText().toString() != null) {
            player3Name = player3.getText().toString();
            player3.setText(player3Name);
//        }
//        if(player4.getText().toString() != null) {
            player4Name = player4.getText().toString();
            player4.setText(player4Name);
//        }

        Intent intent = new Intent(this, SettingsActivity.class);
        Bundle bundle = new Bundle();

        if(player1.getText().toString()!=null) {
            bundle.putString("p1", capitalize(player1Name));
            intent.putExtras(bundle);
            Log.i("player1", String.valueOf(player1.getText()));
        }
        if(player2.getText().toString()!=null) {
            bundle.putString("p2", capitalize(player2Name));
            intent.putExtras(bundle);
            Log.i("player2", String.valueOf(player2.getText()));
        }
        if(player3.getText().toString()!=null) {
            bundle.putString("p3", capitalize(player3Name));
            intent.putExtras(bundle);
            Log.i("player3", String.valueOf(player3.getText()));
        }
        if(player4.getText().toString()!=null) {
            bundle.putString("p4", capitalize(player4Name));
            intent.putExtras(bundle);
            Log.i("player4", String.valueOf(player4.getText()));
        }


        bundle.putBoolean("player1Exists", player1Exists);
        Log.i("Edit Players in Save Player1: ", String.valueOf(bundle.getBoolean("player1Exists")));
        bundle.putBoolean("player2Exists", player2Exists);
        Log.i("Edit Players in Save Player2: ", String.valueOf(bundle.getBoolean("player2Exists")));
        bundle.putBoolean("player3Exists", player3Exists);
        Log.i("Edit Players in Save Player3: ", String.valueOf(bundle.getBoolean("player3Exists")));
        bundle.putBoolean("player4Exists", player4Exists);
        Log.i("Edit Players in Save Player4: ", String.valueOf(bundle.getBoolean("player4Exists")));

        setResult(Activity.RESULT_OK, intent);
        finish();
    }
    public String capitalize(String name){
        return name.toUpperCase();
    }

}