package com.example.intent_manifest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Lấy ra nút
        button = (Button) findViewById(R.id.btn);
//        Tạo sự kiện khi click vào button thì chuyển sang activity 2
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(i);
//                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/thanhhoax701/"));
//                startActivity(i);
            }
        });
    }
}