package com.example.ontap;

import static java.lang.String.format;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {
    EditText edt1, edt2, edt3;
    Button btnTiepTuc, btnDTB, btnThoat;
    TextView tvShowKq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Anhxa();

        btnTiepTuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Activity2.this, "Tiếp tục đi", Toast.LENGTH_SHORT).show();
            }
        });

        btnDTB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double d1,d2,d3;
                d1 = Double.parseDouble(edt1.getText().toString());
                d2 = Double.parseDouble(edt2.getText().toString());
                d3 = Double.parseDouble(edt3.getText().toString());
                tvShowKq.setText(String.valueOf(format("%.1f", (d1+d2+d3)/3)));
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void Anhxa() {
        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);
        edt3 = findViewById(R.id.edt3);
        btnTiepTuc = findViewById(R.id.btnTiepTuc);
        btnDTB = findViewById(R.id.btnDTB);
        btnThoat = findViewById(R.id.btnThoat);
        tvShowKq = findViewById(R.id.tvShowKq);
    }
}