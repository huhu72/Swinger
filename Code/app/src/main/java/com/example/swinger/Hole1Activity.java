package com.example.swinger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Hole1Activity extends AppCompatActivity implements View.OnClickListener {

    private Button parBtns[];
    private Button par1;
    private Button par2;
    private Button par3;
    private Button par4;
    private Button par5;
    private Button par6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hole1);
        par1 = findViewById(R.id.par1Btn);
        par2 = findViewById(R.id.par2Btn);
        par3 = findViewById(R.id.par3Btn);
        par4 = findViewById(R.id.par4Btn);
        par5 = findViewById(R.id.par5Btn);
        par6 = findViewById(R.id.par6Btn);
        parBtns = new Button[]{par1,par2,par3,par4,par5,par6};
        par1.setOnClickListener(this);
        par2.setOnClickListener(this);
        par3.setOnClickListener(this);
        par4.setOnClickListener(this);
        par5.setOnClickListener(this);
        par6.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.par1Btn:
                clearButtonBackground();
                par1.setBackgroundResource(R.drawable.par_selected);
                par1.setTextColor(getColor(R.color.black));
                break;
            case R.id.par2Btn:
                clearButtonBackground();
                par2.setBackgroundResource(R.drawable.par_selected);
                par2.setTextColor(getColor(R.color.black));
                break;
            case R.id.par3Btn:
                clearButtonBackground();
                par3.setBackgroundResource(R.drawable.par_selected);
                par3.setTextColor(getColor(R.color.black));
                break;
            case R.id.par4Btn:
                clearButtonBackground();
                par4.setBackgroundResource(R.drawable.par_selected);
                par4.setTextColor(getColor(R.color.black));
                break;
            case R.id.par5Btn:
                clearButtonBackground();
                par5.setBackgroundResource(R.drawable.par_selected);
                par5.setTextColor(getColor(R.color.black));
                break;
            case R.id.par6Btn:
                clearButtonBackground();
                par6.setBackgroundResource(R.drawable.par_selected);
                par6.setTextColor(getColor(R.color.black));
                break;
            default:
                break;
        }
    }
    public void clearButtonBackground(){
        for (Button btn : parBtns) {
            btn.setBackgroundResource(0);
            btn.setTextColor(getColor(R.color.white));
        }
    }
}