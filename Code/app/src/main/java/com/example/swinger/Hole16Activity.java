package com.example.swinger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Hole16Activity extends AppCompatActivity implements OnClickListener {

    private Button parBtns[];
    private Button par1;
    private Button par2;
    private Button par3;
    private Button par4;
    private Button par5;
    private Button par6;
    private String player1Name;
    private String player1Score;
    private TextView player1;
    private EditText p1Hits;
    private TextView p1score;

    private int calcScoreOnParClick(int par, EditText view){

        String hitsStr = view.getText().toString();

        if (hitsStr.equals("")){
            return 0;
        }

        int hits = Integer.parseInt(hitsStr);
        int calcScore = hits - par;
        return calcScore;
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hole16);
        par1 = findViewById(R.id.hole16_par1Btn);
        par2 = findViewById(R.id.hole16_par2Btn);
        par3 = findViewById(R.id.hole16_par3Btn);
        par4 = findViewById(R.id.hole16_par4Btn);
        par5 = findViewById(R.id.hole16_par5Btn);
        par6 = findViewById(R.id.hole16_par6Btn);
        player1 = findViewById(R.id.hole16_playerOne);
        parBtns = new Button[]{par1,par2,par3,par4,par5,par6};
        p1Hits = findViewById(R.id.hole16_player1Hits);
        p1score = findViewById(R.id.hole16_player1Score);
        player1Name = getIntent().getStringExtra("player1Name");
        player1Score = getIntent().getStringExtra("player1Score");
        player1.setText(player1Name);
        if(player1Score != null || player1Score != "") {
            p1score.setText(player1Score);
        }
        if(p1Hits==null){
            return;
        }

        par1.setOnClickListener(this);
        par2.setOnClickListener(this);
        par3.setOnClickListener(this);
        par4.setOnClickListener(this);
        par5.setOnClickListener(this);
        par6.setOnClickListener(this);

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
            case R.id.hole16_par1Btn:
                clearButtonBackground();
                par1.setBackgroundResource(R.drawable.par_selected);
                par1.setTextColor(getColor(R.color.black));
                p1score.setText(String.valueOf(calcScoreOnParClick(1, p1Hits)));
                break;
            case R.id.hole16_par2Btn:
                clearButtonBackground();
                par2.setBackgroundResource(R.drawable.par_selected);
                par2.setTextColor(getColor(R.color.black));
                p1score.setText(String.valueOf(calcScoreOnParClick(2, p1Hits)));
                break;
            case R.id.hole16_par3Btn:
                clearButtonBackground();
                par3.setBackgroundResource(R.drawable.par_selected);
                par3.setTextColor(getColor(R.color.black));
                p1score.setText(String.valueOf(calcScoreOnParClick(3, p1Hits)));
                break;
            case R.id.hole16_par4Btn:
                clearButtonBackground();
                par4.setBackgroundResource(R.drawable.par_selected);
                par4.setTextColor(getColor(R.color.black));
                p1score.setText(String.valueOf(calcScoreOnParClick(4, p1Hits)));
                break;
            case R.id.hole16_par5Btn:
                clearButtonBackground();
                par5.setBackgroundResource(R.drawable.par_selected);
                par5.setTextColor(getColor(R.color.black));
                p1score.setText(String.valueOf(calcScoreOnParClick(5, p1Hits)));
                break;
            case R.id.hole16_par6Btn:
                clearButtonBackground();
                par6.setBackgroundResource(R.drawable.par_selected);
                par6.setTextColor(getColor(R.color.black));
                p1score.setText(String.valueOf(calcScoreOnParClick(6, p1Hits)));
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

    public void nextHole(View view){
        Intent intent = new Intent(this, Hole16Activity.class);
        player1Name = player1.getText().toString();
        intent.putExtra("player1Name", player1Name);
        intent.putExtra("player1Score", p1score.getText().toString());
        startActivity(intent);
    }
    public void prevHole(View view){
        Intent intent = new Intent(this, Hole14Activity.class);
        player1Name = player1.getText().toString();
        intent.putExtra("player1Name", player1Name);
        intent.putExtra("player1Score", p1score.getText().toString());
        startActivity(intent);
    }

}