package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.hencoder.hencoderpracticedraw2.R;

public class Practice08XfermodeView extends View {
    private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Bitmap mBitmap1;
    private final Bitmap mBitmap2;

    {
        mBitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
        mBitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.batman_logo);
    }

    public Practice08XfermodeView(Context context) {
        super(context);
    }

    public Practice08XfermodeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice08XfermodeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 使用 mPaint.setXfermode() 设置不同的结合绘制效果

        // 别忘了用 canvas.saveLayer() 开启 off-screen buffer

        int savedId = canvas.saveLayer(null, null, Canvas.ALL_SAVE_FLAG);
        canvas.drawBitmap(mBitmap1, 0, 0, mPaint);
        // 第一个：PorterDuff.Mode.SRC
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        canvas.drawBitmap(mBitmap2, 0, 0, mPaint);
        mPaint.setXfermode(null);

        canvas.drawBitmap(mBitmap1, mBitmap1.getWidth() + 100, 0, mPaint);
        // 第二个：PorterDuff.Mode.DST_IN
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        canvas.drawBitmap(mBitmap2, mBitmap1.getWidth() + 100, 0, mPaint);
        mPaint.setXfermode(null);

        canvas.drawBitmap(mBitmap1, 0, mBitmap1.getHeight() + 20, mPaint);
        // 第三个：PorterDuff.Mode.DST_OUT
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        canvas.drawBitmap(mBitmap2, 0, mBitmap1.getHeight() + 20, mPaint);
        mPaint.setXfermode(null);

        // 用完之后使用 canvas.restore() 恢复 off-screen buffer
        canvas.restoreToCount(savedId);
    }
}
