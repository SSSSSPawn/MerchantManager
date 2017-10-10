package com.iotek.merchantmanager.bean;

import android.graphics.drawable.Drawable;

import com.iotek.merchantmanager.Utils.AppUtils;
import com.iotek.merchantmanager.base.BECFragment;

import java.io.Serializable;

/**
 * Created by admin on 2017/8/23.
 */

public class TabMenus implements Serializable{

    public String name;
    public BECFragment mFragment;
    public Drawable icon;


    public TabMenus(String name,int iconUnSelected,int iconSelected, BECFragment fragment) {
        this.name = name;
        this.mFragment = fragment;
        this.icon = AppUtils.getSelectListDrawable(iconUnSelected,iconSelected);
    }

    public TabMenus(String name, BECFragment fragment) {
        this.name = name;
        this.mFragment = fragment;
    }

}
