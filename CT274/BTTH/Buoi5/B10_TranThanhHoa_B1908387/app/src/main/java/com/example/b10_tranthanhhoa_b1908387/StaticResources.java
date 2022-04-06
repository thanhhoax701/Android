package com.example.b10_tranthanhhoa_b1908387;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StaticResources extends AppCompatActivity {
    TextView textBoxdh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static_resources);

        textBoxdh = (TextView) findViewById(R.id.edithd);
        // Load tập tin văn bản trong thư mục raw
        InputStream is = this.getResources().openRawResource(R.raw.huongdan);
        InputStreamReader ir = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(ir);
        String str = "";
        String buffer;
        try {
            if ((buffer = br.readLine()) != null) {
                str += buffer;
            }
            is.close();
            br.close();
            textBoxdh.setText(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}