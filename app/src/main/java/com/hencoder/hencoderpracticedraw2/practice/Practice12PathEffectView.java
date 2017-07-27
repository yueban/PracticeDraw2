package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.graphics.SumPathEffect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice12PathEffectView extends View {
    private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Path mPath = new Path();

    {
        mPaint.setStyle(Paint.Style.STROKE);

        mPath.moveTo(50, 100);
        mPath.rLineTo(50, 100);
        mPath.rLineTo(80, -150);
        mPath.rLineTo(100, 100);
        mPath.rLineTo(70, -120);
        mPath.rLineTo(150, 80);
    }

    public Practice12PathEffectView(Context context) {
        super(context);
    }

    public Practice12PathEffectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice12PathEffectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 使用 Paint.setPathEffect() 来设置不同的 PathEffect

        // 第一处：CornerPathEffect
        mPaint.setPathEffect(new CornerPathEffect(50));
        canvas.drawPath(mPath, mPaint);

        canvas.save();
        canvas.translate(500, 0);
        // 第二处：DiscretePathEffect
        mPaint.setPathEffect(new DiscretePathEffect(30, 10));
        canvas.drawPath(mPath, mPaint);
        canvas.restore();

        canvas.save();
        canvas.translate(0, 200);
        // 第三处：DashPathEffect
        mPaint.setPathEffect(new DashPathEffect(new float[] { 10, 5, 30, 10 }, 30));
        canvas.drawPath(mPath, mPaint);
        canvas.restore();

        canvas.save();
        canvas.translate(500, 200);
        // 第四处：PathDashPathEffect
        Path path = new Path();
        path.lineTo(15, 30);
        path.rLineTo(15, -30);
        path.close();
        mPaint.setPathEffect(new PathDashPathEffect(path, 35, 10, PathDashPathEffect.Style.MORPH));
        canvas.drawPath(mPath, mPaint);
        canvas.restore();

        canvas.save();
        canvas.translate(0, 400);
        // 第五处：SumPathEffect
        PathEffect pathEffect1 = new DashPathEffect(new float[] { 10, 5, 20, 10 }, 5);
        PathEffect pathEffect2 = new DiscretePathEffect(30, 10);
        mPaint.setPathEffect(new SumPathEffect(pathEffect1, pathEffect2));
        canvas.drawPath(mPath, mPaint);
        canvas.restore();

        canvas.save();
        canvas.translate(500, 400);
        // 第六处：ComposePathEffect
        mPaint.setPathEffect(new ComposePathEffect(pathEffect1, pathEffect2));
        //mPaint.setPathEffect(new ComposePathEffect(pathEffect2, pathEffect1));
        canvas.drawPath(mPath, mPaint);
        canvas.restore();
    }
}
