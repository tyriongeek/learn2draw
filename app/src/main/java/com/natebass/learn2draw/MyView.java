package com.natebass.learn2draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

/**
 * Created by nwb on 11/24/14.
 */
public class MyView extends View {
    Rect rect;
    Paint paint;

    public MyView(Context context) {
        super(context);

        rect = new Rect();
        paint = new Paint();
    }

    public void onDraw(Canvas canvas) {
        rect.set(0, 0, 50, 50);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);

        canvas.drawRect(rect, paint);
    }
}
