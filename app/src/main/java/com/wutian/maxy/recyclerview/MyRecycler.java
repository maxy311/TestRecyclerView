package com.wutian.maxy.recyclerview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class MyRecycler extends RecyclerView {
    public MyRecycler(Context context) {
        super(context);
    }

    public MyRecycler(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRecycler(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        int action = event.getAction();
        if (action == MotionEvent.ACTION_DOWN) {
                return super.onInterceptTouchEvent(event);
        } else {
            return true;
        }
    }
}
