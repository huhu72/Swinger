package com.example.swinger;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Hole17Activity extends AppCompatActivity {


    public HoleConfig config = new HoleConfig(17);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hole17);
        config.buildHole(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        config.reloadIntentArgs();
    }

}