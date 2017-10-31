package com.iotek.merchantmanager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iotek.merchantmanager.bean.TabMenus;
import com.iotek.merchantmanager.view.AppBar;

import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/10/30.
 */

public class HistoryDataTypeFragment extends BECTabFragment {

    private AppBar mAppBar;

    private TabMenus[] TAB_MENU;

    private WeekDataListFragment mWeekDataListFragment = new WeekDataListFragment();

    private MonthDataListFragment mMonthDataListFragment = new MonthDataListFragment();


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_history_data_list, container, false);
        mAppBar = (AppBar) view.findViewById(R.id.appBar);
        mAppBar.setTextColor(getResources().getColor(R.color.white));
        return view;
    }

    @Override
    protected TabMenus[] getTabMenu() {
        if (TAB_MENU == null) {
            TAB_MENU = new TabMenus[]{
                    new TabMenus("本周交易数据", mWeekDataListFragment),
                    new TabMenus("本月交易数据", mMonthDataListFragment)
            };
        }
        return TAB_MENU;
    }
}
