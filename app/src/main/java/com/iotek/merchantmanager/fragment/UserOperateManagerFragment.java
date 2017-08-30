package com.iotek.merchantmanager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.iotek.merchantmanager.Presenter.UserManagerPresenter;
import com.iotek.merchantmanager.Utils.AppUtils;
import com.iotek.merchantmanager.adapter.SwipeListAdapter;
import com.iotek.merchantmanager.adapter.UserManagerAdapter;
import com.iotek.merchantmanager.base.SwipListBaseFragment;
import com.iotek.merchantmanager.bean.UserManagerVO;
import com.iotek.merchantmanager.listener.OnConfirmListener;
import com.iotek.merchantmanager.listener.OnItemClickListener;

import java.util.ArrayList;

import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/8/23.
 */

public class UserOperateManagerFragment extends SwipListBaseFragment implements UserManagerPresenter.MvpView,OnItemClickListener {

    public final static String TAG = "用户";

    private UserManagerPresenter mPresenter = new UserManagerPresenter();
    private UserManagerAdapter mUserManagerAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.attachView(this);
        mUserManagerAdapter = new UserManagerAdapter();

        mUserManagerAdapter.setDataList(getData());

        mUserManagerAdapter.setOnSwipeViewClickListener(new OnConfirmListener() {
            @Override
            public void onConfirm(String txt) {
                AppUtils.showToast("---TEST---");
            }
        });
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    protected SwipeListAdapter getAdapter() {
        return mUserManagerAdapter;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_user;
    }

    @Override
    public void OnItemClick(int position) {
        AppUtils.showToast("data test");
    }

    @Override
    protected boolean hasDivider() {
        return false;
    }

    @Override
    public void onLoadMore(int overallItemsCount, int itemsBeforeMore, int maxLastVisiblePosition) {

    }

    @Override
    public void onRefresh() {

    }

    public ArrayList<UserManagerVO> getData(){

        ArrayList<UserManagerVO> vos = new ArrayList<>();
        for (int i = 0 ;i <15;i++){
            vos.add(new UserManagerVO("12" + i,"你还","FF","Hello","456","HI","YYY","TEST"));
        }
        return vos;
    }
}
