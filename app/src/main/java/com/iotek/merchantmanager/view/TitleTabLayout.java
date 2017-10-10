package com.iotek.merchantmanager.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by admin on 2017/10/10.
 */

public class TitleTabLayout extends LinearLayout{

    public TitleTabLayout(Context context) {
        this(context,null);
    }

    public TitleTabLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TitleTabLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
