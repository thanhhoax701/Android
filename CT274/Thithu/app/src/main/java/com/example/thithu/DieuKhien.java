package com.example.thithu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

public class DieuKhien extends AppCompatActivity {
    ToggleButton toggleButton1,toggleButton2,toggleButton3;
    Button trove;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dieu_khien);
        toggleButton1 = findViewById(R.id.toggleButton1);
        toggleButton2 = findViewById(R.id.toggleButton2);
        toggleButton3 = findViewById(R.id.toggleButton3);
        trove = findViewById(R.id.button);

        Bundle b=this.getIntent().getExtras();
        String tt1 = "",tt2 = "", tt3 = "";
         tt1=b.getString("tt1");
         tt2=b.getString("tt2");
         tt3 = b.getString("tt3");
        if (tt1.equals("ON")){
            toggleButton1.setChecked(true);
        }
        if (tt2.equals("ON")){
            toggleButton2.setChecked(true);
        }
        if (tt3.equals("ON")){
            toggleButton3.setChecked(true);
        }
        trove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                System.exit(0);
                finish();
            }
        });

    }
}