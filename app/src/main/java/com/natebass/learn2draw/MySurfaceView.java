package com.natebass.learn2draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    private MyAnimationThread animThread = null;

    int player1;
    int player2;
    Rect r;
    Paint blue;

    public MySurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.player1 = 1;
        this.player2 = 2;
        r = new Rect();
        blue = new Paint();
        getHolder().addCallback(this);
    }

    public void onDraw(Canvas c) {
        super.onDraw(c);
        r.set(0, 0, c.getWidth(), c.getHeight()/2);
        blue.setColor(123);
        blue.setStyle(Paint.Style.FILL);
        c.drawRect(r, blue);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        if (animThread != null) return;
        animThread = new MyAnimationThread(getHolder());
        animThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        animThread.stop = true;
    }

    public class MyAnimationThread extends Thread {
        public boolean stop = false;
        private SurfaceHolder surfaceHolder;
        int headingDirection;

        public MyAnimationThread(SurfaceHolder s) {
            this.surfaceHolder = s;
            headingDirection = 1;
        }

        public void run() {
            while (!stop) {
                Canvas c = null;
                try {
                    c = surfaceHolder.lockCanvas(null);
                    synchronized (surfaceHolder) {
                        draw(c);
                    }
                } finally {
                    if (c != null) {
                        surfaceHolder.unlockCanvasAndPost(c);
                    }
                }
            }
        }
    }

}


