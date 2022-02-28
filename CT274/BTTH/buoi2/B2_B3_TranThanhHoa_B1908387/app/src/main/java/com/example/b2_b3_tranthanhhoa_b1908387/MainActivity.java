package com.example.b2_b3_tranthanhhoa_b1908387;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Khai báo 1 thể hiện của lớp VeCoBan
//        VeCoBan ve = new VeCoBan(this);
//        setContentView(ve);

        // Khai báo 1 thể hiện của lớp ChuyenDong
//        View chuyenDong=new ChuyenDong(this);
//        setContentView(chuyenDong);

        // Khai báo 1 thể hiện của lớp TuongTac
//        View tuongTac = new TuongTac(this);
//        setContentView(tuongTac);

        // Khai báo 1 thể hiện của lớp GamePanel
//        GamePanel gamePanel = new GamePanel(this);
//        setContentView(gamePanel);

        final FrameLayout hienThi = (FrameLayout) findViewById(R.id.framelayout);
        Button bai1 = (Button) findViewById(R.id.class1);
        Button bai2 = (Button) findViewById(R.id.class2);
        Button bai3 = (Button) findViewById(R.id.class3);
        Button bai4 = (Button) findViewById(R.id.class4);
        Button thoat = (Button) findViewById(R.id.button1);
        Button trove = (Button) findViewById(R.id.button2);

        final VeCoBan ve = new VeCoBan(this);
        bai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hienThi.addView(ve);
            }
        });

        final ChuyenDong chuyenDong = new ChuyenDong(this);
        bai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hienThi.addView(chuyenDong);
            }
        });

        final TuongTac tuongTac = new TuongTac(this);
        bai3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hienThi.addView(tuongTac);
            }
        });

        final SurfaceView viewSF = new GamePanel(this);
        bai4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hienThi.addView(viewSF);
            }
        });

        thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });

        trove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }
}