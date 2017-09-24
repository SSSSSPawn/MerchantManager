package com.iotek.merchantmanager.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gordonwong.materialsheetfab.MaterialSheetFab;
import com.iotek.merchantmanager.Presenter.UserManagerPresenter;
import com.iotek.merchantmanager.Utils.AppUtils;
import com.iotek.merchantmanager.Utils.Preference;
import com.iotek.merchantmanager.activity.UserManagerDetailActivity;
import com.iotek.merchantmanager.adapter.UserManagerAdapter;
import com.iotek.merchantmanager.base.BaseFragment;
import com.iotek.merchantmanager.bean.UserManagerDetailVO;
import com.iotek.merchantmanager.bean.UserParamsVO;
import com.iotek.merchantmanager.constant.CacheKey;
import com.iotek.merchantmanager.constant.Intentkey;
import com.iotek.merchantmanager.listener.OnConfirmListener;
import com.iotek.merchantmanager.listener.OnItemClickListener;
import com.iotek.merchantmanager.view.FloatingButton;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/8/23.
 */

public class UserOperateManagerFragment extends BaseFragment implements UserManagerPresenter.MvpView, OnItemClickListener, View.OnClickListener {

    public static final String TAG = "用户";

    private UserManagerPresenter mPresenter = new UserManagerPresenter();

    private XRecyclerView mSuperRecyclerView;

    private UserManagerAdapter mAdapter;

    private MaterialSheetFab materialSheetFab;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        initView(view);
        initFab(view);
        return view;
    }

    private void initView(View view) {

        final long custID = Preference.getLong(CacheKey.CUST_ID);
        final long rootID = Preference.getLong(CacheKey.ROOT_ID);
        final String uuID = Preference.getString(CacheKey.UU_ID);
        final String mac = Preference.getString(CacheKey.MAC);

        mPresenter.attachView(this);

        mSuperRecyclerView = (XRecyclerView) view.findViewById(R.id.super_recycler_view);

        mAdapter = new UserManagerAdapter();

        mSuperRecyclerView.setLoadingListener(this);
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


    private void initFab(View view) {

        FloatingButton fab = (FloatingButton) view.findViewById(R.id.fab);
        View sheetView = view.findViewById(R.id.fab_sheet);
        View overlay = view.findViewById(R.id.overlay);
        int sheetColor = getResources().getColor(R.color.white);
        int fabColor = getResources().getColor(R.color.white);

        materialSheetFab = new MaterialSheetFab<>(fab, sheetView, overlay, sheetColor, fabColor);

        view.findViewById(R.id.fab_sheet_item_add_user).setOnClickListener(this);
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
    public void showSuccess(String msg) {
        AppUtils.showToast(msg);
    }

    @Override
    public void showError(String msg) {
        AppUtils.showToast(msg);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_sheet_item_add_user:
                materialSheetFab.hideSheet();
                break;
        }
    }
}
