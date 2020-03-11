package com.example.get_app_game;

import java.util.ArrayList;

public class Muscle {

    private String muscleName;
    private int muscleImgId;
    private ArrayList<Exercise> exercises;

    public Muscle(String muscleName, int muscleImgId) {
        this.muscleName = muscleName;
        this.muscleImgId = muscleImgId;
        this.exercises = new ArrayList<>();
        setExercises(exercises);
    }

    public String getMuscleName() {
        return muscleName;
    }


    public int getMuscleImgId() {
        return muscleImgId;
    }

    public ArrayList<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(ArrayList<Exercise> exercises){
        switch (muscleName){
            case "chest":
                exercises.add(new Exercise(R.drawable.tpushup));
                exercises.add(new Exercise(R.drawable.vpushups));
                exercises.add(new Exercise(R.drawable.kneepushup));
                exercises.add(new Exercise(R.drawable.spartanpushups));
                exercises.add(new Exercise(R.drawable.burpees));
                break;

            case "arms":
                exercises.add(new Exercise(R.drawable.tricepkickback));
                exercises.add(new Exercise(R.drawable.hammercurls));
                exercises.add(new Exercise(R.drawable.conentrationcurls));
                exercises.add(new Exercise(R.drawable.dumbbletricep));
                break;

            case "abs":
                exercises.add(new Exercise(R.drawable.sideplunk));
                exercises.add(new Exercise(R.drawable.alternatingabs));
                exercises.add(new Exercise(R.drawable.ftfcrunch));
                exercises.add(new Exercise(R.drawable.crossingfeet));
                exercises.add(new Exercise(R.drawable.verticalcrunch));
                exercises.add(new Exercise(R.drawable.plank));
                break;

            case "shoulders":
                exercises.add(new Exercise(R.drawable.closuresforhead));
                exercises.add(new Exercise(R.drawable.dumbbellfrontraise));
                exercises.add(new Exercise(R.drawable.bentoverlateralraises));
                exercises.add(new Exercise(R.drawable.dumbbelllateralraise));
                break;

            case "legs":
                exercises.add(new Exercise(R.drawable.spartanbow));
                exercises.add(new Exercise(R.drawable.squat));
                exercises.add(new Exercise(R.drawable.lunges));
                exercises.add(new Exercise(R.drawable.calfraise));
                break;

            case "butt":
                exercises.add(new Exercise(R.drawable.sidekick));
                exercises.add(new Exercise(R.drawable.bridge));
                exercises.add(new Exercise(R.drawable.concenthipextens));
                exercises.add(new Exercise(R.drawable.hipextension));
                break;

            default:
                exercises = null;
        }
    }
}
