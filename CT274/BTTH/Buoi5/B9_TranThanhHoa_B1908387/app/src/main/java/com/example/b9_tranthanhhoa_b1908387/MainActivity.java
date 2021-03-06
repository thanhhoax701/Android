package com.example.b9_tranthanhhoa_b1908387;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnContact = this.findViewById(R.id.btnContact);
        Button btnCall = this.findViewById(R.id.btnCall);
        Button btnMedia = this.findViewById(R.id.btnMedia);

        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentContact = new Intent(MainActivity.this, DisplayAllContact.class);
                startActivity(intentContact);
            }
        });

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCallLog = new Intent(MainActivity.this, DisplayAllCallLog.class);
                startActivity(intentCallLog);
            }
        });

        btnMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentMedia = new Intent(MainActivity.this, MediaContent.class);
                startActivity(intentMedia);
            }
        });
    }
}