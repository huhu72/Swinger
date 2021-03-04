package com.example.swinger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SetUpActivity extends AppCompatActivity {
    private EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up);
        name = findViewById(R.id.playerName);
    }

    public void gotoHole1(View view) {
        Intent intent = new Intent(this, Hole1Activity.class);
        intent.putExtra("playerName", capitalize(name));
        startActivity(intent);
    }

    public void goHome(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    public String capitalize(EditText name){
        return name.getText().toString().substring(0, 1).toUpperCase() + name.getText().toString().substring(1);
    }
}