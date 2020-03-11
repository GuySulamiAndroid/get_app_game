package com.example.get_app_game;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ExerciseFragment extends Fragment {

    private View view;
    private Context context;
    private RecyclerView list_LST_exercises;
    private ArrayList<Exercise> exercises;

    public ExerciseFragment(Context context) {
        super();
        this.context = context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(view == null){
            view = inflater.inflate(R.layout.fragment_exercise, container, false);
        }
        list_LST_exercises = view.findViewById(R.id.list_LST_exercise);
        list_LST_exercises.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        return view;
    }

    protected void setRelevantExercises(Muscle muscle){
        exercises = muscle.getExercises();
    }

}
