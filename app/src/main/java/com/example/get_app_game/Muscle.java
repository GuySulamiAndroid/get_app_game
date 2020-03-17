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

    public int getMuscleImgId() {
        return muscleImgId;
    }

    public ArrayList<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(ArrayList<Exercise> exercises){
        switch (muscleName){
            case Constant.CHEST:
                exercises.add(new Exercise(Constant.T_PUSH_UPS,R.drawable.tpushup));
                exercises.add(new Exercise(Constant.V_PUSH_UPS,R.drawable.vpushups));
                exercises.add(new Exercise(Constant.KNEE_PUSH_UPS,R.drawable.kneepushup));
                exercises.add(new Exercise(Constant.SPARTAN_PUSH_UPS,R.drawable.spartanpushups));
                exercises.add(new Exercise(Constant.BURPEES,R.drawable.burpees));
                break;

            case Constant.ARMS:
                exercises.add(new Exercise(Constant.TRICEPKB,R.drawable.tricepkickback));
                exercises.add(new Exercise(Constant.HAMMER_CURLS,R.drawable.hammercurls));
                exercises.add(new Exercise(Constant.CONCENTRATION_CURLS,R.drawable.conentrationcurls));
                exercises.add(new Exercise(Constant.DUMBELL_TRICEP,R.drawable.dumbbletricep));
                break;

            case Constant.ABS:
                exercises.add(new Exercise(Constant.SIDE_PLANK,R.drawable.sideplunk));
                exercises.add(new Exercise(Constant.ALTER_ABS,R.drawable.alternatingabs));
                exercises.add(new Exercise(Constant.FTF_CRUNCH,R.drawable.ftfcrunch));
                exercises.add(new Exercise(Constant.FEET_CROSSING,R.drawable.crossingfeet));
                exercises.add(new Exercise(Constant.VERTICAL_CRUNCH,R.drawable.verticalcrunch));
                exercises.add(new Exercise(Constant.PLANK,R.drawable.plank));
                break;

            case Constant.SHOULDERS:
                exercises.add(new Exercise(Constant.CLOSURES_ON_HEAD,R.drawable.closuresonhead));
                exercises.add(new Exercise(Constant.DUMBBELL_FRONT_RAISE,R.drawable.dumbbellfrontraise));
                exercises.add(new Exercise(Constant.B_LATERAL_RAISES,R.drawable.bentoverlateralraises));
                exercises.add(new Exercise(Constant.D_LATERAL_RAISES,R.drawable.dumbbelllateralraise));
                break;

            case Constant.LEGS:
                exercises.add(new Exercise(Constant.SPARTAN_BOW,R.drawable.spartanbow));
                exercises.add(new Exercise(Constant.SQUAT,R.drawable.squat));
                exercises.add(new Exercise(Constant.LUNGES,R.drawable.lunges));
                exercises.add(new Exercise(Constant.CALF_RAISE,R.drawable.calfraise));
                break;

            case Constant.BUTT:
                exercises.add(new Exercise(Constant.SIDE_KICK,R.drawable.sidekick));
                exercises.add(new Exercise(Constant.BRIDGE,R.drawable.bridge));
                exercises.add(new Exercise(Constant.CON_HIP_EXT,R.drawable.conenthipextens));
                exercises.add(new Exercise(Constant.HIP_EXTENSIONS,R.drawable.hipextension));
                break;

            default:
                exercises = null;
                break;
        }
    }
}
