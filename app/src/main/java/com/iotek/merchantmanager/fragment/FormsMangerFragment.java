package com.iotek.merchantmanager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iotek.merchantmanager.Utils.LogUtil;
import com.iotek.merchantmanager.adapter.UserManagerAdapter;
import com.iotek.merchantmanager.base.BaseFragment;

import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/8/23.
 */

public class FormsMangerFragment extends BaseFragment {

    public static final String TAG = "报表";

    UserManagerAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_form,container,false);
        init();
        return v;
    }

    private void init(){
        LogUtil.e("FormsMangerFragment FormsMangerFragment FormsMangerFragment");
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
}
