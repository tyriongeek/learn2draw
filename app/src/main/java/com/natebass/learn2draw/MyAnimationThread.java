/*
package com.natebass.learn2draw;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

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
                    onDraw(c);
                }
            } finally {
                if (c != null) {
                    surfaceHolder.unlockCanvasAndPost(c);
                }
            }
        }
    }
}
*/
