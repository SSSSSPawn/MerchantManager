package com.bec.merchantmanager.view;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.bec.merchantmanager.listener.OnTabClickListener;

import com.bec.merchantmanager.R;

/**
 * Created by admin on 2017/10/10.
 */

public class TitleTabLayout extends LinearLayout {

    private RadioButton tab_left;

    private RadioButton tab_right;

    private RadioButton tab_middle;

    public TitleTabLayout(Context context) {
        this(context, null);
    }

    public TitleTabLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TitleTabLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOrientation(LinearLayout.HORIZONTAL);
        initView();
    }

    private void initView() {
        View view = LayoutInflater.from(getContext()).inflate(getLayout() == 0 ? R.layout.layout_tab_title : getLayout(), null);

        tab_left = (RadioButton) view.findViewById(R.id.tab_left);
        tab_middle = (RadioButton) view.findViewById(R.id.tab_middle);
        tab_right = (RadioButton) view.findViewById(R.id.tab_right);

        tab_middle.setVisibility(GONE);

        addView(view, new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        if (isInEditMode()) {
            addLeftTab("tab1", null);
            addMiddleTab("tab2", null);
            addRightTab("tab3", null);
        }
    }

    public void addLeftTab(String name, final OnTabClickListener listener) {
        tab_left.setText(name);
        tab_left.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked && listener != null) {
                    listener.onTabClick();
                }
            }
        });
    }

    public void addMiddleTab(String name, final OnTabClickListener listener) {
        tab_middle.setText(name);
        tab_middle.setVisibility(VISIBLE);
        tab_middle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked && listener != null) {
                    listener.onTabClick();
                }
            }
        });
    }

    public void addRightTab(String name, final OnTabClickListener listener) {
        tab_right.setText(name);
        tab_right.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked && listener != null) {
                    listener.onTabClick();
                }
            }
        });
    }


    @LayoutRes
    protected int getLayout() {
        return 0;
    }
}
