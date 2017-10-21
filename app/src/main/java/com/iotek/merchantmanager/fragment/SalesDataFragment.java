package com.iotek.merchantmanager.fragment;

import android.support.v7.widget.RecyclerView;

import com.iotek.merchantmanager.base.ListFragment;

import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/10/21.
 */

public class SalesDataFragment extends ListFragment {

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_sales_data_list;
    }

    @Override
    protected boolean isBindEventBus() {
        return false;
    }
}
