package com.example.get_app_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.Locale;

public class TimerActivity extends AppCompatActivity implements Serializable {

    private EditText timeInput;
    private TextView timeTxt;
    private Button startBtn, setTimeBtn;
    private long timeLeft;
    private Exercise current_exercise;
    private boolean isRepeat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        initVars();
        setTrainingTime();
        closeKeyBoard();
        startTraining();
    }

    private void initVars(){
        timeInput = findViewById(R.id.time_input);
        timeTxt = findViewById(R.id.time_txt);
        startBtn = findViewById(R.id.start_btn);
        setTimeBtn = findViewById(R.id.set_time_btn);
        current_exercise = (Exercise)getIntent().getSerializableExtra("CURRENT_EXERCISE");
    }

    private void setTrainingTime(){
        setTimeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeKeyBoard();
                String input = timeInput.getText().toString();
                if(input.length() == 0){
                    Toast.makeText(TimerActivity.this, Constant.TIME_REQUIRED_MSG, Toast.LENGTH_SHORT).show();
                    return;
                }
                timeLeft = Long.parseLong(input) * 60000;
                if(timeLeft == 0){
                    Toast.makeText(TimerActivity.this, Constant.INVALID_TIME_MSG, Toast.LENGTH_SHORT).show();
                    return;
                }
                setTimer();
            }
        });
    }

    private void closeKeyBoard(){
        View view = this.getCurrentFocus();
        if(view != null){
            InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    private void startTraining(){
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = timeInput.getText().toString();
                if(input.length() == 0) {
                    Toast.makeText(TimerActivity.this, Constant.TIME_REQUIRED_MSG, Toast.LENGTH_SHORT).show();
                    return;
                }
                timeLeft = Long.parseLong(input) * 60000;
                if(timeLeft == 0){
                    Toast.makeText(TimerActivity.this, Constant.INVALID_TIME_MSG , Toast.LENGTH_SHORT).show();
                    return;
                }
                moveToTrainActivity();
            }
        });
    }

    public void setTimer(){
        int minutes = (int)timeLeft / 60000;
        int seconds = (int)timeLeft % 60000 / 1000;
        String timeLeftTxt = String.format(Locale.getDefault(),"%02d:%02d", minutes, seconds);
        timeTxt.setText(timeLeftTxt);
    }

    private void moveToTrainActivity(){
        Intent intent = new Intent(TimerActivity.this, TrainActivity.class);
        intent.putExtra("TIME_SELECTED", timeLeft);
        intent.putExtra("CURRENT_EXERCISE", current_exercise);
        startActivity(intent);
    }
}
