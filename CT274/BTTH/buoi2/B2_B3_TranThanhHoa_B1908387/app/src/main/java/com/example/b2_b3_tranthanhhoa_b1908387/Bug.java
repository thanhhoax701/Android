package com.example.b2_b3_tranthanhhoa_b1908387;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Bug {
    Bitmap background;
    Bitmap bitmap;
    int dia;
    int x = 70;
    int y = 70;
    int w, h;
    int sX = 30;
    int sY = 30;

    public Bug(Context context){
        Resources res = context.getResources();
        bitmap = BitmapFactory.decodeResource(res,R.drawable.bug);
        background = BitmapFactory.decodeResource(res, R.drawable.background);
    }

    public void onDraw(Canvas c) {
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        dia = bitmap.getWidth();
        w = c.getWidth();
        h = c.getHeight();
        c.drawPaint(paint);
        c.drawBitmap(background, 0, 0, paint);
        c.drawBitmap(bitmap, x, y, paint);
        x += sX;
        y += sY;
        //Neu cham bien thi quay lai va doi Ball
        if (x<=0||(x>=w- dia)) {
            sX = -sX;
        }
        if (y<=0||y>=h-dia) {
            sY = -sY;
        }
    }
}
