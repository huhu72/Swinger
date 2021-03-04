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
<<<<<<< HEAD
    public void gotoHole1(View view){
        Intent intent = new Intent(this, Hole1Activity.class);
        startActivity(intent);
    }
    public void goHome(View view){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
=======
    public void openHole1(View view){
        Intent intent1 = new Intent(this, Hole1Activity.class);
        startActivity(intent1);
>>>>>>> 0c3766b468efba1da57dda334ec93d41afaf4bed
    }
}