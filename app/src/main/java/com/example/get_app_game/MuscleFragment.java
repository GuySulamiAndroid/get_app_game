package com.example.get_app_game;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class MuscleFragment extends Fragment {

    private View view;
    private RecyclerView list_LST_muscles;
    private ArrayList<Muscle> muscles = new ArrayList<>();
    private Adapter_ImageModel adapter_muscleModel;
    private Context context;
    private Muscle chest, arms, abs, shoulders, legs, butt;


    public MuscleFragment(Context context) {
        super();
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(view == null){
            view = inflater.inflate(R.layout.fragment_images, container, false);
        }
        list_LST_muscles = view.findViewById(R.id.list_LST_images);
        list_LST_muscles.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        initImageButtons();
        createMusclesList();
        initList();
        return view;
    }

    private void initImageButtons(){
        chest = new Muscle(Constant.CHEST, R.drawable.chest);
        arms = new Muscle(Constant.ARMS, R.drawable.arms);
        abs = new Muscle(Constant.ABS, R.drawable.abs);
        shoulders = new Muscle(Constant.SHOULDERS, R.drawable.shoulders);
        legs = new Muscle(Constant.LEGS, R.drawable.legs);
        butt = new Muscle(Constant.BUTT, R.drawable.butt);
    }

    private void createMusclesList(){
        muscles.add(chest);
        muscles.add(arms);
        muscles.add(abs);
        muscles.add(shoulders);
        muscles.add(legs);
        muscles.add(butt);
        adapter_muscleModel = new Adapter_ImageModel(getActivity(), muscles);
    }


    private void initList(){
        list_LST_muscles.setHasFixedSize(true);
        list_LST_muscles.setAdapter(adapter_muscleModel);
        adapter_muscleModel.setOnItemClickListener(new Adapter_ImageModel.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, Object muscle) {
                ((MainActivity)context).showExerciseFragment((Muscle)muscle);
            }
        });
    }
}
