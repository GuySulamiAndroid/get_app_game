package com.example.get_app_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.Locale;

public class TrainActivity extends AppCompatActivity {

    private TextView timeSelected;
    private CountDownTimer countDownTimer;
    private long timeLeft, endTime;
    private boolean timerRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train);
        initVars();
        startStop();
    }

    private void initVars(){
        timeSelected = findViewById(R.id.time_text);
        timeLeft = getIntent().getLongExtra("TIME_SELECTED", 0);
        initVideo();
    }

    private void initVideo(){
        VideoView videoView;
        videoView = findViewById(R.id.videoView);
        Uri uri = Uri.parse("https://firebasestorage.googleapis.com/v0/b/getapp-game.appspot.com/o/Best%20abs%20exercises-%20Abdominal%20Crunch.mp4?alt=media&token=876572cd-89cd-4bcc-85bd-8f1f95257166");
        videoView.setVideoURI(uri);
        videoView.start();
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
            }
        });

    }
    private void setTimeTxt(){

    }

//    private void handle_stopper(){
//        startBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startStop();
//            }
//        });
////        updateTimer();
//    }

    private void startStop(){
        if(timerRunning){
            stopTimer();
        }else{
            startTimer();
        }
    }

    public void startTimer(){
        endTime = System.currentTimeMillis() + timeLeft;
        countDownTimer = new CountDownTimer(timeLeft, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeft = millisUntilFinished;
                updateTimer();
            }

            @Override
            public void onFinish() {
                timerRunning = false;
                vibrate();
                moveToFinishActivity();
            }
        }.start();

        timerRunning = true;
    }

    public void stopTimer(){
        countDownTimer.cancel();
        timerRunning = false;
    }

    public void updateTimer(){
        int minutes = (int)(timeLeft / 1000) / 60;
        int seconds = (int)(timeLeft / 1000) % 60;
        String timeLeftTxt = String.format(Locale.getDefault(),"%02d:%02d", minutes, seconds);
        timeSelected.setText(timeLeftTxt);
    }

    private void vibrate(){
        final int VIBRATE_TIME = 500;
        Vibrator v = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        if(v != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                v.vibrate(VibrationEffect.createOneShot(VIBRATE_TIME,
                        VibrationEffect.DEFAULT_AMPLITUDE));
            } else {
                //deprecated in API 26
                v.vibrate(VIBRATE_TIME);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong("TIME_LEFT", timeLeft);
        outState.putBoolean("TIME_RUNNING", timerRunning);
        outState.putLong("END_TIME", endTime);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        timeLeft = savedInstanceState.getLong("TIME_LEFT");
        timerRunning = savedInstanceState.getBoolean("TIME_RUNNING");
        updateTimer();
        if(timerRunning){
            endTime = savedInstanceState.getLong("END_TIME");
            timeLeft = endTime - System.currentTimeMillis();
            startTimer();
        }
    }

    private void moveToFinishActivity(){
        Intent intent = new Intent(TrainActivity.this, FinishActivity.class);
        startActivity(intent);
        finish();
    }
}
