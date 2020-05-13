package com.example.pokequiz;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QuizActivity extends AppCompatActivity {

    //data members
    @BindView(R.id.submit_1)
    Button mButton1;
    @BindView(R.id.correct_q1)
    TextView mCorrectQ1;
    @BindView(R.id.wrong_q1)
    TextView mWrongQ1;
    @BindView(R.id.mCB1)
    CheckBox mCB1;
    @BindView(R.id.mCB2)
    CheckBox mCB2;
    @BindView(R.id.mCB3)
    CheckBox mCB3;
    @BindView(R.id.mCB4)
    CheckBox mCB4;

    @BindView(R.id.submit_2)
    Button mButton2;
    @BindView(R.id.radioGroup1)
    RadioGroup mRadioGroup1;
    @BindView(R.id.correct_q2)
    TextView mCorrectQ2;
    @BindView(R.id.wrong_q2)
    TextView mWrongQ2;

    @BindView(R.id.submit_3)
    Button mButton3;
    @BindView(R.id.radioGroup2)
    RadioGroup mRadioGroup2;
    @BindView(R.id.correct_q3)
    TextView mCorrectQ3;
    @BindView(R.id.wrong_q3)
    TextView mWrongQ3;

    @BindView(R.id.submit_4)
    Button mButton4;
    @BindView(R.id.enter_q4)
    EditText mEditText;
    @BindView(R.id.correct_q4)
    TextView mCorrectQ4;
    @BindView(R.id.wrong_q4)
    TextView mWrongQ4;
    @BindView(R.id.thumb_q4)
    ImageView mImageview;

    @BindView(R.id.submit_5)
    Button mButton5;
    @BindView(R.id.radioGroup3)
    RadioGroup mRadioGroup3;
    @BindView(R.id.correct_q5)
    TextView mCorrectQ5;
    @BindView(R.id.wrong_q5)
    TextView mWrongQ5;


    @BindView(R.id.finish)
    Button mButtonFinish;

    public int score = 0;
    public String title = "Thank you for playing!";
    public String finalScore = "Your final score is : ";
    public String accept = "OKAY";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        //using butterknife to bind views
        ButterKnife.bind(this);
        //Question-01
        //setOnClickListener on 1st submit button
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //validation for correct answer
                if(!mCB1.isChecked() && mCB2.isChecked() && mCB3.isChecked() && !mCB4.isChecked()){
                    score+= 1;
                    mCorrectQ1.setVisibility(View.VISIBLE);
                }
                else
                    mWrongQ1.setVisibility(View.VISIBLE);
                //disabling submit button so that user cant submit again after answering that question
                mButton1.setEnabled(false);
            }
        });
        //Question-02
        mRadioGroup1.clearCheck();
        //setOnClickListener on 2nd submit button
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton rb1 = (RadioButton) mRadioGroup1.findViewById(mRadioGroup1.getCheckedRadioButtonId());
                //validation for correct answer
                if(rb1.getText().equals("Eevee")){
                    score+=1;
                    mCorrectQ2.setVisibility(View.VISIBLE);
                }
                else
                    mWrongQ2.setVisibility(View.VISIBLE);
                //disabling submit button so that user cant submit again after answering that question
                mButton2.setEnabled(false);
            }
        });
        //Question-03
        mRadioGroup2.clearCheck();
        //setOnClickListener on 3rd submit button
        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton rb2 = (RadioButton) mRadioGroup2.findViewById(mRadioGroup2.getCheckedRadioButtonId());
                //validation for correct answer
                if(rb2.getText().equals("Water")){
                    score+=1;
                    mCorrectQ3.setVisibility(View.VISIBLE);
                }
                else
                    mWrongQ3.setVisibility(View.VISIBLE);
                //disabling submit button so that user cant submit again after answering that question
                mButton3.setEnabled(false);
            }
        });
        //Question-04
        //setOnClickListener on 4th submit button
        mButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //validation for correct answer
                if(mEditText.getText().toString().trim().equalsIgnoreCase("Lugia")){
                    score+=1;
                    mCorrectQ4.setVisibility(View.VISIBLE);
                }
                else {
                    mWrongQ4.setVisibility(View.VISIBLE);
                }
                mImageview.setImageResource(R.mipmap.answer_4);
                //disabling submit button so that user cant submit again after answering that question
                mButton4.setEnabled(false);
            }
        });
        //Question-05
        //setOnClickListener on 5th submit button
        mRadioGroup3.clearCheck();
        mButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton rb3 = (RadioButton) mRadioGroup3.findViewById(mRadioGroup3.getCheckedRadioButtonId());
                //validation for correct answer
                if(rb3.getText().equals("Bug")){
                    score+=1;
                    mCorrectQ5.setVisibility(View.VISIBLE);
                }
                else
                    mWrongQ5.setVisibility(View.VISIBLE);
                //disabling submit button so that user cant submit again after answering that question
                mButton5.setEnabled(false);
            }
        });
        //setOnClickListener on finish button
        mButtonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog-box
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(QuizActivity.this);
                builder.setTitle(title);
                builder.setMessage(finalScore+String.valueOf(score));
                builder.setPositiveButton(accept, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(QuizActivity.this,finalScore +String.valueOf(score), Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });
    }
}
