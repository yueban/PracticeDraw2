package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice01LinearGradientView extends View {
    //Shader.TileMode 三种模式
    //1.Shader.TileMode.CLAMP
    //2.Shader.TileMode.REPEAT
    //3.Shader.TileMode.MIRROR
    private final Shader mShader =
        new LinearGradient(250, 250, 350, 350, DataSource.START_COLOR, DataSource.END_COLOR, Shader.TileMode.MIRROR);
    private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    {
        // 用 Paint.setShader(shader) 设置一个 LinearGradient
        // LinearGradient 的参数：坐标：(100, 100) 到 (500, 500) ；颜色：#E91E63 到 #2196F3

    }

    public Practice01LinearGradientView(Context context) {
        super(context);
    }

    public Practice01LinearGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice01LinearGradientView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setShader(mShader);
        canvas.drawCircle(300, 300, 200, mPaint);
    }
}
