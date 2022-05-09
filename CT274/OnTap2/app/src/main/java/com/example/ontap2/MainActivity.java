package com.example.ontap2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg1, rg2, rg3;
    RadioButton rbOn1, rbOff1, rbOn2, rbOff2, rbOn3, rbOff3;
    TextView tv1, tv2, tv3;
    String on = "ON", off = "OFF", tt1 = "OFF", tt2 = "OFF", tt3 = "OFF";
    Button btnDieuKhien, btnThoat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Anhxa();

        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (rbOn1.isChecked()) {
                    tt1 = "ON";
                    tv1.setText(on);
                }
                if (rbOff1.isChecked()) {
                    tt1 = "OFF";
                    tv1.setText(off);
                }
            }
        });

        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (rbOn2.isChecked()) {
                    tt2 = "ON";
                    tv2.setText(on);
                }
                if (rbOff2.isChecked()) {
                    tt2 = "OFF";
                    tv2.setText(off);
                }
            }
        });

        rg3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (rbOn3.isChecked()) {
                    tt3 = "ON";
                    tv3.setText(on);
                }
                if (rbOff3.isChecked()) {
                    tt3 = "OFF";
                    tv3.setText(off);
                }
            }
        });

        btnDieuKhien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                Bundle bundle = new Bundle();
                bundle.putString("tt1", tt1);
                bundle.putString("tt2", tt2);
                bundle.putString("tt3", tt3);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });
    }

    private void Anhxa() {
        rg1 = findViewById(R.id.rg1);
        rg2 = findViewById(R.id.rg2);
        rg3 = findViewById(R.id.rg3);
        rbOn1 = findViewById(R.id.rbOn1);
        rbOff1 = findViewById(R.id.rbOff1);
        rbOn2 = findViewById(R.id.rbOn2);
        rbOff2 = findViewById(R.id.rbOff2);
        rbOn3 = findViewById(R.id.rbOn3);
        rbOff3 = findViewById(R.id.rbOff3);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        btnDieuKhien = findViewById(R.id.btnDieuKhien);
        btnThoat = findViewById(R.id.btnThoat);
    }
}