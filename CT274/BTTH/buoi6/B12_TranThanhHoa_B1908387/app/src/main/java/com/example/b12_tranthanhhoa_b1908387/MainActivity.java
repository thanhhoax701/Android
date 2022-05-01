package com.example.b12_tranthanhhoa_b1908387;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnKt, btnHttpGet, btnHttpPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Anhxa();

        btnKt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, KT_KetNoi.class);
                startActivity(intent1);
            }
        });

        btnHttpGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this, Kn_HttpGet.class);
                startActivity(intent2);
            }
        });

        btnHttpPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(MainActivity.this, Kn_Http_Post.class);
                startActivity(intent3);
            }
        });
    }

    private void Anhxa() {
        btnKt = findViewById(R.id.btnKt);
        btnHttpGet = findViewById(R.id.btnHttpget);
        btnHttpPost = findViewById(R.id.btnHttppost);
    }
}