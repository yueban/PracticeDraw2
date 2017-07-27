package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice09StrokeCapView extends View {
    private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    {
        mPaint.setStrokeWidth(40);
    }

    public Practice09StrokeCapView(Context context) {
        super(context);
    }

    public Practice09StrokeCapView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice09StrokeCapView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 使用 Paint.setStrokeCap() 来设置端点形状

        // 第一个：BUTT
        mPaint.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawLine(50, 50, 400, 50, mPaint);

        // 第二个：ROUND
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawLine(50, 150, 400, 150, mPaint);

        // 第三个：SQUARE
        mPaint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawLine(50, 250, 400, 250, mPaint);
    }
}
