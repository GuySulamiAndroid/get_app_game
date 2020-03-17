package com.example.get_app_game;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import java.io.Serializable;


public class MainActivity extends FragmentActivity implements Serializable {

    protected static Muscle current_muscle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        showMuscleFragment();
        directToExFragment();
    }

    private void showMuscleFragment(){
        MuscleFragment muscleFragment = new MuscleFragment(this);
        FragmentManager fManager = getSupportFragmentManager();
        fManager.beginTransaction().replace(R.id.images_layout, muscleFragment, muscleFragment.getTag()).commit();
    }

    public void showExerciseFragment(Muscle muscle){
        current_muscle = muscle;
        ExerciseFragment exerciseFragment = new ExerciseFragment(this);
        FragmentManager fManager = getSupportFragmentManager();
        fManager.beginTransaction().replace(R.id.images_layout, exerciseFragment, exerciseFragment.getTag()).addToBackStack("EXERCISE_TAG").commit();
    }

    private void directToExFragment(){
        boolean getBack = getIntent().getBooleanExtra("TO_EXERCISE", false);
        if(getBack){
            showExerciseFragment(current_muscle);
        }
    }

    public void moveToTimerActivity(Exercise exercise){
        Intent intent = new Intent(MainActivity.this, TimerActivity.class);
        intent.putExtra("CURRENT_EXERCISE", exercise);
        startActivity(intent);
    }
}