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

        player1 = findViewById(R.id.editPlayers_player1);
        player2 = findViewById(R.id.editPlayers_player2);
        player3 = findViewById(R.id.editPlayers_player3);
        player4 = findViewById(R.id.editPlayers_player4);

        Bundle extras = getIntent().getExtras();

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
//        removePlayer1 = findViewById(R.id.editPlayer_delete_player1_btn);
//        removePlayer2 = findViewById(R.id.editPlayer_delete_player2_btn);
//        removePlayer3 = findViewById(R.id.editPlayer_delete_player3_btn);
//        removePlayer4 = findViewById(R.id.editPlayer_delete_player4_btn);

        save = findViewById(R.id.edit_players_saveBtn);




//        removePlayer1.setOnClickListener(v -> {
//                    removePlayer1.setVisibility(View.GONE);
//                    player1.setVisibility(View.GONE);
//                }
//                );
//        removePlayer2.setOnClickListener(view ->{
//            removePlayer2.setVisibility(View.GONE);
//            player2.setVisibility(View.GONE);
//        });
//        removePlayer3.setOnClickListener(view ->{
//            removePlayer3.setVisibility(View.GONE);
//            player3.setVisibility(View.GONE);
//        });
//        removePlayer4.setOnClickListener(view ->{
//            removePlayer4.setVisibility(View.GONE);
//            player4.setVisibility(View.GONE);
//        });
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
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
    public String capitalize(String name){
        return name.toUpperCase();
    }

}