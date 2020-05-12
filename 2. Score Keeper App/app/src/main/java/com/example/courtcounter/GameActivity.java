package com.example.courtcounter;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {

    //data members
    TextView mTeamA;
    TextView mTeamB;
    String TeamA,TeamB;
    int scoreTeamA = 0;
    int scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //initializing
        mTeamA = (TextView)findViewById(R.id.teamA);
        mTeamB = (TextView) findViewById(R.id.teamB);

        //getting teams values from intent
        TeamA = getIntent().getStringExtra("TeamA");
        TeamB = getIntent().getStringExtra("TeamB");
        //Log.d(GameActivity.class.getSimpleName(),TeamA);
        //Log.d(GameActivity.class.getSimpleName(),TeamB);


        //setting deafult Team-Name as Team A or Team B if there is no input
        if(TeamA.length()>0)
            mTeamA.setText(TeamA);
        else
            mTeamA.setText("Team A");

        if(TeamB.length()>0)
            mTeamB.setText(TeamB);
        else
            mTeamB.setText("Team B");

    }

    //method to increment score by 3
    public void incrementByThreeA(View view){
        scoreTeamA+=3;
        displayForTeamA(scoreTeamA);
    }
    //method to increment score by 2
    public void incrementByTwoA(View view){
        scoreTeamA+=2;
        displayForTeamA(scoreTeamA);
    }
    //method to increment score by 1
    public void incrementByOneA(View view){
        scoreTeamA+=1;
        displayForTeamA(scoreTeamA);
    }


    //method to increment score by 3
    public void incrementByThreeB(View view){
        scoreTeamB+=3;
        displayForTeamB(scoreTeamB);
    }
    //method to increment score by 2
    public void incrementByTwoB(View view){
        scoreTeamB+=2;
        displayForTeamB(scoreTeamB);
    }
    //method to increment score by 1
    public void incrementByOneB(View view){
        scoreTeamB+=1;
        displayForTeamB(scoreTeamB);
    }

    //method to reset scores
    public void reset(View view){
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

    //display score for team A
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    //display score for team B
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
}