package com.bec.merchantmanager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.bec.merchantmanager.adapter.VipRankAdapter;
import com.bec.merchantmanager.base.ListFragment;

import com.bec.merchantmanager.R;

/**
 * Created by admin on 2017/11/6.
 */

public class VipLogFragment extends ListFragment {

    private VipRankAdapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAdapter = new VipRankAdapter();
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return mAdapter;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_vip_rank_item;
    }

    @Override
    protected boolean isBindEventBus() {
        return false;
    }
}
