package com.example.b2_b3_tranthanhhoa_b1908387;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        // Khai báo 1 thể hiện của lớp VeCoBan
//        VeCoBan ve = new VeCoBan(this);
//        setContentView(ve);

        // Khai báo 1 thể hiện của lớp ChuyenDong
//        View chuyenDong=new ChuyenDong(this);
//        setContentView(chuyenDong);

        // Khai báo 1 thể hiện của lớp TuongTac
        View tuongTac = new TuongTac(this);
        setContentView(tuongTac);
    }
}