package com.example.swinger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SetUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up);
    }
    public void openHole1(View view){
        Intent intent1 = new Intent(this, Hole1Activity.class);
        startActivity(intent1);
    }
}