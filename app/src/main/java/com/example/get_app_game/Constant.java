package com.example.get_app_game;

public class Constant {

    //Error messages
    final static String INVALID_TIME_MSG = "Invalid time. Try again";
    final static String TIME_REQUIRED_MSG = "Please enter desired time";

    //Default exercise time message
    final static String DEFAULT_TIME_MSG = "Exercise Requires More Time. Set Timer To 2 Minutes";

    //Default exercise time
    final static long DEFAULT_TIME = 120000;

    //Muscles names
    final static String CHEST = "chest";
    final static String ARMS = "arms";
    final static String ABS = "abs";
    final static String SHOULDERS = "shoulders";
    final static String LEGS = "legs";
    final static String BUTT = "butt";

    //Exercises names
    final static String T_PUSH_UPS = "T push ups";
    final static String V_PUSH_UPS = "V push ups";
    final static String KNEE_PUSH_UPS = "Knee push ups";
    final static String SPARTAN_PUSH_UPS = "Spartan push ups";
    final static String BURPEES = "Jump burpees";
    final static String TRICEPKB = "Tricep kickback";
    final static String HAMMER_CURLS = "Hammer curls";
    final static String CONCENTRATION_CURLS = "Concentration curls";
    final static String DUMBELL_TRICEP = "Dumbbell tricep";
    final static String SIDE_PLANK = "Side plank";
    final static String ALTER_ABS = "Alternating abs";
    final static String FTF_CRUNCH = "Foot to Foot crunch";
    final static String FEET_CROSSING = "Feet crossing";
    final static String VERTICAL_CRUNCH = "Vertical crunch";
    final static String PLANK = "Plank";
    final static String CLOSURES_ON_HEAD = "Closures on head";
    final static String DUMBBELL_FRONT_RAISE = "Dumbbell front raise";
    final static String B_LATERAL_RAISES = "Bent over lateral raises";
    final static String D_LATERAL_RAISES = "Dumbbell lateral raise";
    final static String SPARTAN_BOW = "Spartan bow";
    final static String SQUAT = "Squat";
    final static String LUNGES = "Lunges";
    final static String CALF_RAISE = "Calf raise";
    final static String SIDE_KICK = "Side kick";
    final static String BRIDGE = "Bridge";
    final static String CON_HIP_EXT = "Concentration hip extensions";
    final static String HIP_EXTENSIONS = "Hip extensions";

    //Exercises videos
    final static String ALTER_ABS_V = "https://firebasestorage.googleapis.com/v0/b/getapp-game.appspot.com/o/exercises_src%2FABS%20exercise%20-%20Alternating%20Curls%20to%20get%20six%20pack%20FAST.mp4?alt=media&token=1db0d6f9-2723-47e3-a0d7-d512028c9d25";
    final static String FTF_CRUNCH_V = "https://firebasestorage.googleapis.com/v0/b/getapp-game.appspot.com/o/exercises_src%2FAbdominal%20oblique%20exercice%20-%20ab%20workout-%20Foot%20to%20Foot%20crunch%20(%20oblique%20crunches%20).mp4?alt=media&token=db899ba7-ebc9-4ac4-9230-546fdaea58fc";
    final static String HAMMER_CURLS_V = "https://firebasestorage.googleapis.com/v0/b/getapp-game.appspot.com/o/exercises_src%2FAlternating%20hammer%20curls%20(standing%20with%20dumbbells).mp4?alt=media&token=e4389c64-dd31-4ef5-82aa-7cc2df89404c";
    final static String BRIDGE_V = "https://firebasestorage.googleapis.com/v0/b/getapp-game.appspot.com/o/exercises_src%2FBEST%20Tone%20Buttocks%20exercise%20-%20Reduce%20buttocks%20and%20%20thighs%20with%20Bridging%20exercise.mp4?alt=media&token=dda95e3a-e633-4ebf-9321-489534e9d952";
    final static String B_LATERAL_RAISES_V = "https://firebasestorage.googleapis.com/v0/b/getapp-game.appspot.com/o/exercises_src%2FBent%20over%20lateral%20raises.mp4?alt=media&token=e080bf79-4faa-47f3-8c72-9065d156957a";
    final static String SIDE_KICK_V = "https://firebasestorage.googleapis.com/v0/b/getapp-game.appspot.com/o/exercises_src%2FBest%20buttocks%20exercises-%20Side%20Kick%20with%20Bent%20Knee.mp4?alt=media&token=7fc28827-e7a1-41d2-90d0-f1c7646c6ee6";
    final static String CON_HIP_EXT_V = "https://firebasestorage.googleapis.com/v0/b/getapp-game.appspot.com/o/exercises_src%2FConcentrated%20hip%20extension.mp4?alt=media&token=d7da37ed-c78c-4cb7-9ec4-67c75d9a1711";
    final static String CONCENTRATION_CURLS_V = "https://firebasestorage.googleapis.com/v0/b/getapp-game.appspot.com/o/exercises_src%2FConcentration%20curls%20-%20Biceps%20Exercises.mp4?alt=media&token=4e14dfa8-c59a-441e-98bd-ca6e6d9d1ee0";
    final static String DUMBBELL_FRONT_RAISE_V = "https://firebasestorage.googleapis.com/v0/b/getapp-game.appspot.com/o/exercises_src%2FDumbbell%20Front%20Raise.mp4?alt=media&token=612838e1-ce46-4818-bacc-6213bcb7d29a";
    final static String D_LATERAL_V = "https://firebasestorage.googleapis.com/v0/b/getapp-game.appspot.com/o/exercises_src%2FDumbbell%20Lateral%20Raise%20exercise.mp4?alt=media&token=42231b97-6ce9-421f-b77d-c192c846a423";
    final static String CLOSURES_ON_HEAD_V = "https://firebasestorage.googleapis.com/v0/b/getapp-game.appspot.com/o/exercises_src%2FDumbbell%20exercises%20shoulders%20-%20Closures%20on%20head.mp4?alt=media&token=de4735a4-ebb6-429b-a336-91bd81d0f188";
    final static String DUMBBELL_TRICEP_V = "https://firebasestorage.googleapis.com/v0/b/getapp-game.appspot.com/o/exercises_src%2FDumbbells%20triceps%20extensions.mp4?alt=media&token=a187787f-bb48-4e0a-98a7-ea572b842327";
    final static String VERTICAL_CRUNCH_V = "https://firebasestorage.googleapis.com/v0/b/getapp-game.appspot.com/o/exercises_src%2FFull%20vertical%20crunch.mp4?alt=media&token=6c0fd3b0-16b3-4288-98ce-e577f01e05e9";
    final static String HIP_EXTENSIONS_V = "https://firebasestorage.googleapis.com/v0/b/getapp-game.appspot.com/o/exercises_src%2FHip%20extensions%2C%20butt%20exercise%20for%20women.mp4?alt=media&token=350a16b6-864c-46d1-911b-dcce18a38ca4";
    final static String BURPEES_V = "https://firebasestorage.googleapis.com/v0/b/getapp-game.appspot.com/o/exercises_src%2FJump%20Burpees%20(quads%20exercises).mp4?alt=media&token=f8ab61f9-b46c-40ee-a217-f745a46fd2b6";
    final static String KNEE_PUSH_UPS_V = "https://firebasestorage.googleapis.com/v0/b/getapp-game.appspot.com/o/exercises_src%2FKnee%20push%20ups.mp4?alt=media&token=2064e59a-404a-411e-b815-648883460c3d";
    final static String SQUAT_V = "https://firebasestorage.googleapis.com/v0/b/getapp-game.appspot.com/o/exercises_src%2FLegs%20exercises%20-%20How%20to%20Squats%20for%20quadriceps%20muscles.mp4?alt=media&token=42a7b2a8-1a76-4ac9-b50f-6d056d719c1e";
    final static String FEET_CROSSING_V = "https://firebasestorage.googleapis.com/v0/b/getapp-game.appspot.com/o/exercises_src%2FLower%20Abs%20-%20Alternate%20crossing%20of%20the%20feet.mp4?alt=media&token=9c990800-9d6b-4832-9c80-d3c3d4ab0f7f";
    final static String LUNGES_V = "https://firebasestorage.googleapis.com/v0/b/getapp-game.appspot.com/o/exercises_src%2FLunges%2C%20buttocks%20exercises.mp4?alt=media&token=a8be585d-1cfb-4a03-8798-e02e3df6aee3";
    final static String SIDE_PLANK_V = "https://firebasestorage.googleapis.com/v0/b/getapp-game.appspot.com/o/exercises_src%2FSide%20Plank%20Dynamic.mp4?alt=media&token=fd734089-12ee-4e1a-a876-fca9d6c64a57";
    final static String SPARTAN_BOW_V = "https://firebasestorage.googleapis.com/v0/b/getapp-game.appspot.com/o/exercises_src%2FSpartan%20Bow%20from%20'Spartan%20Series'%20(300%20workout).mp4?alt=media&token=a735cd51-e604-4afa-830d-659616d20df7";
    final static String SPARTAN_PUSH_UPS_V = "https://firebasestorage.googleapis.com/v0/b/getapp-game.appspot.com/o/exercises_src%2FSpartan%20Push%20Up%20(300%20workout).mp4?alt=media&token=be6b02bb-4c8d-4141-aa05-555155bed2df";
    final static String PLANK_V = "https://firebasestorage.googleapis.com/v0/b/getapp-game.appspot.com/o/exercises_src%2FStrong%20abs%20exercises-%20Plank.mp4?alt=media&token=154446a3-8f7e-4fdd-857c-30c96bb0f6c1";
    final static String T_PUSH_UPS_V = "https://firebasestorage.googleapis.com/v0/b/getapp-game.appspot.com/o/exercises_src%2FT-%20Push%20Ups.mp4?alt=media&token=6430f63d-221c-415d-ae87-ca9a00107f8e";
    final static String TRICEP_KB_V = "https://firebasestorage.googleapis.com/v0/b/getapp-game.appspot.com/o/exercises_src%2FTriceps%20kickbacks.mp4?alt=media&token=5b87afbd-7da6-40cb-ab0d-c76441605575";
    final static String V_PUSH_UPS_V = "https://firebasestorage.googleapis.com/v0/b/getapp-game.appspot.com/o/exercises_src%2FV%20Push%20Ups%20(with%20clenched%20fists)%20-%20Fitness%20exercises.mp4?alt=media&token=48225da1-8b16-4bcd-87f7-d27d024baad1";
    final static String CALF_RAISE_V = "https://firebasestorage.googleapis.com/v0/b/getapp-game.appspot.com/o/exercises_src%2Fvideoplayback.mp4?alt=media&token=e1b7623b-a9f2-41ec-a2d6-9eb318792ddc";
}
