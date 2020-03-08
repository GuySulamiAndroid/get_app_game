package com.example.get_app_game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView list_LST_muscles;
    private ArrayList<Muscle> muscles = new ArrayList<>();
    private Adapter_ImageModel adapter_imageModel;
    private Muscle chest, arms, abs, back, legs, butt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        list_LST_muscles = findViewById(R.id.list_LST_muscles);
        list_LST_muscles.setLayoutManager(new GridLayoutManager(this, 2));
        initImageButtons();
        createMusclesList();
        initList();
    }

    private void initImageButtons(){
        chest = new Muscle("chest", R.drawable.chest);
        arms = new Muscle("arms", R.drawable.arms);
        abs = new Muscle("abs", R.drawable.abs);
        back = new Muscle("back", R.drawable.back);
        legs = new Muscle("legs", R.drawable.legs);
        butt = new Muscle("butt", R.drawable.butt);
    }

    private void createMusclesList(){
        muscles.add(chest);
        muscles.add(arms);
        muscles.add(abs);
        muscles.add(back);
        muscles.add(legs);
        muscles.add(butt);
        adapter_imageModel = new Adapter_ImageModel(this, muscles);
    }

    private void initList(){
        list_LST_muscles.setHasFixedSize(true);
        list_LST_muscles.setAdapter(adapter_imageModel);
        adapter_imageModel.setOnItemClickListener(new Adapter_ImageModel.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, Muscle muscle) {
                moveToTimer();
            }
        });
    }

    private void moveToTimer(){
        Intent intent = new Intent(MainActivity.this, TimerActivity.class);
        startActivity(intent);
        finish();
    }

}
