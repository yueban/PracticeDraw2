package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.hencoder.hencoderpracticedraw2.R;

public class Practice06LightingColorFilterView extends View {
    private static final LightingColorFilter RED_DEBUFF_FILTER = new LightingColorFilter(0x00ffff, 0);
    private static final LightingColorFilter GREEN_BUFF_FILTER = new LightingColorFilter(0xffffff, 0x004000);
    private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Bitmap mBitmap;

    {
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
    }

    public Practice06LightingColorFilterView(Context context) {
        super(context);
    }

    public Practice06LightingColorFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice06LightingColorFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 使用 Paint.setColorFilter() 来设置 LightingColorFilter

        // 第一个 LightingColorFilter：去掉红色部分
        mPaint.setColorFilter(RED_DEBUFF_FILTER);
        canvas.drawBitmap(mBitmap, 0, 0, mPaint);

        // 第二个 LightingColorFilter：增强绿色部分
        mPaint.setColorFilter(GREEN_BUFF_FILTER);
        canvas.drawBitmap(mBitmap, mBitmap.getWidth() + 100, 0, mPaint);
    }
}
