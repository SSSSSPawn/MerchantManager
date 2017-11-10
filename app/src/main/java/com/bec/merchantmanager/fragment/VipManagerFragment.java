package com.bec.merchantmanager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bec.merchantmanager.bean.TabMenus;

/**
 * Created by admin on 2017/11/6.
 */

public class VipManagerFragment extends BECTabFragment {

    private TabMenus[] TAB_MENUS ={
            new TabMenus("会员等级管理",new VipRankFragment()),
            new TabMenus("会员资料管理",new VipDatumFragment()),
            new TabMenus("会员日志管理",new VipLogFragment())
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected TabMenus[] getTabMenu() {
        return TAB_MENUS;
    }
}
