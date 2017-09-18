package com.iotek.merchantmanager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iotek.merchantmanager.Presenter.UserManagerPresenter;
import com.iotek.merchantmanager.Utils.AppUtils;
import com.iotek.merchantmanager.Utils.LogUtil;
import com.iotek.merchantmanager.Utils.Preference;
import com.iotek.merchantmanager.adapter.UserManagerAdapter;
import com.iotek.merchantmanager.base.BaseFragment;
import com.iotek.merchantmanager.bean.UserManagerVO;
import com.iotek.merchantmanager.constant.CacheKey;
import com.iotek.merchantmanager.listener.OnItemClickListener;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/8/23.
 */

public class UserOperateManagerFragment extends BaseFragment implements UserManagerPresenter.MvpView,OnItemClickListener {

    public static final String TAG = "用户";

    private UserManagerPresenter mPresenter = new UserManagerPresenter();

    private XRecyclerView mSuperRecyclerView;

    private int times = 0;

    private ArrayList<UserManagerVO> mUserManagerVOs;

    private UserManagerAdapter mAdapter;

    private int currentPage = 1;

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
        mUserManagerVOs = new ArrayList<>();

        mSuperRecyclerView.setLoadingListener(this);
        mAdapter.setOnItemClickListener(this);

        long custID= Preference.getLong(CacheKey.CUST_ID);
        long rootID = Preference.getLong(CacheKey.ROOT_ID);
        String uuID = Preference.getString(CacheKey.UU_ID);
        String mac = Preference.getString(CacheKey.MAC);

        LogUtil.e("custID=" + custID + "\nrootID=" + rootID + "\nuuID=" + uuID + "\nmac=" +mac);

        mPresenter.queryUser(custID,rootID,uuID,mac,currentPage,true);
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {

    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return mAdapter;
    }

    @Override
    public void OnItemClick(int position) {
        AppUtils.showToast("pos = " + position);
    }
}
