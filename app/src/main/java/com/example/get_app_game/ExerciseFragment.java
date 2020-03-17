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
    private Adapter_ImageModel adapter_exerciseModel;
    private ArrayList<Exercise> exercises;

    public ExerciseFragment(Context context) {
        super();
        this.context = context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(view == null){
            view = inflater.inflate(R.layout.fragment_images, container, false);
        }
        list_LST_exercises = view.findViewById(R.id.list_LST_images);
        list_LST_exercises.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        exercises = MainActivity.current_muscle.getExercises();
        adapter_exerciseModel = new Adapter_ImageModel(getActivity(), exercises);
        list_LST_exercises.setHasFixedSize(true);
        list_LST_exercises.setAdapter(adapter_exerciseModel);
        adapter_exerciseModel.setOnItemClickListener(new Adapter_ImageModel.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, Object exercise) {
                ((MainActivity)context).moveToTimerActivity((Exercise)exercise);
            }
        });
        return view;
    }
}