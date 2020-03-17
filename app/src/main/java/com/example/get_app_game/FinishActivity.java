package com.example.get_app_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FinishActivity extends AppCompatActivity {

    private Button repeatBtn, otherTrainingBtn, otherMuscleBtn;
    private boolean backToEx = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        initVars();
        repeatTheTraining();
        chooseOtherTrainingType();
        chooseOtherMuscle();
    }

    private void initVars(){
        repeatBtn = findViewById(R.id.repeat_btn);
        otherTrainingBtn = findViewById(R.id.other_training_btn);
        otherMuscleBtn = findViewById(R.id.other_muscle_btn);
    }

    private void repeatTheTraining(){
        repeatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToTimerActivity();
            }
        });
    }

    private void chooseOtherTrainingType(){
        otherTrainingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToExerciseScreen();
            }
        });
    }


    private void chooseOtherMuscle(){
        otherMuscleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToMusclesScreen();
            }
        });
    }

    private void backToTimerActivity(){
        Intent intent = new Intent(FinishActivity.this, TimerActivity.class);
        startActivity(intent);
        finish();
    }

    private void backToExerciseScreen(){
        Intent intent = new Intent(FinishActivity.this, MainActivity.class);
        intent.putExtra("TO_EXERCISE", backToEx);
        startActivity(intent);
        finish();
    }


    private void backToMusclesScreen() {
        Intent intent = new Intent(FinishActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}
