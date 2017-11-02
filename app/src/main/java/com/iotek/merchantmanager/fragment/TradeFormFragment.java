package com.iotek.merchantmanager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iotek.merchantmanager.bean.TabMenus;

/**
 * Created by admin on 2017/10/11.
 */

public class TradeFormFragment extends BECTabFragment {

    private TabMenus[] TAB_MENUS = {
            new TabMenus("日交易报表", new DayTradeListFragment()),
            new TabMenus("月交易报表", new MonthTradeListFragment()),
            new TabMenus("交接班报表",new SelectShiftReportFragment())
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
