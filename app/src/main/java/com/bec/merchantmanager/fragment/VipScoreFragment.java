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

public class VipScoreFragment extends BECTabFragment {

    private TabMenus[] TAB_MENUS = {
            new TabMenus("积分规则", new VipScoreRuleFragment()),
            new TabMenus("积分兑换", new VipScoreExchangeFragment()),
            new TabMenus("充次管理", new VipRecharFrament())
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
