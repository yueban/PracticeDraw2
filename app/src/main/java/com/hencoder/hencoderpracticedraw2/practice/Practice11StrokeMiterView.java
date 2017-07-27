package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice11StrokeMiterView extends View {
    private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Path mPath = new Path();

    {
        mPaint.setStrokeWidth(40);
        mPaint.setStyle(Paint.Style.STROKE);

        mPath.rLineTo(200, 0);
        mPath.rLineTo(-160, 120);
    }

    public Practice11StrokeMiterView(Context context) {
        super(context);
    }

    public Practice11StrokeMiterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11StrokeMiterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();

        canvas.translate(100, 100);
        // MITER 值：1
        mPaint.setStrokeMiter(1);
        canvas.drawPath(mPath, mPaint);

        canvas.translate(300, 0);
        // MITER 值：2
        mPaint.setStrokeMiter(2);
        canvas.drawPath(mPath, mPaint);

        canvas.translate(300, 0);
        // MITER 值：5
        mPaint.setStrokeMiter(5);
        canvas.drawPath(mPath, mPaint);

        canvas.restore();
    }
}
