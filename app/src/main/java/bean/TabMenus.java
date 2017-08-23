package bean;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

import Utils.AppUtils;
import base.BaseFragment;

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
