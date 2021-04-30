package com.example.swinger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class SettingsActivity extends AppCompatActivity {
    String player1="NA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
           player1 = extras.getString("p1");
        }
    }

    public void gotoEditPlayer(View view) {
        Intent intent = new Intent(this, EditPlayersActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("p1", capitalize(player1));
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void save(View view) {
        Intent intent = new Intent(this, Hole1Activity.class);
        startActivity(intent);
    }
    public String capitalize(String name){
        return name.toUpperCase();
    }
}

