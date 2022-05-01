package com.example.b2_b3_tranthanhhoa_b1908387;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class ChuyenDong extends View {
    private float ballSpeedX = 4; // Tốc độ chuyển động.
    private float ballSpeedY = 7;
    private float x = 10; //Toạ độ ban đầu.
    private float y = 10;
    private float diameter;// Đường kính
    Paint paint = new Paint();
    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.network);

    public ChuyenDong(Context context) {
        super(context);
    } //lệnh contructor

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPaint(paint);
        canvas.drawBitmap(bitmap, x, y, paint);
        diameter = bitmap.getWidth();
        update();
        invalidate(); // Buột vẽ lại.
    }

    private void update() {
        // Lấy toạ độ mới (x,y) để vẽ quả địa cầu chuyển động ngẫu nhiên.
        x += ballSpeedX;
        y += ballSpeedY;
        //Nếu chạm biên thì đổi ảnh và đổi chiểu chuyển động.
        if (x <= 0 || (x >= getWidth() - diameter)) {
            ballSpeedX = -ballSpeedX;
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.network);
        }
        if (y <= 0 || y >= getHeight() - diameter) {
            ballSpeedY = -ballSpeedY;
            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.internet);
        }
    }
}
