package com.example.infrastructure.data;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;

import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.infrastructure.R;

public class FenceView extends View {

    //定义画笔，用来绘制中心曲线
    private Paint mPaint;
    private Rect mSrcRect, mDestRect;

    public FenceView(Context context) {
        super(context);
    }

    public FenceView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FenceView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        mPaint.setColor(Color.BLUE);
        //绘制方形背景
        RectF rectF = new RectF(0,0,width,height);
        canvas.drawRect(rectF,mPaint);
        mPaint.setColor(Color.WHITE);
        //绘制中心曲线，起点坐标（0,height/2），终点坐标（width,height/2）
        canvas.drawLine(0,height/2,width,height/2,mPaint);

        RectF inRecf = new RectF(75, 60, 909, 420);
        canvas.drawRect(inRecf,mPaint);


        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.FILL);

        Path path = new Path();
        path.moveTo(0, 0);
        path.lineTo(889, 60);
        path.lineTo(789, 420);
        path.lineTo(175, 410);
        path.lineTo(0, 0);

        canvas.drawPath(path, mPaint);

//        mSrcRect = new Rect(75, 60, width, height);
//        mDestRect = new Rect(0, 0, width, height);
//
//        Bitmap bitmap = ((BitmapDrawable) getResources().getDrawable(R.mipmap.ic_wind)).getBitmap();
//        canvas.drawBitmap(bitmap,mSrcRect, mDestRect,mPaint);
    }
}
