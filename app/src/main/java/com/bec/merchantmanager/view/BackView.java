package com.bec.merchantmanager.view;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by admin on 2017/8/24.
 */

public class BackView extends android.support.v7.widget.AppCompatImageButton {

    public BackView(Context context) {
        super(context);
    }

    public BackView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BackView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getContext() instanceof AppCompatActivity){
                    ((AppCompatActivity) getContext()).finish();
                }
            }
        });
    }
}
