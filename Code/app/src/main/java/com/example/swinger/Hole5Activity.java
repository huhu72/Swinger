package com.example.swinger;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Hole5Activity extends AppCompatActivity implements View.OnClickListener {

    private Button parBtns[];
    private Button par1;
    private Button par2;
    private Button par3;
    private Button par4;
    private Button par5;
    private Button par6;
    private ImageButton nextHole2;
    private ImageButton prevHole;
    private String playerName;
    private TextView player1;
    private EditText p1Hits;
    private TextView p1score;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hole5);
        par1 = findViewById(R.id.par1Btn);
        par2 = findViewById(R.id.par2Btn);
        par3 = findViewById(R.id.par3Btn);
        par4 = findViewById(R.id.par4Btn);
        par5 = findViewById(R.id.par5Btn);
        par6 = findViewById(R.id.par6Btn);
        nextHole2 = findViewById(R.id.nextHole5);
        prevHole = findViewById(R.id.prevHole4);
        player1 = findViewById(R.id.playerOne);
        parBtns = new Button[]{par1,par2,par3,par4,par5,par6};
        par1.setOnClickListener(this);
        par2.setOnClickListener(this);
        par3.setOnClickListener(this);
        par4.setOnClickListener(this);
        par5.setOnClickListener(this);
        par6.setOnClickListener(this);
        playerName = getIntent().getStringExtra("playerName");
        player1.setText(playerName);
        nextHole2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextHole2();
            }
        });
        prevHole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prevHole();
            }
        });

        p1Hits = findViewById(R.id.player1Hits);
        p1score = findViewById(R.id.player1Score);

        if(p1Hits==null){
            return;
        }

        p1Hits.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                SpannableString spannableString = new SpannableString(s);
                String so = spannableString.toString();
                int i = 0;

                String total = " ";

            if(!so.equals("")) {
                i = Integer.parseInt(so);
                if (par1.getBackground() != null) {

                    total = Integer.toString(i - 1);
                    p1score.setText(total);
                } else if (par2.getBackground() != null) {

                    total = Integer.toString(i - 2);
                    p1score.setText(total);
                } else if (par3.getBackground() != null) {

                    total = Integer.toString(i - 3);
                    p1score.setText(total);
                } else if (par4.getBackground() != null) {

                    total = Integer.toString(i - 4);
                    p1score.setText(total);
                } else if (par5.getBackground() != null) {

                    total = Integer.toString(i - 5);
                    p1score.setText(total);
                } else if (par6.getBackground() != null) {

                    total = Integer.toString(i - 6);
                    p1score.setText(total);
                }
            }
            else{
                return;
            }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
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


    public void openSettings(View view){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);

    }

    public void nextHole2(){
        Intent intent = new Intent(this, Hole6Activity.class);
        playerName = player1.getText().toString();
        intent.putExtra("playerName", playerName);
        startActivity(intent);
    }

    public void prevHole(){
        Intent intent = new Intent(this, Hole4Activity.class);
        playerName = player1.getText().toString();
        intent.putExtra("playerName", playerName);
        startActivity(intent);
    }
}