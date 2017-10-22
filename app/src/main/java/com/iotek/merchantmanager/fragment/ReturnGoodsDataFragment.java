package com.iotek.merchantmanager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.iotek.merchantmanager.Presenter.SalesDataPresenter;
import com.iotek.merchantmanager.adapter.DataDetailAdapter;
import com.iotek.merchantmanager.base.ListFragment;

import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/10/21.
 */

public class ReturnGoodsDataFragment extends ListFragment {

    private SalesDataPresenter mPresenter = new SalesDataPresenter();
    private DataDetailAdapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAdapter = new DataDetailAdapter();
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return mAdapter;
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
