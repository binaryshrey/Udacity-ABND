package com.example.courtcounter;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class InfoActivity extends AppCompatActivity {

    //data members
    EditText mEditTextTeamA;
    EditText mEditTextTeamB;
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        //initializing
        mEditTextTeamA = (EditText) findViewById(R.id.TeamA);
        mEditTextTeamB = (EditText) findViewById(R.id.TeamB);
        mButton = (Button) findViewById(R.id.lets_play);

        //setOnClickListener
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intent to start GameActivity
                Intent intent = new Intent(InfoActivity.this, GameActivity.class);
                //passing names of Teams as key-value pairs
                intent.putExtra("TeamA",mEditTextTeamA.getText().toString());
                intent.putExtra("TeamB",mEditTextTeamB.getText().toString());
                startActivity(intent);

            }
        });
    }
}
