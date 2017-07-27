package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice10StrokeJoinView extends View {
    private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Path mPath = new Path();

    {
        mPaint.setStrokeWidth(40);
        mPaint.setStyle(Paint.Style.STROKE);

        mPath.rLineTo(200, 0);
        mPath.rLineTo(-160, 120);
    }

    public Practice10StrokeJoinView(Context context) {
        super(context);
    }

    public Practice10StrokeJoinView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10StrokeJoinView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();

        // 使用 Paint.setStrokeJoin() 来设置不同的拐角形状

        canvas.translate(100, 100);
        // 第一种形状：MITER
        canvas.drawPath(mPath, mPaint);

        canvas.translate(300, 0);
        // 第二种形状：BEVEL
        mPaint.setStrokeJoin(Paint.Join.BEVEL);
        canvas.drawPath(mPath, mPaint);

        canvas.translate(300, 0);
        // 第三种形状：ROUND
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        canvas.drawPath(mPath, mPaint);

        canvas.restore();
    }
}
