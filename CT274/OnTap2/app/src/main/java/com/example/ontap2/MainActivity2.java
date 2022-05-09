package com.example.ontap2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

public class MainActivity2 extends AppCompatActivity {
    ToggleButton toggleButton1, toggleButton2, toggleButton3;
    String tt1 = "", tt2 = "", tt3 = "";
    Button btnTroVe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Anhxa();

        Bundle b = this.getIntent().getExtras();
        tt1 = b.getString("tt1");
        tt2 = b.getString("tt2");
        tt3 = b.getString("tt3");

        if (tt1.equals("ON")) {
            toggleButton1.setChecked(true);
        }
        if (tt2.equals("ON")) {
            toggleButton2.setChecked(true);
        }
        if (tt3.equals("ON")) {
            toggleButton3.setChecked(true);
        }

        btnTroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void Anhxa() {
        toggleButton1 = findViewById(R.id.toggleButton1);
        toggleButton2 = findViewById(R.id.toggleButton2);
        toggleButton3 = findViewById(R.id.toggleButton3);
        btnTroVe = findViewById(R.id.btnTroVe);
    }
}