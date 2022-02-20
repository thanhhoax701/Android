package com.abhi.customseekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
     SeekBar seekBar;
     TextView value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar=findViewById(R.id.seekbar); //initialize the seekBar object
        value=findViewById(R.id.progress);
        //calling the seekbar event change listener
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            //increment or decrement on process changed
            // increase the textsize
            // with the value of progress
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                value.setText(progress+"/"+"50");

                
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // This method will automatically
                // called when the user touches the SeekBar
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // This method will automatically
                // called when the user
                // stops touching the SeekBar
            }
        });
    }


}