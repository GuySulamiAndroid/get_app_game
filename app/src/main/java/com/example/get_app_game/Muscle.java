package com.example.get_app_game;

public class Muscle {

    private String muscleName;
    private int muscleImgId;

    public Muscle(String muscleName, int muscleImgId) {
        this.muscleName = muscleName;
        this.muscleImgId = muscleImgId;
    }

    public String getMuscleName() {
        return muscleName;
    }


    public int getMuscleImgId() {
        return muscleImgId;
    }
}
