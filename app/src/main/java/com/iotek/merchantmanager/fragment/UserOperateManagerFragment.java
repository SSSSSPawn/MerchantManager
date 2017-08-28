package com.iotek.merchantmanager.fragment;

import android.support.v7.widget.RecyclerView;

import com.iotek.merchantmanager.base.SwipListBaseFragment;

import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/8/23.
 */

public class UserOperateManagerFragment extends SwipListBaseFragment {

    public final static String TAG = "用户";


    @Override
    protected int getLayout() {
        return R.layout.fragment_user;
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return null;
    }
}
