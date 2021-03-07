package com.example.swinger;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class HoleConfig extends AppCompatActivity {

    int holeNumber;
    int numPars = 6;

    String[] parNames = new String[numPars];
    int[] parIDs = new int[numPars];
    Button[] parViews = new Button[numPars];

    String hitsName = "";
    int hitsID = 0;
    EditText hitsView = null;

    String scoreName = "";
    int scoreID = 0;
    TextView scoreView = null;

    String playerName = "";
    int playerID = 0;
    TextView playerView = null;

    String player1Hits = "0";
    String player1Score = "0";
    String player1Name = "No Name Set!";

    String nextButtonName = "";
    int nextButtonID = 0;
    ImageView nextButtonView = null;

    String prevButtonName = "";
    int prevButtonID = 0;
    ImageView prevButtonView = null;

    String settingsButtonName = "";
    int settingsButtonID = 0;
    Button settingsButtonView = null;

    Activity holeActivity;


    Class[] holeClasses = new Class[] {
            Hole1Activity.class,
            Hole2Activity.class,
            Hole3Activity.class,
            Hole4Activity.class,
            Hole5Activity.class,
            Hole6Activity.class,
            Hole7Activity.class,
            Hole8Activity.class,
            Hole9Activity.class,
            Hole10Activity.class,
            Hole11Activity.class,
            Hole12Activity.class,
            Hole13Activity.class,
            Hole14Activity.class,
            Hole15Activity.class,
            Hole16Activity.class,
            Hole17Activity.class,
            Hole18Activity.class,
    };

    public HoleConfig(int holeNumber){
        this.holeNumber = holeNumber;
    }

    public void buildHole(Activity activity){
        this.holeActivity = activity;

        Log.i("activity exists?: ", String.valueOf(holeActivity));

        initializeParButtons();
        initializeLabels();
        initializeButtons();
    }

    public void reloadIntentArgs(){
        Log.i("Info: ", "Activity " + holeNumber + " Resumed!");
        try {
            player1Score = holeActivity.getIntent().getStringExtra("player1Score");
            player1Name = holeActivity.getIntent().getStringExtra("player1Name");
            Log.i("Info:", "Intent score " + player1Score);

        } catch (Exception e){
            Log.i("Error:", "Problem with getIntent()", e);
        }

        scoreView.setText(player1Score);
        playerView.setText(player1Name);
    }

    public int calcScoreOnParClick(int par, EditText view){

        String hitsStr = view.getText().toString();

        if (hitsStr.equals("")){
            return 0;
        }

        int hits = Integer.parseInt(hitsStr);
        return hits - par;
    }

    public void initializeButtons() {
        String idPrefix = "hole";
        String nextButtonSuffix = "_nextHole";
        String prevButtonSuffix = "_prevHole";
        String settingsButtonSuffix = "_settings_btn";

        nextButtonName = idPrefix + String.valueOf(holeNumber) + nextButtonSuffix;
        prevButtonName = idPrefix + String.valueOf(holeNumber) + prevButtonSuffix;
        settingsButtonName = idPrefix + String.valueOf(holeNumber) + settingsButtonSuffix;

        try {
            nextButtonID = holeActivity.getResources().getIdentifier(nextButtonName, "id", holeActivity.getPackageName());
            nextButtonView = holeActivity.findViewById(nextButtonID);
            nextButtonView.setOnClickListener(nextHole);

        } catch (Exception e){
            Log.i("f", "Exception init next button", e);
        }

        try {
            prevButtonID = holeActivity.getResources().getIdentifier(prevButtonName, "id", holeActivity.getPackageName());
            prevButtonView = holeActivity.findViewById(prevButtonID);
            prevButtonView.setOnClickListener(prevHole);

        } catch (Exception e){
            Log.i("f", "Exception init prev button");
        }

        settingsButtonID = holeActivity.getResources().getIdentifier(settingsButtonName, "id", holeActivity.getPackageName());
        settingsButtonView = holeActivity.findViewById(settingsButtonID);
        settingsButtonView.setOnClickListener(openSettings);

    }

    public View[] initializeLabels(){
        String idPrefix = "hole";
        String playerSuffix = "_playerOne";
        String hitsSuffix = "_player1Hits";
        String scoreSuffix = "_player1Score";

        playerName = idPrefix + String.valueOf(holeNumber) + playerSuffix;
        hitsName = idPrefix + String.valueOf(holeNumber) + hitsSuffix;
        scoreName = idPrefix + String.valueOf(holeNumber) + scoreSuffix;

        playerID = holeActivity.getResources().getIdentifier(playerName, "id", holeActivity.getPackageName());
        hitsID = holeActivity.getResources().getIdentifier(hitsName, "id", holeActivity.getPackageName());
        scoreID = holeActivity.getResources().getIdentifier(scoreName, "id", holeActivity.getPackageName());

        playerView = holeActivity.findViewById(playerID);
        hitsView = holeActivity.findViewById(hitsID);
        scoreView = holeActivity.findViewById(scoreID);

        hitsView.addTextChangedListener(hitsTextWatcher);

        try {
            player1Score = holeActivity.getIntent().getStringExtra("player1Score");
            player1Name = holeActivity.getIntent().getStringExtra("player1Name");
        } catch (Exception e){
            Log.i("Error:", "Problem with getIntent()", e);
        }

        // params are initialized with visibly dummy values in case they aren't passed in intent
        hitsView.setText(player1Hits);
        scoreView.setText(player1Score);
        playerView.setText(player1Name);


        View[] views = new View[] {playerView, hitsView, scoreView};
        return views;
    }

    public View[] initializeParButtons(){
        String idPrefix = "hole";
        String idMidfix = "_par";
        String idSuffix = "Btn";
        String id = "";

        for (int i = 0; i < numPars; i++){
            id = idPrefix + String.valueOf(holeNumber) + idMidfix + String.valueOf(i + 1) + idSuffix;
            int idObject = this.holeActivity.getResources().getIdentifier(id, "id", this.holeActivity.getPackageName());
            Button parView = this.holeActivity.findViewById(idObject);

            parView.setOnClickListener(parButtonListener);
            parViews[i] = parView;
        }

        return parViews;
    }

    public void clearButtonBackground(){
        for (Button btn : parViews) {
            btn.setBackgroundResource(0);
            btn.setTextColor(Color.parseColor("#FFFFFF")); // white hex code
        }
    }

    private OnClickListener parButtonListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            int btnID = v.getId();
            Button parButton = null;
            int parValue = 0;

            for (int i = 0; i < numPars; i++) {
                int testID = parViews[i].getId();

                if (btnID == testID){
                    parButton = parViews[i];
                    parValue = i + 1;
                    break;
                }
            }

            if (parButton == null){
                return;
            }

            clearButtonBackground();
            parButton.setBackgroundResource(R.drawable.par_selected);
            parButton.setTextColor(Color.parseColor("#000000")); // black
            scoreView.setText(String.valueOf(calcScoreOnParClick(parValue, hitsView)));
        }
    };

    public TextWatcher hitsTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            SpannableString spannableString = new SpannableString(s);
            String inputStr = spannableString.toString();

            if(!inputStr.equals("")) {
                int inputHits = Integer.parseInt(inputStr);

                for (int h = 0; h < numPars; h++){
                    boolean foundSelectedPar = false;
                    int parNum = 0;

                    if (parViews[h].getBackground() != null){
                        foundSelectedPar = true;
                        parNum = h + 1; // offset by 1 because var h is an index
                    }

                    if (foundSelectedPar){
                        int total = inputHits - parNum;
                        player1Score = String.valueOf(total);
                        scoreView.setText(player1Score);
                        break;
                    }
                }
            }
            return;
        }

        @Override
        public void afterTextChanged(Editable s) { }
    };


    public OnClickListener nextHole = new OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(holeActivity.getApplicationContext(), holeClasses[holeNumber]);
            intent.putExtra("player1Name", player1Name);
            intent.putExtra("player1Score", scoreView.getText().toString());
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            holeActivity.startActivity(intent);
        }
    };

    public OnClickListener prevHole = new OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(holeActivity.getApplicationContext(), holeClasses[holeNumber - 1] );
            player1Name = playerView.getText().toString();
            intent.putExtra("player1Name", player1Name);
            intent.putExtra("player1Score", scoreView.getText().toString());
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            holeActivity.startActivity(intent);
        }
    };

    public OnClickListener openSettings = new OnClickListener() {

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(holeActivity.getApplicationContext(), SettingsActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            holeActivity.startActivity(intent);
        }
    };
}
