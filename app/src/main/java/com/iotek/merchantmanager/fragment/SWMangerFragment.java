package com.iotek.merchantmanager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iotek.merchantmanager.bean.TabMenus;

import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/8/23.
 */

public class SWMangerFragment extends BECTabFragment {

    public static final String TAG = "税务";

    private TabMenus[] TAB_MENU = {
            new TabMenus("发票数据管理", new SelectTaxInvDataFragment()),
    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sw, container, false);
    }


    @Override
    protected TabMenus[] getTabMenu() {
        return TAB_MENU;
    }
}