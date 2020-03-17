package com.example.get_app_game;

import androidx.annotation.NonNull;
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
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import java.util.Locale;


public class TrainActivity extends AppCompatActivity {

    private TextView timeSelected;
    private CountDownTimer countDownTimer;
    private long timeLeft, endTime;
    private VideoView videoView;
    private int stopPosition;
    private boolean videoInStart = true;
    private boolean timerRunning;
    private ImageButton playBtn;
    private SoundPlayer sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_train);
        initVars();
    }

    private void initVars(){
        timeSelected = findViewById(R.id.time_text);
        playBtn = findViewById(R.id.playBTN);
        timeLeft = getIntent().getLongExtra("TIME_SELECTED", 0);
        sound = new SoundPlayer(this);
        videoView = findViewById(R.id.videoView);
        updateTimer();
        playBtn.setImageResource(R.drawable.pause);
        Exercise current_exercise = (Exercise)getIntent().getSerializableExtra("CURRENT_EXERCISE");
        if(current_exercise != null){
            initVideo(current_exercise);
        }
    }

    private void initVideo(Exercise current_exercise){
        Uri uri = Uri.parse(current_exercise.getVideoUri());
        videoView.setVideoURI(uri);
        videoView.start();
        handleVideoDelay(videoView);
        playVideoAgain(videoView);
    }

    private void handleVideoDelay(final VideoView videoView){
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                if(mp.getDuration() > timeLeft && videoInStart){
                    Toast.makeText(TrainActivity.this, Constant.DEFAULT_TIME_MSG, Toast.LENGTH_LONG).show();
                    timeLeft = Constant.DEFAULT_TIME;
                }
                startStop();
                handlePlayBtn();
            }
        });
    }

    private void handlePlayBtn(){
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(videoView.isPlaying()){
                    stopPosition = videoView.getCurrentPosition();
                    videoView.pause();
                    videoInStart = false;
                    stopTimer();
                    playBtn.setImageResource(R.drawable.play);
                }else{
                    videoView.seekTo(stopPosition);
                    videoView.start();
                    startTimer();
                    playBtn.setImageResource(R.drawable.pause);
                }
            }
        });
    }

    private void playVideoAgain(VideoView videoView) {
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
            }
        });
    }

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
                sound.playTimeOverSound();
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

    @Override
    protected void onResume() {
        super.onResume();
        videoView.seekTo(stopPosition);
        videoView.start();
        //        countDownTimer = new CountDownTimer(timeByStop, 1000) {
//            @Override
//            public void onTick(long millisUntilFinished) {
//                timeByStop = millisUntilFinished;
//                updateTimer();
//            }
//
//            @Override
//            public void onFinish() {
//                timerRunning = false;
//                sound.playTimeOverSound();
//                vibrate();
//                moveToFinishActivity();
//            }
//        }.start();
//
//        timerRunning = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopPosition = videoView.getCurrentPosition();
        videoView.pause();
        videoInStart = false;
//        countDownTimer.cancel();
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


    //2 functions to handle timer delay between orientation modes
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong("TIME_LEFT", timeLeft);
        outState.putBoolean("TIME_RUNNING", timerRunning);
        outState.putLong("END_TIME", endTime);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
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
