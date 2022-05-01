package com.example.b2_b3_tranthanhhoa_b1908387;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class ThreadView extends Thread {
    private GamePanel mPanel;
    private SurfaceHolder mHolder;
    private boolean mRun = false;

    public ThreadView(GamePanel mPanel) {
        this.mPanel = mPanel;
        mHolder = mPanel.getHolder();
    }

    public void setRunning(boolean run) {
        mRun = run;
    }

    @Override
    public void run() {
        Canvas canvas = null;
        while (mRun) {
            // Hàm lockCanvas () tạo một canvas để vẽ
            canvas = mHolder.lockCanvas();
            if (canvas != null) {
                mPanel.doDraw(canvas); //Thực hiện hành động trên canvas (hiển thị)
                mHolder.unlockCanvasAndPost(canvas); //Hoàn thành việc vẽ trên canvas
            }
        }
    }
}
