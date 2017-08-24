package com.iotek.merchantmanager.bean;

import android.graphics.drawable.Drawable;

import com.iotek.merchantmanager.Utils.AppUtils;
import com.iotek.merchantmanager.base.BaseFragment;

import java.io.Serializable;

/**
 * Created by admin on 2017/8/23.
 */

public class TabMenus implements Serializable{

    public String name;
    public BaseFragment mFragment;
    public Drawable icon;


    public TabMenus(String name,int iconUnSelected,int iconSelected, BaseFragment fragment) {
        this.name = name;
        this.mFragment = fragment;
        this.icon = AppUtils.getSelectListDrawable(iconUnSelected,iconSelected);
    }

}
