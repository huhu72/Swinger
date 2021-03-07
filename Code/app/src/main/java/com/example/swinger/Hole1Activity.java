package com.example.swinger;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
public class Hole1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HoleConfig holeConfig = new HoleConfig(1);
        holeConfig.buildHole(this);
    }
}