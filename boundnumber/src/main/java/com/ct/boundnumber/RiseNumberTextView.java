package com.ct.boundnumber;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by ct on 2015/8/19.
 */
public class RiseNumberTextView extends TextView implements RiseNumberBase {

    private static final int STOPPED = 0;

    private static final int RUNNING = 1;

    private int mPlayingState = STOPPED;

    private float number;

    private float fromNumber;

    private long duration = 1000;
    /**
     * 1.int 2.float
     */
    private int numberType = 2;

    private boolean flags = true;

    private EndListener mEndListener = null;

    public RiseNumberTextView(Context context) {
        super(context);
    }

    public RiseNumberTextView(Context context, AttributeSet attr) {
        super(context, attr);
    }

    public RiseNumberTextView(Context context, AttributeSet attr, int defStyle) {
        super(context, attr, defStyle);
    }

    public boolean isRunning() {
        return (mPlayingState == RUNNING);
    }

    private void runFloat() {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(fromNumber, number);
        valueAnimator.setDuration(duration);

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (flags) {
                    setText(Utils.format(",##0.00").format(Double.parseDouble(valueAnimator.getAnimatedValue().toString())));
                    if (valueAnimator.getAnimatedValue().toString().equalsIgnoreCase(String.valueOf(number))) {
                        setText(Utils.format(",##0.00").format(number));
                    }
                } else {
                    setText(Utils.format("#.00").format(Double.parseDouble(valueAnimator.getAnimatedValue().toString())));
                    if (valueAnimator.getAnimatedValue().toString().equalsIgnoreCase(String.valueOf(number))) {
                        setText(Utils.format("#.00").format(number));
                    }
                }
                if (valueAnimator.getAnimatedFraction() >= 1) {
                    mPlayingState = STOPPED;
                    if (mEndListener != null)
                        mEndListener.onEndFinish();
                }
            }
        });
        valueAnimator.start();
    }

    private void runInt() {
        ValueAnimator valueAnimator = ValueAnimator.ofInt((int) fromNumber, (int) number);
        valueAnimator.setDuration(duration);

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (flags) {
                    setText(Utils.format("#,###").format(Integer.parseInt(valueAnimator.getAnimatedValue().toString())));
                } else {
                    setText(valueAnimator.getAnimatedValue().toString());
                }
                if (valueAnimator.getAnimatedFraction() >= 1) {
                    mPlayingState = STOPPED;
                    if (mEndListener != null)
                        mEndListener.onEndFinish();
                }
            }
        });
        valueAnimator.start();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override
    public void start() {

        if (!isRunning()) {
            mPlayingState = RUNNING;
            if (numberType == 1)
                runInt();
            else
                runFloat();
        }
    }

    @Override
    public RiseNumberTextView withNumber(float number, boolean flag) {

        this.number = number;
        this.flags = flag;
        numberType = 2;
        fromNumber = 0;

        return this;
    }

    @Override
    public RiseNumberTextView withNumber(float number) {
        this.number = number;
        numberType = 2;
        fromNumber = 0;

        return this;
    }

    @Override
    public RiseNumberTextView withNumber(int number, boolean flag) {
        this.number = number;
        this.flags = flag;
        numberType = 1;
        fromNumber = 0;

        return this;
    }

    @Override
    public RiseNumberTextView withNumber(int number) {
        this.number = number;
        numberType = 1;
        fromNumber = 0;

        return this;
    }

    @Override
    public RiseNumberTextView setDuration(long duration) {
        this.duration = duration;
        return this;
    }

    @Override
    public void setOnEnd(EndListener callback) {
        mEndListener = callback;
    }

    public interface EndListener {
        void onEndFinish();
    }
}