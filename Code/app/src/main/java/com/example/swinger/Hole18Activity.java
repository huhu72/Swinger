package com.example.swinger;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Hole18Activity extends AppCompatActivity {


    public HoleConfig config = new HoleConfig(18);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hole18);
        config.buildHole(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        config.reloadIntentArgs();
    }

}