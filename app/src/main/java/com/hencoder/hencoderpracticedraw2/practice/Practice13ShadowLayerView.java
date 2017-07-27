package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice13ShadowLayerView extends View {
    private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    {
        // 使用 Paint.setShadowLayer() 设置阴影
    }

    public Practice13ShadowLayerView(Context context) {
        super(context);
    }

    public Practice13ShadowLayerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice13ShadowLayerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setTextSize(120);
        mPaint.setShadowLayer(10, 5, 5, Color.RED);
        canvas.drawText("Hello HenCoder", 50, 200, mPaint);
        mPaint.clearShadowLayer();
    }
}
