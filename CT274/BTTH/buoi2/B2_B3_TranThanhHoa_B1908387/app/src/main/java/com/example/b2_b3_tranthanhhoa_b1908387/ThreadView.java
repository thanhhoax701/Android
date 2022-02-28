package com.example.b2_b3_tranthanhhoa_b1908387;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class ThreadView extends Thread{
    private GamePanel mPanel; // Khai báo 1 thể hiện của lớp Gamepanel
    private SurfaceHolder mHolder; //Khai báo 1 đối tượng quản lý giao diện mức thấp
    private boolean mRun = false; // Khai báo biền điều kiện cho vòng lặp while

    public ThreadView(GamePanel mPanel) {
        this.mPanel = mPanel;
        mHolder = mPanel.getHolder();
    }

    public void setRunning(boolean run){
        mRun = run;
    }

    @Override
    public void run() {
        Canvas canvas = null;
        while (mRun){
            canvas = mHolder.lockCanvas(); // Hàm lockCanvas () tạo một canvas để vẽ
            if(canvas != null) {
                mPanel.doDraw(canvas); //Thực hiện hành động trên canvas (hiển thị)
                mHolder.unlockCanvasAndPost(canvas); //Hoàn thành việc vẽ trên canvas
            }
        }
    }
}
