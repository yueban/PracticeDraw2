package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.hencoder.hencoderpracticedraw2.R;

public class Practice14MaskFilterView extends View {
    private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Bitmap mBitmap;

    {
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.what_the_fuck);
    }

    public Practice14MaskFilterView(Context context) {
        super(context);
    }

    public Practice14MaskFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice14MaskFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 用 Paint.setMaskFilter 来设置不同的 BlurMaskFilter

        // 第一个：NORMAL
        mPaint.setMaskFilter(new BlurMaskFilter(50, BlurMaskFilter.Blur.NORMAL));
        canvas.drawBitmap(mBitmap, 100, 50, mPaint);

        // 第二个：INNER
        mPaint.setMaskFilter(new BlurMaskFilter(100, BlurMaskFilter.Blur.INNER));
        canvas.drawBitmap(mBitmap, mBitmap.getWidth() + 200, 50, mPaint);

        // 第三个：OUTER
        mPaint.setMaskFilter(new BlurMaskFilter(100, BlurMaskFilter.Blur.OUTER));
        canvas.drawBitmap(mBitmap, 100, mBitmap.getHeight() + 100, mPaint);

        // 第四个：SOLID
        mPaint.setMaskFilter(new BlurMaskFilter(100, BlurMaskFilter.Blur.SOLID));
        //mPaint.setMaskFilter(new EmbossMaskFilter(new float[] { 15, 20, 30 }, 0.5f, 5, 50));
        canvas.drawBitmap(mBitmap, mBitmap.getWidth() + 200, mBitmap.getHeight() + 100, mPaint);

        mPaint.setMaskFilter(null);
    }
}
