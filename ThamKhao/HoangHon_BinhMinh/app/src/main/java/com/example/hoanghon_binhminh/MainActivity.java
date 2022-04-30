package com.example.hoanghon_binhminh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.marcinmoskala.arcseekbar.ArcSeekBar;
import com.marcinmoskala.arcseekbar.ProgressListener;

public class MainActivity extends AppCompatActivity {
    ArcSeekBar defaultSeerBar, seekBarBackground,gradientSeekbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Anhxa();

        // Set Gradient
        int[] colorArrays = getResources().getIntArray(R.array.gradient);
        gradientSeekbar.setProgressGradient(colorArrays);

        // Set event
        defaultSeerBar.setOnProgressChangedListener(new ProgressListener() {
            @Override
            public void invoke(int i) {
                Log.d("TAG", "invoke: " + i);
            }
        });
    }

    private void Anhxa() {
        defaultSeerBar = findViewById(R.id.defaultSeekbar);
        seekBarBackground = findViewById(R.id.seekBarBackground);
        gradientSeekbar = findViewById(R.id.gradientSeekBar);
    }
}