package com.iotek.merchantmanager.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.iotek.merchantmanager.Presenter.FormsMangerPresenter;
import com.iotek.merchantmanager.Utils.AppUtils;
import com.iotek.merchantmanager.adapter.DayTradeFormAdapter;
import com.iotek.merchantmanager.base.ListFragment;
import com.iotek.merchantmanager.bean.DayTradeFormVO;
import com.iotek.merchantmanager.listener.OnItemClickListener;

import java.util.ArrayList;

import butterknife.Bind;
import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/10/11.
 */

public class DayTradeListFragment extends ListFragment implements FormsMangerPresenter.MvpView, OnItemClickListener {

    @Bind(R.id.ll_empty) LinearLayout ll_empty;

    @Bind(R.id.ll_recyclerView) LinearLayout ll_recyclerView;

    private DayTradeFormAdapter mAdapter;

    private FormsMangerPresenter mPresenter = new FormsMangerPresenter();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter.attachView(this);

        mAdapter = new DayTradeFormAdapter();

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

    @Override
    public void onRefresh() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mPresenter.getDayTradeList(1);
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
    public void updateUserList(ArrayList<DayTradeFormVO.RowsBean> lists) {
        if (lists.size() == 0) {
            ll_recyclerView.setVisibility(View.GONE);
            ll_empty.setVisibility(View.VISIBLE);
        }
        mAdapter.setDataList(lists);
    }

    @Override
    public void stopLoadMore() {
        mSuperRecyclerView.setNoMore(true);
    }

    @Override
    public void OnItemClick(int position) {
        AppUtils.showToast("position position position -->> " + position);
    }
}
