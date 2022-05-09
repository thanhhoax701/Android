package com.example.thithu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg1,rg2,rg3;
    TextView tv1,tv2,tv3;
    RadioButton rg1_btn1,rg1_btn2,rg2_btn1,rg2_btn2,rg3_btn1,rg3_btn2;
    String on="ON", off="OFF",tt1="OFF",tt2="OFF",tt3="OFF";
    Button btn_dieukhien,thoat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg1 = findViewById(R.id.rg1);
        rg2 = findViewById(R.id.rg2);
        rg3 = findViewById(R.id.rg3);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        rg1_btn1 = findViewById(R.id.rg1_btn1);
        rg1_btn2 = findViewById(R.id.rg1_btn2);
        btn_dieukhien = findViewById(R.id.btn_dieukhien);
        thoat = findViewById(R.id.btn_thoat);
        rg2_btn1 = findViewById(R.id.rg2_btn1);
        rg2_btn2 = findViewById(R.id.rg2_btn2);
        rg3_btn1 = findViewById(R.id.rg3_btn1);
        rg3_btn2 = findViewById(R.id.rg3_btn2);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (rg1_btn1.isChecked()){
                    tt1 = "ON";
                    tv1.setText(on);
                }
                if (rg1_btn2.isChecked()){
                    tt1 = "OFF";
                    tv1.setText(off);
                }
            }
        });
        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (rg2_btn1.isChecked()){
                    tt2 = "ON";
                    tv2.setText(on);
                }
                if (rg2_btn2.isChecked()){
                    tt2 = "OFF";
                    tv2.setText(off);
                }
            }
        });
        rg3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (rg3_btn1.isChecked()){
                    tt3 = "ON";
                    tv3.setText(on);
                }
                if (rg3_btn2.isChecked()){
                    tt3 = "OFF";
                    tv3.setText(off);
                }
            }
        });
        btn_dieukhien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,DieuKhien.class);
                Bundle bundle = new Bundle();
                bundle.putString("tt1",tt1);
                bundle.putString("tt2",tt2);
                bundle.putString("tt3",tt3);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
        thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });
    }
}