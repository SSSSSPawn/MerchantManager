package com.bec.merchantmanager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.bec.merchantmanager.R;
import com.bec.merchantmanager.adapter.VipScoreRuleAdapter;
import com.bec.merchantmanager.base.ListFragment;

/**
 * Created by admin on 2017/11/13.
 */

public class VipScoreRuleFragment extends ListFragment {

    private VipScoreRuleAdapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAdapter = new VipScoreRuleAdapter();
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return mAdapter;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_vip_score_rule;
    }

    @Override
    protected boolean isBindEventBus() {
        return false;
    }
}
