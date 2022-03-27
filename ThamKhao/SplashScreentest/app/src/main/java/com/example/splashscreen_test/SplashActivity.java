package com.example.splashscreen_test;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

//        Thread splashScreenStarter = new Thread() {
//            public void run() {
//                try {
//                    int delay = 0;
//                    while (delay < 2000) {
//                        sleep(150);
//                        delay = delay + 100;
//                    }
//                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
//
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } finally {
//                    finish();
//                }
//            }
//
//        };
//        splashScreenStarter.start();

        new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(SplashActivity.this, MainActivity.class));
                        finish();
                    }
                }, 3000);

    }
}