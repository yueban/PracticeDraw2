package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice02RadialGradientView extends View {
    private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    {
        // 用 Paint.setShader(shader) 设置一个 RadialGradient
        // RadialGradient 的参数：圆心坐标：(300, 300)；半径：200；颜色：#E91E63 到 #2196F3
        mPaint.setShader(new RadialGradient(300, 300, 100, DataSource.START_COLOR, DataSource.END_COLOR, Shader.TileMode.REPEAT));
    }

    public Practice02RadialGradientView(Context context) {
        super(context);
    }

    public Practice02RadialGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice02RadialGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(300, 300, 200, mPaint);
    }
}
