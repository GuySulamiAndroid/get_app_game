package com.example.get_app_game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MuscleFragment.SendMuscle {

    ExerciseFragment exerciseFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        showMuscleFragment();
    }

    private void showMuscleFragment(){
        MuscleFragment muscleFragment = new MuscleFragment(this);
        FragmentManager fManager = getSupportFragmentManager();
        fManager.beginTransaction().replace(R.id.muscle_layout, muscleFragment, muscleFragment.getTag()).commit();
    }

    public void showExerciseFragment(Muscle muscle){
        exerciseFragment = new ExerciseFragment(this);
        FragmentManager fManager = getSupportFragmentManager();
        fManager.beginTransaction().replace(R.id.exercise_layout, exerciseFragment, exerciseFragment.getTag()).commit();
        sendRelevantMuscle(muscle);
    }

    @Override
    public void sendRelevantMuscle(Muscle muscle) {
        exerciseFragment.setRelevantExercises(muscle);
    }
}
