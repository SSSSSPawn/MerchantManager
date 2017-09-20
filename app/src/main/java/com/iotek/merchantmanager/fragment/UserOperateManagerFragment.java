package com.iotek.merchantmanager.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iotek.merchantmanager.Presenter.UserManagerPresenter;
import com.iotek.merchantmanager.activity.UserManagerDetailActivity;
import com.iotek.merchantmanager.adapter.UserManagerAdapter;
import com.iotek.merchantmanager.base.BaseFragment;
import com.iotek.merchantmanager.bean.UserManagerDetailVO;
import com.iotek.merchantmanager.constant.Intentkey;
import com.iotek.merchantmanager.listener.OnItemClickListener;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/8/23.
 */

public class UserOperateManagerFragment extends BaseFragment implements UserManagerPresenter.MvpView, OnItemClickListener {

    public static final String TAG = "用户";

    private UserManagerPresenter mPresenter = new UserManagerPresenter();

    private XRecyclerView mSuperRecyclerView;

    private UserManagerAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

        mPresenter.attachView(this);

        mSuperRecyclerView = (XRecyclerView) view.findViewById(R.id.super_recycler_view);

        mAdapter = new UserManagerAdapter();

        mSuperRecyclerView.setLoadingListener(this);
        mAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onRefresh() {
        mPresenter.getFirstData(1);
        mSuperRecyclerView.refreshComplete();
    }

    @Override
    public void onLoadMore() {
        mPresenter.getNextData();
        mSuperRecyclerView.loadMoreComplete();
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
    public void OnItemClick(int position) {
        //launch(UserManagerDetailActivity.class);
        Intent intent = new Intent(getActivity(), UserManagerDetailActivity.class);
        intent.putExtra(Intentkey.USER_DETAIL,mAdapter.getDataList().get(position));
        startActivity(intent);
    }

    @Override
    public void updateUserList(ArrayList<UserManagerDetailVO.RowsBean> lists) {
        mAdapter.setDataList(lists);
    }

    @Override
    public void stopLoadMore() {
        mSuperRecyclerView.setNoMore(true);
    }
}
