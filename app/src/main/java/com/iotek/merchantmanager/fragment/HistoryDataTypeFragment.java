package com.iotek.merchantmanager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iotek.merchantmanager.bean.TabMenus;

import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/10/30.
 */

public class HistoryDataTypeFragment extends BECTabFragment{


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_history_data_list, container, false);
    }

    @Override
    protected TabMenus[] getTabMenu() {
        return new TabMenus[0];
    }
}
