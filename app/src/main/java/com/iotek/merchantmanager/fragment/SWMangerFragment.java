package com.iotek.merchantmanager.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iotek.merchantmanager.adapter.UserManagerAdapter;
import com.iotek.merchantmanager.base.BaseFragment;

import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/8/23.
 */

public class SWMangerFragment extends BaseFragment {

    public static final String TAG = "税务";

    UserManagerAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        init();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void init(){
        mAdapter = new UserManagerAdapter();
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return mAdapter;
    }

    @Override
    protected boolean isBindEventBus() {
        return false;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_sw;
    }
}