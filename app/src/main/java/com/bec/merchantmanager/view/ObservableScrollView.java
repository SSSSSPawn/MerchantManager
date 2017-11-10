package com.bec.merchantmanager.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

import com.bec.merchantmanager.listener.OnScrollListener;


/**
 * Created by admin on 2017/10/18.
 */
public class ObservableScrollView extends ScrollView {

    private OnScrollListener mOnScrollListener;

    public ObservableScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public ObservableScrollView(Context context) {
        super(context);
    }

    public ObservableScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setOnScrollListener(OnScrollListener listener) {
        mOnScrollListener = listener;
    }

    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (null != mOnScrollListener) {
            mOnScrollListener.onScrollChanged(l, t, oldl, oldt);
        }

        if (oldt - t == 0 || t == 0) {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
    }
}