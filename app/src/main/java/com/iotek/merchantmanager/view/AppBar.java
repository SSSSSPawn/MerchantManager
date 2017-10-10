package com.iotek.merchantmanager.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.TintTypedArray;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/8/24.
 */

public class AppBar extends Toolbar {

    private TextView mTittleView;

    private CharSequence mTitle;


    public AppBar(Context context) {
        this(context, null);
    }

    public AppBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AppBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TintTypedArray a = TintTypedArray.obtainStyledAttributes(getContext(), attrs,
                android.support.v7.appcompat.R.styleable.MenuItem, defStyleAttr, 0);

        mTitle = a.getText(android.support.v7.appcompat.R.styleable.MenuItem_android_title);

        initTitle();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() == 0){
            addView(LayoutInflater.from(getContext()).inflate(R.layout.layout_title,this,false));
        }

        View backView = findViewById(R.id.back);
        if (backView!= null){
            backView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getContext() instanceof AppCompatActivity){
                        ((AppCompatActivity) getContext()).finish();
                    }
                }
            });
        }

        mTittleView = (TextView) findViewById(R.id.tv_title);
        if (mTittleView != null){
            mTittleView.setText(mTitle);
            mTittleView.invalidate();
        }

    }

    private void initTitle() {
        setContentInsetsAbsolute(0,0);
        setTitleTextAppearance(getContext(), R.style.Text_AppBar);
    }

    public void setTitle(String title){
        if (mTittleView !=null){
            mTittleView.setText(title);
        }
    }

    public void setTextColor(int color){
        if (mTittleView != null){
            mTittleView.setTextColor(color);
        }
    }
}
