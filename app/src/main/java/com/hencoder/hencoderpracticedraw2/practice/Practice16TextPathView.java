package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice16TextPathView extends View {
    private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint mPathPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Path mTextPath = new Path();
    private final String text = "Hello HenCoder";

    {
        mPaint.setTextSize(120);

        // 使用 Paint.getTextPath() 来获取文字的 Path
        mPaint.getTextPath(text, 0, text.length(), 50, 300, mTextPath);
        mPathPaint.setStyle(Paint.Style.STROKE);
    }

    public Practice16TextPathView(Context context) {
        super(context);
    }

    public Practice16TextPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice16TextPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawText(text, 50, 200, mPaint);

        canvas.drawPath(mTextPath, mPathPaint);
    }
}
