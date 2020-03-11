package com.example.get_app_game;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MuscleFragment extends Fragment {

    private View view;
    private RecyclerView list_LST_muscles;
    private ArrayList<Muscle> muscles = new ArrayList<>();
    private Adapter_ImageModel adapter_imageModel;
    private Context context;
    private SendMuscle sm;
    private Muscle chest, arms, abs, shoulders, legs, butt;


    public MuscleFragment(Context context) {
        super();
        this.context = context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(view == null){
            view = inflater.inflate(R.layout.fragment_muscle, container, false);
        }
        list_LST_muscles = view.findViewById(R.id.list_LST_muscles);
        list_LST_muscles.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        initImageButtons();
        createMusclesList();
        initList();
        return view;
    }

    private void initImageButtons(){
        chest = new Muscle("chest", R.drawable.chest);
        arms = new Muscle("arms", R.drawable.arms);
        abs = new Muscle("abs", R.drawable.abs);
        shoulders = new Muscle("shoulders", R.drawable.shoulders);
        legs = new Muscle("legs", R.drawable.legs);
        butt = new Muscle("butt", R.drawable.butt);
    }

    private void createMusclesList(){
        muscles.add(chest);
        muscles.add(arms);
        muscles.add(abs);
        muscles.add(shoulders);
        muscles.add(legs);
        muscles.add(butt);
        adapter_imageModel = new Adapter_ImageModel(getActivity(), muscles);
    }

    private void initList(){
        list_LST_muscles.setHasFixedSize(true);
        list_LST_muscles.setAdapter(adapter_imageModel);
        adapter_imageModel.setOnItemClickListener(new Adapter_ImageModel.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, Object muscle) {
                ((MainActivity)context).showExerciseFragment((Muscle)muscle);
            }
        });
    }

    interface SendMuscle {
        void sendRelevantMuscle(Muscle muscle);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            sm = (SendMuscle)getActivity();
        } catch (ClassCastException e){
            throw new ClassCastException("Error");
        }
    }
}
