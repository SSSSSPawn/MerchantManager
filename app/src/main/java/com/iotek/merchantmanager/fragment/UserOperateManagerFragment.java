package com.iotek.merchantmanager.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.iotek.merchantmanager.Presenter.UserManagerPresenter;
import com.iotek.merchantmanager.Utils.AppUtils;
import com.iotek.merchantmanager.Utils.Preference;
import com.iotek.merchantmanager.activity.AddUserActivity;
import com.iotek.merchantmanager.activity.UserManagerDetailActivity;
import com.iotek.merchantmanager.adapter.UserManagerAdapter;
import com.iotek.merchantmanager.base.BaseFragment;
import com.iotek.merchantmanager.bean.UserManagerDetailVO;
import com.iotek.merchantmanager.bean.UserParamsVO;
import com.iotek.merchantmanager.constant.CacheKey;
import com.iotek.merchantmanager.constant.Intentkey;
import com.iotek.merchantmanager.listener.OnConfirmListener;
import com.iotek.merchantmanager.listener.OnItemClickListener;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.OnClick;
import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/8/23.
 */

public class UserOperateManagerFragment extends BaseFragment implements UserManagerPresenter.MvpView, OnItemClickListener {

    public static final String TAG = "用户";

    @Bind(R.id.fab_add_user)
    FloatingActionButton mFabAddUser;

    private UserManagerPresenter mPresenter = new UserManagerPresenter();

    private UserManagerAdapter mAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        initView();
        return super.onCreateView(inflater, container, savedInstanceState);
    }


    private void initView() {

        final long custID = Preference.getLong(CacheKey.CUST_ID);
        final long rootID = Preference.getLong(CacheKey.ROOT_ID);
        final String uuID = Preference.getString(CacheKey.UU_ID);
        final String mac = Preference.getString(CacheKey.MAC);

        mPresenter.attachView(this);

        mAdapter = new UserManagerAdapter();

        mAdapter.setOnItemClickListener(this);

        mAdapter.setOnConfirmListener(new OnConfirmListener() {
            @Override
            public void onConfirmDel(long id) {
                mPresenter.userDelete(new UserParamsVO(custID, rootID, uuID, mac, id));
            }

            @Override
            public void onConfirmReset(long id, long roleId) {
                mPresenter.userResetPassword(new UserParamsVO(custID, rootID, uuID, mac, id, roleId));
            }
        });
    }

    @Override
    public void onRefresh() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mPresenter.getFirstData(1);
                mSuperRecyclerView.refreshComplete();
            }
        }, 1000);
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
    protected int getLayoutId() {
        return R.layout.fragment_user;
    }

    @Override
    public void OnItemClick(int position) {
        Intent intent = new Intent(getActivity(), UserManagerDetailActivity.class);
        intent.putExtra(Intentkey.USER_DETAIL, mAdapter.getDataList().get(position));
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

    @Override
    public void showMsg(String msg) {
        AppUtils.showToast(msg);
    }

    @OnClick(R.id.fab_add_user)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fab_add_user:
                launch(AddUserActivity.class);
                break;
        }
    }
}
