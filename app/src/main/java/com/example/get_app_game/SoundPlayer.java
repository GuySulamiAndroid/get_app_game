package com.example.get_app_game;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

public class SoundPlayer {
    private static SoundPool soundPool;
    private static int timeOver;

    public SoundPlayer(Context context){
        soundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
        timeOver = soundPool.load(context, R.raw.buzzer, 1);
    }

    public void playTimeOverSound(){
        soundPool.play(timeOver, 1.0f, 1.0f, 1, 0, 1.0f);
    }
}
