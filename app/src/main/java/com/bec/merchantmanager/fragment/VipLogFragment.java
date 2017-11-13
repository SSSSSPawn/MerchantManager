package com.bec.merchantmanager.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.bec.merchantmanager.Presenter.VipLogPresenter;
import com.bec.merchantmanager.R;
import com.bec.merchantmanager.activity.VipLogDetailActivity;
import com.bec.merchantmanager.adapter.VipLogAdapter;
import com.bec.merchantmanager.base.ListFragment;
import com.bec.merchantmanager.bean.VipLogVO;
import com.bec.merchantmanager.constant.Intentkey;
import com.bec.merchantmanager.listener.OnItemClickListener;

import java.util.ArrayList;

import butterknife.Bind;

import static com.bec.merchantmanager.R.id.ll_empty;

/**
 * Created by admin on 2017/11/6.
 */

public class VipLogFragment extends ListFragment implements VipLogPresenter.MvpView, OnItemClickListener {

    @Bind(ll_empty) LinearLayout mLayout;

    private VipLogAdapter mAdapter;

    private VipLogPresenter mPresenter = new VipLogPresenter();

    private ArrayList<VipLogVO.RowsBean> mList = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.attachView(this);
        mAdapter = new VipLogAdapter();
        mAdapter.setOnItemClickListener(this);
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return mAdapter;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_vip_log;
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
                mPresenter.getVipLogData(1);
                mSuperRecyclerView.refreshComplete();
            }
        }, 1000);
    }

    @Override
    public void onLoadMore() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mPresenter.getNextData();
                mSuperRecyclerView.loadMoreComplete();
            }
        }, 1000);
    }

    @Override
    public void updateVipLogList(ArrayList<VipLogVO.RowsBean> lists) {
        mList = lists;
        if (lists.size() == 0) {
            mSuperRecyclerView.setVisibility(View.GONE);
            mLayout.setVisibility(View.VISIBLE);
        }
        mAdapter.setDataList(lists);
    }

    @Override
    public void stopLoadMore() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mSuperRecyclerView.setNoMore(true);
            }
        }, 1000);
    }

    @Override
    public void emptyData() {
        mSuperRecyclerView.setVisibility(View.GONE);
        mLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void OnItemClick(int position) {
        Intent intent = new Intent(getActivity(), VipLogDetailActivity.class);
        intent.putExtra(Intentkey.VIP_LOG_DETAIL, mAdapter.getDataList().get(position));
        launch(intent);
    }
}
