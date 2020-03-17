package com.example.get_app_game;

import java.io.Serializable;

public class Exercise implements Serializable {

    private int exerciseImgId;
    private String exerciseName;

    public Exercise(String exerciseName, int exerciseImgId){
        this.exerciseImgId = exerciseImgId;
        this.exerciseName = exerciseName;
    }

    public int getExerciseImgId() {
        return exerciseImgId;
    }

    public String getVideoUri(){
        switch (exerciseName){
            case Constant.T_PUSH_UPS:
                return Constant.T_PUSH_UPS_V;

            case Constant.V_PUSH_UPS:
                return Constant.V_PUSH_UPS_V;

            case Constant.KNEE_PUSH_UPS:
                return Constant.KNEE_PUSH_UPS_V;

            case Constant.SPARTAN_PUSH_UPS:
                return Constant.SPARTAN_PUSH_UPS_V;

            case Constant.BURPEES:
                return Constant.BURPEES_V;

            case Constant.TRICEPKB:
                return Constant.TRICEP_KB_V;

            case Constant.HAMMER_CURLS:
                return Constant.HAMMER_CURLS_V;

            case Constant.CONCENTRATION_CURLS:
                return Constant.CONCENTRATION_CURLS_V;

            case Constant.DUMBELL_TRICEP:
                return Constant.DUMBBELL_TRICEP_V;

            case Constant.SIDE_PLANK:
                return Constant.SIDE_PLANK_V;

            case Constant.ALTER_ABS:
                return Constant.ALTER_ABS_V;

            case Constant.FTF_CRUNCH:
                return Constant.FTF_CRUNCH_V;

            case Constant.FEET_CROSSING:
                return Constant.FEET_CROSSING_V;

            case Constant.VERTICAL_CRUNCH:
                return Constant.VERTICAL_CRUNCH_V;

            case Constant.PLANK:
                return Constant.PLANK_V;

            case Constant.CLOSURES_ON_HEAD:
                return Constant.CLOSURES_ON_HEAD_V;

            case Constant.DUMBBELL_FRONT_RAISE:
                return Constant.DUMBBELL_FRONT_RAISE_V;

            case Constant.B_LATERAL_RAISES:
                return Constant.B_LATERAL_RAISES_V;

            case Constant.D_LATERAL_RAISES:
                return Constant.D_LATERAL_V;

            case Constant.SPARTAN_BOW:
                return Constant.SPARTAN_BOW_V;

            case Constant.SQUAT:
                return Constant.SQUAT_V;

            case Constant.LUNGES:
                return Constant.LUNGES_V;

            case Constant.CALF_RAISE:
                return Constant.CALF_RAISE_V;

            case Constant.SIDE_KICK:
                return Constant.SIDE_KICK_V;

            case Constant.BRIDGE:
                return Constant.BRIDGE_V;

            case Constant.CON_HIP_EXT:
                return Constant.CON_HIP_EXT_V;

            case Constant.HIP_EXTENSIONS:
                return Constant.HIP_EXTENSIONS_V;

            default:
                return null;
        }
    }





}
