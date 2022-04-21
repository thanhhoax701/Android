package com.example.b9_tranthanhhoa_b1908387;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class PlayAudio extends AppCompatActivity {
    Button backAudio;
    TextView txtSongsName, playPosition, playDuration;
    SeekBar seekBar;
    ImageView btnPrevious, btnNext, btnPlay, btnPause;

    Bundle songExtraData;
    int position;
    ArrayList musicList;

    static MediaPlayer mMediaPlayer;
    Handler handler = new Handler();
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_audio);

        backAudio = (Button) findViewById(R.id.btnAudioTrove);
        txtSongsName = (TextView) findViewById(R.id.songsName);
        playPosition = (TextView) findViewById(R.id.player_position);
        playDuration = (TextView) findViewById(R.id.player_duration);
        seekBar = (SeekBar) findViewById(R.id.seek_bar);
        btnPrevious = (ImageView) findViewById(R.id.btnPrevious);
        btnNext = (ImageView) findViewById(R.id.btnNext);
        btnPlay = (ImageView) findViewById(R.id.btnPlay);
        btnPause = (ImageView) findViewById(R.id.btnPause);

        if (mMediaPlayer != null) {
            mMediaPlayer.stop();
        }

        // getting values from previous activity
        Intent intent = getIntent();
        songExtraData = intent.getExtras();
        musicList = (ArrayList)songExtraData.getParcelableArrayList("songsList");

        // Trở về
        backAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        mMediaPlayer = MediaPlayer.create(this, R.raw.hoihantronganh);

        runnable = new Runnable() {
            @Override
            public void run() {
                // Set progress on seek bar
                seekBar.setProgress(mMediaPlayer.getCurrentPosition());
                // Handler post delay for 0.5 second
                handler.postDelayed(this, 500);
            }
        };

        // Get duration of media player
        int duration = mMediaPlayer.getDuration();
        // Convert millisecond to minute and second
        String sDuration = convertFormat(duration);
        // Set duration on text view
        playDuration.setText(sDuration);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Hide play button
                btnPlay.setVisibility(View.GONE);
                // Show pause button
                btnPause.setVisibility(View.VISIBLE);
                // Start media player
                mMediaPlayer.start();
                // Set max on seek bar
                seekBar.setMax(mMediaPlayer.getDuration());
                // Start handler
                handler.postDelayed(runnable, 0);
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Hide pause button
                btnPause.setVisibility(View.GONE);
                // Show play button
                btnPlay.setVisibility(View.VISIBLE);
                // Pause media player
                mMediaPlayer.pause();
                // Stop handler
                handler.removeCallbacks(runnable);
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get duration position of media player
                int currentPosition = mMediaPlayer.getCurrentPosition();
                // Get duration of media player
                int duration = mMediaPlayer.getDuration();
                // Check condition
                if (mMediaPlayer.isPlaying() && duration != currentPosition) {
                    // tăng lên 5s
                    currentPosition = currentPosition + 5000;
                    playPosition.setText(convertFormat(currentPosition));
                    mMediaPlayer.seekTo(currentPosition);
                }
            }
        });

        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get duration position of media player
                int currentPosition = mMediaPlayer.getCurrentPosition();
                // Check condition
                if (mMediaPlayer.isPlaying() && currentPosition > 5000) {
                    // tăng lên 5s
                    currentPosition = currentPosition - 5000;
                    playPosition.setText(convertFormat(currentPosition));
                    mMediaPlayer.seekTo(currentPosition);
                }
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (b) {
                    mMediaPlayer.seekTo(i);
                }
                playPosition.setText(convertFormat(mMediaPlayer.getCurrentPosition()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @SuppressLint("DefaultLocale")
    private String convertFormat(int duration) {
        return String.format("%02d:%02d"
                , TimeUnit.MILLISECONDS.toMinutes(duration)
                , TimeUnit.MILLISECONDS.toSeconds(duration)
                        - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration)));
    }
}