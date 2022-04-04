package com.example.vedothi_tranthanhhoa_b1908387;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class NhaplieuLinesPlot extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhaplieu_lines_plot);

        // Mảng giá trị trên trục x
        final EditText edx1 = (EditText) findViewById(R.id.edtx1);
        final EditText edx2 = (EditText) findViewById(R.id.edtx2);
        final EditText edx3 = (EditText) findViewById(R.id.edtx3);
        final EditText edx4 = (EditText) findViewById(R.id.edtx4);
        final EditText edx5 = (EditText) findViewById(R.id.edtx5);
        final EditText edx6 = (EditText) findViewById(R.id.edtx6);
        final EditText edx7 = (EditText) findViewById(R.id.edtx7);
        final EditText edx8 = (EditText) findViewById(R.id.edtx8);
        final EditText edx9 = (EditText) findViewById(R.id.edtx9);
        final EditText edx10 = (EditText) findViewById(R.id.edtx10);

        // Mảng giá trị trên trục y
        final EditText edy1 = (EditText) findViewById(R.id.edty1);
        final EditText edy2 = (EditText) findViewById(R.id.edty2);
        final EditText edy3 = (EditText) findViewById(R.id.edty3);
        final EditText edy4 = (EditText) findViewById(R.id.edty4);
        final EditText edy5 = (EditText) findViewById(R.id.edty5);
        final EditText edy6 = (EditText) findViewById(R.id.edty6);
        final EditText edy7 = (EditText) findViewById(R.id.edty7);
        final EditText edy8 = (EditText) findViewById(R.id.edty8);
        final EditText edy9 = (EditText) findViewById(R.id.edty9);
        final EditText edy10 = (EditText) findViewById(R.id.edty10);

        Button nhap = (Button) findViewById(R.id.btnnhap);
        Button ve = (Button) findViewById(R.id.ve);
        Button trove = (Button) findViewById(R.id.trove);
        final EditText sodiemx = (EditText) findViewById(R.id.sodiem);

        nhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sodiemve = Integer.parseInt(sodiemx.getText().toString());
                if (sodiemve < 4 & sodiemve > 10) {
                    Toast.makeText(NhaplieuLinesPlot.this, "Phải nhập số điểm trong khoảng từ 4 đến 10", Toast.LENGTH_LONG).show();
                } else if (sodiemve == 4) {
                    edx1.setVisibility(View.VISIBLE);
                    edy1.setVisibility(View.VISIBLE);
                    edx2.setVisibility(View.VISIBLE);
                    edy2.setVisibility(View.VISIBLE);
                    edx3.setVisibility(View.VISIBLE);
                    edy3.setVisibility(View.VISIBLE);
                    edx4.setVisibility(View.VISIBLE);
                    edy4.setVisibility(View.VISIBLE);
                } else if (sodiemve == 5) {
                    edx1.setVisibility(View.VISIBLE);
                    edy1.setVisibility(View.VISIBLE);
                    edx2.setVisibility(View.VISIBLE);
                    edy2.setVisibility(View.VISIBLE);
                    edx3.setVisibility(View.VISIBLE);
                    edy3.setVisibility(View.VISIBLE);
                    edx4.setVisibility(View.VISIBLE);
                    edy4.setVisibility(View.VISIBLE);
                    edx5.setVisibility(View.VISIBLE);
                    edy5.setVisibility(View.VISIBLE);
                } else if (sodiemve == 6) {
                    edx1.setVisibility(View.VISIBLE);
                    edy1.setVisibility(View.VISIBLE);
                    edx2.setVisibility(View.VISIBLE);
                    edy2.setVisibility(View.VISIBLE);
                    edx3.setVisibility(View.VISIBLE);
                    edy3.setVisibility(View.VISIBLE);
                    edx4.setVisibility(View.VISIBLE);
                    edy4.setVisibility(View.VISIBLE);
                    edx5.setVisibility(View.VISIBLE);
                    edy5.setVisibility(View.VISIBLE);
                    edx6.setVisibility(View.VISIBLE);
                    edy6.setVisibility(View.VISIBLE);

                } else if (sodiemve == 7) {
                    edx1.setVisibility(View.VISIBLE);
                    edy1.setVisibility(View.VISIBLE);
                    edx2.setVisibility(View.VISIBLE);
                    edy2.setVisibility(View.VISIBLE);
                    edx3.setVisibility(View.VISIBLE);
                    edy3.setVisibility(View.VISIBLE);
                    edx4.setVisibility(View.VISIBLE);
                    edy4.setVisibility(View.VISIBLE);
                    edx5.setVisibility(View.VISIBLE);
                    edy5.setVisibility(View.VISIBLE);
                    edx6.setVisibility(View.VISIBLE);
                    edy6.setVisibility(View.VISIBLE);
                    edx7.setVisibility(View.VISIBLE);
                    edy7.setVisibility(View.VISIBLE);

                } else if (sodiemve == 8) {
                    edx1.setVisibility(View.VISIBLE);
                    edy1.setVisibility(View.VISIBLE);
                    edx2.setVisibility(View.VISIBLE);
                    edy2.setVisibility(View.VISIBLE);
                    edx3.setVisibility(View.VISIBLE);
                    edy3.setVisibility(View.VISIBLE);
                    edx4.setVisibility(View.VISIBLE);
                    edy4.setVisibility(View.VISIBLE);
                    edx5.setVisibility(View.VISIBLE);
                    edy5.setVisibility(View.VISIBLE);
                    edx6.setVisibility(View.VISIBLE);
                    edy6.setVisibility(View.VISIBLE);
                    edx7.setVisibility(View.VISIBLE);
                    edy7.setVisibility(View.VISIBLE);
                    edx8.setVisibility(View.VISIBLE);
                    edy8.setVisibility(View.VISIBLE);

                } else if (sodiemve == 9) {
                    edx1.setVisibility(View.VISIBLE);
                    edy1.setVisibility(View.VISIBLE);
                    edx2.setVisibility(View.VISIBLE);
                    edy2.setVisibility(View.VISIBLE);
                    edx3.setVisibility(View.VISIBLE);
                    edy3.setVisibility(View.VISIBLE);
                    edx4.setVisibility(View.VISIBLE);
                    edy4.setVisibility(View.VISIBLE);
                    edx5.setVisibility(View.VISIBLE);
                    edy5.setVisibility(View.VISIBLE);
                    edx6.setVisibility(View.VISIBLE);
                    edy6.setVisibility(View.VISIBLE);
                    edx7.setVisibility(View.VISIBLE);
                    edy7.setVisibility(View.VISIBLE);
                    edx8.setVisibility(View.VISIBLE);
                    edy8.setVisibility(View.VISIBLE);
                    edx9.setVisibility(View.VISIBLE);
                    edy9.setVisibility(View.VISIBLE);

                } else if (sodiemve == 10) {
                    edx1.setVisibility(View.VISIBLE);
                    edy1.setVisibility(View.VISIBLE);
                    edx2.setVisibility(View.VISIBLE);
                    edy2.setVisibility(View.VISIBLE);
                    edx3.setVisibility(View.VISIBLE);
                    edy3.setVisibility(View.VISIBLE);
                    edx4.setVisibility(View.VISIBLE);
                    edy4.setVisibility(View.VISIBLE);
                    edx5.setVisibility(View.VISIBLE);
                    edy5.setVisibility(View.VISIBLE);
                    edx6.setVisibility(View.VISIBLE);
                    edy6.setVisibility(View.VISIBLE);
                    edx7.setVisibility(View.VISIBLE);
                    edy7.setVisibility(View.VISIBLE);
                    edx8.setVisibility(View.VISIBLE);
                    edy8.setVisibility(View.VISIBLE);
                    edx9.setVisibility(View.VISIBLE);
                    edy9.setVisibility(View.VISIBLE);
                    edx10.setVisibility(View.VISIBLE);
                    edy10.setVisibility(View.VISIBLE);
                }
            }
        });

        ve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sodiemve = Integer.parseInt(sodiemx.getText().toString());
                if (sodiemve==4) {
                    ArrayList<String> trucx = new ArrayList<>();
                    ArrayList<String> trucy = new ArrayList<>();
                    trucx.add(edx1.getText().toString());
                    trucx.add(edx2.getText().toString());
                    trucx.add(edx3.getText().toString());
                    trucx.add(edx4.getText().toString());
                    trucy.add(edy1.getText().toString());
                    trucy.add(edy2.getText().toString());
                    trucy.add(edy3.getText().toString());
                    trucy.add(edy4.getText().toString());

                    Intent intent = new Intent(NhaplieuLinesPlot.this, LinesPlotActivity.class);
                    //Tạo 1 đối tượng Bundle để gửi đi cùng Intent
                    Bundle sendBundle = new Bundle();
                    sendBundle.putStringArrayList("xLabels", trucx);
                    sendBundle.putStringArrayList("yData", trucy);
                    intent.putExtras(sendBundle); // Dùng hàm putExtras
                    startActivity(intent);
                }
                else if (sodiemve==5) {
                    ArrayList<String> trucx = new ArrayList<>();
                    ArrayList<String> trucy = new ArrayList<>();
                    trucx.add(edx1.getText().toString());
                    trucx.add(edx2.getText().toString());
                    trucx.add(edx3.getText().toString());
                    trucx.add(edx4.getText().toString());
                    trucx.add(edx5.getText().toString());
                    trucy.add(edy1.getText().toString());
                    trucy.add(edy2.getText().toString());
                    trucy.add(edy3.getText().toString());
                    trucy.add(edy4.getText().toString());
                    trucy.add(edy5.getText().toString());
                    Intent intent = new Intent(NhaplieuLinesPlot.this, LinesPlotActivity.class);
                    //Tạo 1 đối tượng Bundle để gửi đi cùng Intent
                    Bundle sendBundle = new Bundle();
                    sendBundle.putStringArrayList("xLabels", trucx);
                    sendBundle.putStringArrayList("yData", trucy);
                    intent.putExtras(sendBundle); // Dùng hàm putExtras
                    startActivity(intent);
                }
                else if (sodiemve==6){
                    ArrayList<String> trucx = new ArrayList<>();
                    ArrayList<String> trucy = new ArrayList<>();
                    trucx.add(edx1.getText().toString());
                    trucx.add(edx2.getText().toString());
                    trucx.add(edx3.getText().toString());
                    trucx.add(edx4.getText().toString());
                    trucx.add(edx5.getText().toString());
                    trucx.add(edx6.getText().toString());
                    trucy.add(edy1.getText().toString());
                    trucy.add(edy2.getText().toString());
                    trucy.add(edy3.getText().toString());
                    trucy.add(edy4.getText().toString());
                    trucy.add(edy5.getText().toString());
                    trucy.add(edy6.getText().toString());
                    Intent intent = new Intent(NhaplieuLinesPlot.this, LinesPlotActivity.class);
                    //Tạo 1 đối tượng Bundle để gửi đi cùng Intent
                    Bundle sendBundle = new Bundle();
                    sendBundle.putStringArrayList("xLabels", trucx);
                    sendBundle.putStringArrayList("yData", trucy);
                    intent.putExtras(sendBundle); // Dùng hàm putExtras
                    startActivity(intent);
                }
                else if (sodiemve==7){
                    ArrayList<String> trucx = new ArrayList<>();
                    ArrayList<String> trucy = new ArrayList<>();
                    trucx.add(edx1.getText().toString());
                    trucx.add(edx2.getText().toString());
                    trucx.add(edx3.getText().toString());
                    trucx.add(edx4.getText().toString());
                    trucx.add(edx5.getText().toString());
                    trucx.add(edx6.getText().toString());
                    trucx.add(edx7.getText().toString());
                    trucy.add(edy1.getText().toString());
                    trucy.add(edy2.getText().toString());
                    trucy.add(edy3.getText().toString());
                    trucy.add(edy4.getText().toString());
                    trucy.add(edy5.getText().toString());
                    trucy.add(edy6.getText().toString());
                    trucy.add(edy7.getText().toString());
                    Intent intent = new Intent(NhaplieuLinesPlot.this,
                            LinesPlotActivity.class);
                    //Tạo 1 đối tượng Bundle để gửi đi cùng Intent
                    Bundle sendBundle = new Bundle();
                    sendBundle.putStringArrayList("xLabels", trucx);
                    sendBundle.putStringArrayList("yData", trucy);
                    intent.putExtras(sendBundle); // Dùng hàm putExtras
                    startActivity(intent);
                }
                else if (sodiemve==8){
                    ArrayList<String> trucx = new ArrayList<>();
                    ArrayList<String> trucy = new ArrayList<>();
                    trucx.add(edx1.getText().toString());
                    trucx.add(edx2.getText().toString());
                    trucx.add(edx3.getText().toString());
                    trucx.add(edx4.getText().toString());
                    trucx.add(edx5.getText().toString());
                    trucx.add(edx6.getText().toString());
                    trucx.add(edx7.getText().toString());
                    trucx.add(edx8.getText().toString());
                    trucy.add(edy1.getText().toString());
                    trucy.add(edy2.getText().toString());
                    trucy.add(edy3.getText().toString());
                    trucy.add(edy4.getText().toString());
                    trucy.add(edy5.getText().toString());
                    trucy.add(edy6.getText().toString());
                    trucy.add(edy7.getText().toString());
                    trucy.add(edy8.getText().toString());
                    Intent intent = new Intent(NhaplieuLinesPlot.this,
                            LinesPlotActivity.class);
                    //Tạo 1 đối tượng Bundle để gửi đi cùng Intent
                    Bundle sendBundle = new Bundle();
                    sendBundle.putStringArrayList("xLabels", trucx);
                    sendBundle.putStringArrayList("yData", trucy);
                    intent.putExtras(sendBundle); // Dùng hàm putExtras
                    startActivity(intent);
                }
                else if (sodiemve==9){
                    ArrayList<String> trucx = new ArrayList<>();
                    ArrayList<String> trucy = new ArrayList<>();
                    trucx.add(edx1.getText().toString());
                    trucx.add(edx2.getText().toString());
                    trucx.add(edx3.getText().toString());
                    trucx.add(edx4.getText().toString());
                    trucx.add(edx5.getText().toString());
                    trucx.add(edx6.getText().toString());
                    trucx.add(edx7.getText().toString());
                    trucx.add(edx8.getText().toString());
                    trucx.add(edx9.getText().toString());
                    trucy.add(edy1.getText().toString());
                    trucy.add(edy2.getText().toString());
                    trucy.add(edy3.getText().toString());
                    trucy.add(edy4.getText().toString());
                    trucy.add(edy5.getText().toString());
                    trucy.add(edy6.getText().toString());
                    trucy.add(edy7.getText().toString());
                    trucy.add(edy8.getText().toString());
                    trucy.add(edy9.getText().toString());
                    Intent intent = new Intent(NhaplieuLinesPlot.this,
                            LinesPlotActivity.class);
                    //Tạo 1 đối tượng Bundle để gửi đi cùng Intent
                    Bundle sendBundle = new Bundle();
                    sendBundle.putStringArrayList("xLabels", trucx);
                    sendBundle.putStringArrayList("yData", trucy);
                    intent.putExtras(sendBundle); // Dùng hàm putExtras
                    startActivity(intent);
                }
                else if (sodiemve==10){
                    ArrayList<String> trucx = new ArrayList<>();
                    ArrayList<String> trucy = new ArrayList<>();
                    trucx.add(edx1.getText().toString());
                    trucx.add(edx2.getText().toString());
                    trucx.add(edx3.getText().toString());
                    trucx.add(edx4.getText().toString());
                    trucx.add(edx5.getText().toString());
                    trucx.add(edx6.getText().toString());
                    trucx.add(edx7.getText().toString());
                    trucx.add(edx8.getText().toString());
                    trucx.add(edx9.getText().toString());
                    trucx.add(edx10.getText().toString());
                    trucy.add(edy1.getText().toString());
                    trucy.add(edy2.getText().toString());
                    trucy.add(edy3.getText().toString());
                    trucy.add(edy4.getText().toString());
                    trucy.add(edy5.getText().toString());
                    trucy.add(edy6.getText().toString());
                    trucy.add(edy7.getText().toString());
                    trucy.add(edy8.getText().toString());
                    trucy.add(edy9.getText().toString());
                    trucy.add(edy10.getText().toString());
                    Intent intent = new Intent(NhaplieuLinesPlot.this, LinesPlotActivity.class);
                    //Tạo 1 đối tượng Bundle để gửi đi cùng Intent
                    Bundle sendBundle = new Bundle();
                    sendBundle.putStringArrayList("xLabels", trucx);
                    sendBundle.putStringArrayList("yData", trucy);
                    intent.putExtras(sendBundle); // Dùng hàm putExtras
                    startActivity(intent);
                }
            }
        });

        trove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}