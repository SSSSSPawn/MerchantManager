package com.iotek.merchantmanager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.iotek.merchantmanager.adapter.UserManagerAdapter;
import com.iotek.merchantmanager.base.SwipListBaseFragment;
import com.iotek.merchantmanager.listener.OnItemClickListener;

import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/8/23.
 */

public class UserOperateManagerFragment extends SwipListBaseFragment implements OnItemClickListener{

    public final static String TAG = "用户";

    private UserManagerAdapter mUserManagerAdapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserManagerAdapter = new UserManagerAdapter();
        mUserManagerAdapter.setOnItemClickListener(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_user;
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return mUserManagerAdapter;
    }

    @Override
    public void OnItemClick(int position) {

    }
}
