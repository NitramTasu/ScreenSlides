package br.martin.screenslides;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;


/**
 * Created by Martin on 18/11/2016.
 */

public class Index extends View  implements PageIndex {

    private ViewPager.OnPageChangeListener mListener;
    private ViewPager mViewPager;
    private int mCurrentPage = 0;
    private int countPages;
    private float mPageOffset;
    private boolean scrolling;

    Paint circlePaint =  new Paint();
    Paint circlePaintAlpha =  new Paint();

    public Index(Context context) {
        super(context);
    }

    public Index(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.vCirclePageIndexStyle);
    }

    public Index(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        circlePaint.setColor(ContextCompat.getColor(this.getContext(), R.color.white));
        circlePaintAlpha.setColor(ContextCompat.getColor(this.getContext(), R.color.gray));

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CirclePageIndicator, defStyle, 0);

        //circlePaint.setColor(a.getColor(R.styleable.));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        circlePaintAlpha.setAlpha(50);

        for(int i = 0 ; i < countPages; i ++){
            canvas.drawCircle(50 + i * 100, 50, 25, circlePaintAlpha);
        }

        canvas.drawCircle(50 + (mCurrentPage + mPageOffset) * 100, 50, 25, circlePaint);
        //canvas.drawCircle(50 + mCurrentPage * 100, 50, 25, circlePaint);
        //canvas.drawCircle(50 + mCurrentPage * 100, 50, 25, circlePaint);
    }

    public void setViewPager(ViewPager mPager) {
        this.mViewPager = mPager;
        this.mViewPager.addOnPageChangeListener(this);
        mListener = this;
        countPages = mViewPager.getAdapter().getCount();

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        mCurrentPage = position;
        mPageOffset = positionOffset;

        if(mPageOffset!=0){
            scrolling = true;
        }else{
            scrolling = false;
        }
        Log.i("Log", positionOffset+"");
        invalidate();
        if(mListener != null){
            //mListener.onPageScrolled(position, positionOffset, positionOffsetPixels);
        }
    }

    @Override
    public void onPageSelected(int position) {
        mCurrentPage = position;
        scrolling = false;
        Log.i("Log", position+"");
        if(mListener!= null){
            //mListener.onPageSelected(position);
        }
        invalidate();
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        //mListener.onPageScrollStateChanged(state);
    }
}

