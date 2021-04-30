package com.example.swinger;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
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

    // PLAYER 1
    String player1HitsTemp = "";
    int player1HitsID = 0;
    EditText player1HitsView = null;

    String player1ScoreTemp = "";
    int player1ScoreID = 0;
    TextView player1ScoreView = null;

    String player1NameTemp = "";
    int player1ID = 0;
    TextView player1View = null;

    String player1Hits = "0";
    String player1Score = "0";
    String player1Name = "No Name Set!";

    int[] player1HoleHits = new int[18];

    // PLAYER 2
    String player2HitsTemp = "";
    int player2HitsID = 0;
    EditText player2HitsView = null;

    String player2ScoreTemp = "";
    int player2ScoreID = 0;
    TextView player2ScoreView = null;

    String player2NameTemp = "";
    int player2ID = 0;
    TextView player2View = null;

    String player2Hits = "0";
    String player2Score = "0";
    String player2Name = "No Name Set!";

    int[] player2HoleHits = new int[18];

    // PLAYER 3
    String player3HitsTemp = "";
    int player3HitsID = 0;
    EditText player3HitsView = null;

    String player3ScoreTemp = "";
    int player3ScoreID = 0;
    TextView player3ScoreView = null;

    String player3NameTemp = "";
    int player3ID = 0;
    TextView player3View = null;

    String player3Hits = "0";
    String player3Score = "0";
    String player3Name = "No Name Set!";

    int[] player3HoleHits = new int[18];

    // PLAYER 4
    String player4HitsTemp = "";
    int player4HitsID = 0;
    EditText player4HitsView = null;

    String player4ScoreTemp = "";
    int player4ScoreID = 0;
    TextView player4ScoreView = null;

    String player4NameTemp = "";
    int player4ID = 0;
    TextView player4View = null;

    String player4Hits = "0";
    String player4Score = "0";
    String player4Name = "No Name Set!";

    int[] player4HoleHits = new int[18];

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

        try {
            player2Score = holeActivity.getIntent().getStringExtra("player2Score");
            player2Name = holeActivity.getIntent().getStringExtra("player2Name");
            Log.i("Info:", "Intent score " + player2Score);

        } catch (Exception e){
            Log.i("Error:", "Problem with getIntent()", e);
        }

        try {
            player3Score = holeActivity.getIntent().getStringExtra("player3Score");
            player3Name = holeActivity.getIntent().getStringExtra("player3Name");
            Log.i("Info:", "Intent score " + player3Score);

        } catch (Exception e){
            Log.i("Error:", "Problem with getIntent()", e);
        }

        try {
            player4Score = holeActivity.getIntent().getStringExtra("player4Score");
            player4Name = holeActivity.getIntent().getStringExtra("player4Name");
            Log.i("Info:", "Intent score " + player4Score);

        } catch (Exception e){
            Log.i("Error:", "Problem with getIntent()", e);
        }

        player1ScoreView.setText(player1Score);
        player1View.setText(player1Name);

        player2ScoreView.setText(player2Score);
        player2View.setText(player2Name);

        player3ScoreView.setText(player3Score);
        player3View.setText(player3Name);

        player4ScoreView.setText(player4Score);
        player4View.setText(player4Name);
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
        String[] playerSuffix = new String[] {"_playerOne", "_playerTwo", "_playerThree", "_playerFour"};
        String[] hitsSuffix = new String[] {"_player1Hits", "_player2Hits", "_player3Hits", "_player4Hits"};
        String[] scoreSuffix = new String[] {"_player1Score", "_player2Score", "_player3Score", "_player4Score"};

//        String playerSuffix = "_playerOne";
//        String hitsSuffix = "_player1Hits";
//        String scoreSuffix = "_player1Score";

        player1NameTemp = idPrefix + String.valueOf(holeNumber) + playerSuffix[0];
        player1HitsTemp = idPrefix + String.valueOf(holeNumber) + hitsSuffix[0];
        player1ScoreTemp = idPrefix + String.valueOf(holeNumber) + scoreSuffix[0];

        player2NameTemp = idPrefix + String.valueOf(holeNumber) + playerSuffix[1];
        player2HitsTemp = idPrefix + String.valueOf(holeNumber) + hitsSuffix[1];
        player2ScoreTemp = idPrefix + String.valueOf(holeNumber) + scoreSuffix[1];

        player3NameTemp = idPrefix + String.valueOf(holeNumber) + playerSuffix[2];
        player3HitsTemp = idPrefix + String.valueOf(holeNumber) + hitsSuffix[2];
        player3ScoreTemp = idPrefix + String.valueOf(holeNumber) + scoreSuffix[2];

        player4NameTemp = idPrefix + String.valueOf(holeNumber) + playerSuffix[3];
        player4HitsTemp = idPrefix + String.valueOf(holeNumber) + hitsSuffix[3];
        player4ScoreTemp = idPrefix + String.valueOf(holeNumber) + scoreSuffix[3];

        player1ID = holeActivity.getResources().getIdentifier(player1NameTemp, "id", holeActivity.getPackageName());
        player1HitsID = holeActivity.getResources().getIdentifier(player1HitsTemp, "id", holeActivity.getPackageName());
        player1ScoreID = holeActivity.getResources().getIdentifier(player1ScoreTemp, "id", holeActivity.getPackageName());

        player2ID = holeActivity.getResources().getIdentifier(player2NameTemp, "id", holeActivity.getPackageName());
        player2HitsID = holeActivity.getResources().getIdentifier(player2HitsTemp, "id", holeActivity.getPackageName());
        player2ScoreID = holeActivity.getResources().getIdentifier(player2ScoreTemp, "id", holeActivity.getPackageName());

        player3ID = holeActivity.getResources().getIdentifier(player3NameTemp, "id", holeActivity.getPackageName());
        player3HitsID = holeActivity.getResources().getIdentifier(player3HitsTemp, "id", holeActivity.getPackageName());
        player3ScoreID = holeActivity.getResources().getIdentifier(player3ScoreTemp, "id", holeActivity.getPackageName());

        player4ID = holeActivity.getResources().getIdentifier(player4NameTemp, "id", holeActivity.getPackageName());
        player4HitsID = holeActivity.getResources().getIdentifier(player4HitsTemp, "id", holeActivity.getPackageName());
        player4ScoreID = holeActivity.getResources().getIdentifier(player4ScoreTemp, "id", holeActivity.getPackageName());

        player1View = holeActivity.findViewById(player1ID);
        player1HitsView = holeActivity.findViewById(player1HitsID);
        player1ScoreView = holeActivity.findViewById(player1ScoreID);

        player1HitsView.addTextChangedListener(player1HitsTextWatcher);

        player2View = holeActivity.findViewById(player2ID);
        player2HitsView = holeActivity.findViewById(player2HitsID);
        player2ScoreView = holeActivity.findViewById(player2ScoreID);

        player2HitsView.addTextChangedListener(player2HitsTextWatcher);

        player3View = holeActivity.findViewById(player3ID);
        player3HitsView = holeActivity.findViewById(player3HitsID);
        player3ScoreView = holeActivity.findViewById(player3ScoreID);

        player3HitsView.addTextChangedListener(player3HitsTextWatcher);

        player4View = holeActivity.findViewById(player4ID);
        player4HitsView = holeActivity.findViewById(player4HitsID);
        player4ScoreView = holeActivity.findViewById(player4ScoreID);

        player4HitsView.addTextChangedListener(player4HitsTextWatcher);

        try {
            player1Score = holeActivity.getIntent().getStringExtra("player1Score");
            player1Name = holeActivity.getIntent().getStringExtra("player1Name");
            player1HoleHits = holeActivity.getIntent().getIntArrayExtra("player1HoleHits");
            player1Hits = String.valueOf(player1HoleHits[holeNumber -1]);

        } catch (Exception e){
            Log.i("Error:", "Problem with getIntent()", e);
        }

        try {
            player2Score = holeActivity.getIntent().getStringExtra("player2Score");
            player2Name = holeActivity.getIntent().getStringExtra("player2Name");
            player2HoleHits = holeActivity.getIntent().getIntArrayExtra("player2HoleHits");
            player2Hits = String.valueOf(player2HoleHits[holeNumber -1]);

        } catch (Exception e){
            Log.i("Error:", "Problem with getIntent()", e);
        }

        try {
            player3Score = holeActivity.getIntent().getStringExtra("player3Score");
            player3Name = holeActivity.getIntent().getStringExtra("player3Name");
            player3HoleHits = holeActivity.getIntent().getIntArrayExtra("player3HoleHits");
            player3Hits = String.valueOf(player3HoleHits[holeNumber -1]);

        } catch (Exception e){
            Log.i("Error:", "Problem with getIntent()", e);
        }

        try {
            player4Score = holeActivity.getIntent().getStringExtra("player4Score");
            player4Name = holeActivity.getIntent().getStringExtra("player4Name");
            player4HoleHits = holeActivity.getIntent().getIntArrayExtra("player4HoleHits");
            player4Hits = String.valueOf(player4HoleHits[holeNumber -1]);

        } catch (Exception e){
            Log.i("Error:", "Problem with getIntent()", e);
        }

        // params are initialized with visibly dummy values in case they aren't passed in intent
        player1HitsView.setText(player1Hits);
        player1ScoreView.setText(player1Score);
        player1View.setText(player1Name);

        player2HitsView.setText(player2Hits);
        player2ScoreView.setText(player2Score);
        player2View.setText(player2Name);

        player3HitsView.setText(player3Hits);
        player3ScoreView.setText(player3Score);
        player3View.setText(player3Name);

        player4HitsView.setText(player4Hits);
        player4ScoreView.setText(player4Score);
        player4View.setText(player4Name);


        View[] views = new View[] {player1View, player1HitsView, player1ScoreView};
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
            player1ScoreView.setText(String.valueOf(calcScoreOnParClick(parValue, player1HitsView)));
            player2ScoreView.setText(String.valueOf(calcScoreOnParClick(parValue, player2HitsView)));
            player3ScoreView.setText(String.valueOf(calcScoreOnParClick(parValue, player3HitsView)));
            player4ScoreView.setText(String.valueOf(calcScoreOnParClick(parValue, player4HitsView)));
        }
    };

    public TextWatcher player1HitsTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            SpannableString spannableString = new SpannableString(s);
            String inputStr = spannableString.toString();
            player1Hits = inputStr;


            if(!inputStr.equals("")) {
                int inputHits = Integer.parseInt(inputStr);
                player1HoleHits[holeNumber - 1] = inputHits;

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
                        player1ScoreView.setText(player1Score);
                        break;
                    }
                }
            } else {
                player1HoleHits[holeNumber - 1] = 0;

            }
            return;
        }

        @Override
        public void afterTextChanged(Editable s) { }
    };

    public TextWatcher player2HitsTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            SpannableString spannableString = new SpannableString(s);
            String inputStr = spannableString.toString();
            player1Hits = inputStr;


            if(!inputStr.equals("")) {
                int inputHits = Integer.parseInt(inputStr);
                player2HoleHits[holeNumber - 1] = inputHits;

                for (int h = 0; h < numPars; h++){
                    boolean foundSelectedPar = false;
                    int parNum = 0;

                    if (parViews[h].getBackground() != null){
                        foundSelectedPar = true;
                        parNum = h + 1; // offset by 1 because var h is an index
                    }

                    if (foundSelectedPar){
                        int total = inputHits - parNum;
                        player2Score = String.valueOf(total);
                        player2ScoreView.setText(player2Score);
                        break;
                    }
                }
            } else {
                player2HoleHits[holeNumber - 1] = 0;

            }
            return;
        }

        @Override
        public void afterTextChanged(Editable s) { }
    };

    public TextWatcher player3HitsTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            SpannableString spannableString = new SpannableString(s);
            String inputStr = spannableString.toString();
            player3Hits = inputStr;


            if(!inputStr.equals("")) {
                int inputHits = Integer.parseInt(inputStr);
                player3HoleHits[holeNumber - 1] = inputHits;

                for (int h = 0; h < numPars; h++){
                    boolean foundSelectedPar = false;
                    int parNum = 0;

                    if (parViews[h].getBackground() != null){
                        foundSelectedPar = true;
                        parNum = h + 1; // offset by 1 because var h is an index
                    }

                    if (foundSelectedPar){
                        int total = inputHits - parNum;
                        player3Score = String.valueOf(total);
                        player3ScoreView.setText(player3Score);
                        break;
                    }
                }
            } else {
                player3HoleHits[holeNumber - 1] = 0;

            }
            return;
        }

        @Override
        public void afterTextChanged(Editable s) { }
    };

    public TextWatcher player4HitsTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            SpannableString spannableString = new SpannableString(s);
            String inputStr = spannableString.toString();
            player4Hits = inputStr;


            if(!inputStr.equals("")) {
                int inputHits = Integer.parseInt(inputStr);
                player4HoleHits[holeNumber - 1] = inputHits;

                for (int h = 0; h < numPars; h++){
                    boolean foundSelectedPar = false;
                    int parNum = 0;

                    if (parViews[h].getBackground() != null){
                        foundSelectedPar = true;
                        parNum = h + 1; // offset by 1 because var h is an index
                    }

                    if (foundSelectedPar){
                        int total = inputHits - parNum;
                        player4Score = String.valueOf(total);
                        player4ScoreView.setText(player4Score);
                        break;
                    }
                }
            } else {
                player4HoleHits[holeNumber - 1] = 0;

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
            intent.putExtra("player1Score", player1ScoreView.getText().toString());
            intent.putExtra("player1HoleHits", player1HoleHits);

            intent.putExtra("player2Name", player2Name);
            intent.putExtra("player2Score", player2ScoreView.getText().toString());
            intent.putExtra("player2HoleHits", player2HoleHits);

            intent.putExtra("player3Name", player3Name);
            intent.putExtra("player3Score", player3ScoreView.getText().toString());
            intent.putExtra("player3HoleHits", player3HoleHits);

            intent.putExtra("player4Name", player4Name);
            intent.putExtra("player4Score", player4ScoreView.getText().toString());
            intent.putExtra("player4HoleHits", player4HoleHits);

            holeActivity.startActivity(intent);
        }
    };

    public OnClickListener prevHole = new OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(holeActivity.getApplicationContext(), holeClasses[holeNumber - 2] );
            intent.putExtra("player1Name", player1Name);
            intent.putExtra("player1Score", player1ScoreView.getText().toString());
            intent.putExtra("player1HoleHits", player1HoleHits);

            intent.putExtra("player2Name", player2Name);
            intent.putExtra("player2Score", player2ScoreView.getText().toString());
            intent.putExtra("player2HoleHits", player2HoleHits);

            intent.putExtra("player3Name", player3Name);
            intent.putExtra("player3Score", player3ScoreView.getText().toString());
            intent.putExtra("player3HoleHits", player3HoleHits);

            intent.putExtra("player4Name", player4Name);
            intent.putExtra("player4Score", player4ScoreView.getText().toString());
            intent.putExtra("player4HoleHits", player4HoleHits);
            holeActivity.startActivity(intent);
        }
    };

    public OnClickListener openSettings = new OnClickListener() {

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(holeActivity.getApplicationContext(), SettingsActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("p1", capitalize(player1Name));
            bundle.putString("p2", capitalize(player2Name));
            bundle.putString("p3", capitalize(player3Name));
            bundle.putString("p4", capitalize(player4Name));
            bundle.putString("requestCode", String.valueOf(holeNumber - 1));
            intent.putExtras(bundle);
            holeActivity.startActivityForResult(intent, holeNumber - 1);
        }
    };
    public String capitalize(String name){
        return name.toUpperCase();
    }

}
