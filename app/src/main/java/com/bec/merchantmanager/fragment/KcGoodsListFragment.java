package com.bec.merchantmanager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.bec.merchantmanager.adapter.UserManagerAdapter;
import com.bec.merchantmanager.base.ListFragment;

import com.bec.merchantmanager.R;

/**
 * Created by admin on 2017/10/11.
 */

public class KcGoodsListFragment extends ListFragment {

    UserManagerAdapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new UserManagerAdapter();
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return mAdapter;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_form_list;
    }

    @Override
    protected boolean isBindEventBus() {
        return false;
    }
}
