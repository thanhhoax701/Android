package com.example.b2_b3_tranthanhhoa_b1908387;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.sql.Time;

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {
    Bitmap bitmap;
    int count = 10;
    Time time = new Time();
    ThreadView thread;
    int dia;
    int kq = 0;
    int x, y;
    int X;
    int Y;
    Bug bug;
    float dis;


    public GamePanel(Context context) {
        super(context);
        bug = new Bug(context);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bug);
        dia = bitmap.getWidth();
        getHolder().addCallback(this);
        thread = new ThreadView(this);
        time.start();
    }

    @SuppressLint("WrongCall")
    public void doDraw(Canvas c) {
        if (count > 0) {
            bug.onDraw(c);
            Paint tpaint = new Paint();
            tpaint.setColor(Color.BLACK);
            tpaint.setTextSize(80);
            c.drawText("Time: " + count, 100, 200, tpaint);
        } else if (count <= 0) {
            if (kq >= 3) {
                Paint spaint = new Paint();
                spaint.setColor(Color.BLACK);
                c.drawPaint(spaint);
                spaint.setColor(Color.WHITE);
                spaint.setTextSize(90);
                spaint.setTextAlign(Paint.Align.CENTER);
                c.drawText("YOU WIN!", c.getWidth() / 2, c.getHeight() / 2 - 80, spaint);
                c.drawText("Record: " + kq, c.getWidth() / 2, c.getHeight() / 2, spaint);
                spaint.setTextAlign(Paint.Align.CENTER);
                c.drawText("touch to quit", c.getWidth() / 2, c.getHeight() / 2 + 80, spaint);
            } else if (kq < 3) {
                Paint spaint = new Paint();
                spaint.setColor(Color.BLACK);
                c.drawPaint(spaint);
                spaint.setColor(Color.WHITE);
                spaint.setTextSize(90);
                spaint.setTextAlign(Paint.Align.CENTER);
                c.drawText("YOU LOSE!", c.getWidth() / 2, c.getHeight() / 2 - 80, spaint);
                c.drawText("Record: " + kq, c.getWidth() / 2, c.getHeight() / 2, spaint);
                spaint.setTextAlign(Paint.Align.CENTER);
                c.drawText("touch to quit", c.getWidth() / 2, c.getHeight() / 2 + 80, spaint);
            }
        }
    }


    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        // TODO Auto-generated method stub
        if (!thread.isAlive()) {
            thread = new ThreadView(this);
            thread.setRunning(true);
            thread.start();
        }
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
        if (thread.isAlive()) {
            thread.setRunning(false);
        }
    }

    public class Time extends Thread {
        @Override
        public void run() {
            while (count > 0) {
                try {
                    count--;
                    // Thời gian còn lại
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        int eventaction = event.getAction();
        X = (int) event.getX();
        Y = (int) event.getY();
        switch (eventaction) {
            case MotionEvent.ACTION_DOWN: {
                int centerX = bug.x + dia;
                int centerY = bug.y + dia;
                dis = (float) Math.sqrt((((centerX - X) * (centerX - X)) + (centerY - Y) * (centerY - Y)));
                if (count > 0) {
                    if (dis < dia) {
                        kq++;
                        bug.x = 100;
                        bug.y = 100;
                    }
                }
                if (count <= 0) {
                    System.exit(0);
                }
            }
            default:
                break;
        }
        return super.onTouchEvent(event);
    }
}
