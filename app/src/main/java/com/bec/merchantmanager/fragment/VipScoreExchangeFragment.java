package com.bec.merchantmanager.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.bec.merchantmanager.Presenter.VipScoreExchangePresenter;
import com.bec.merchantmanager.R;
import com.bec.merchantmanager.activity.VipExchangeDetailActivity;
import com.bec.merchantmanager.adapter.VipScoreExchangeAdapter;
import com.bec.merchantmanager.base.ListFragment;
import com.bec.merchantmanager.bean.ScoreUseQueryVO;
import com.bec.merchantmanager.constant.Intentkey;
import com.bec.merchantmanager.listener.OnItemClickListener;

import java.util.ArrayList;

import butterknife.Bind;

import static com.bec.merchantmanager.R.id.ll_empty;

/**
 * Created by admin on 2017/11/13.
 */

public class VipScoreExchangeFragment extends ListFragment implements VipScoreExchangePresenter.MvpView, OnItemClickListener {

    private VipScoreExchangeAdapter mAdapter;

    private VipScoreExchangePresenter mPresenter = new VipScoreExchangePresenter();

    @Bind(ll_empty) LinearLayout mLayout;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.attachView(this);
        mAdapter = new VipScoreExchangeAdapter();
        mAdapter.setOnItemClickListener(this);
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return mAdapter;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_vip_exchange;
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
                mPresenter.getVipExchangeData(1);
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
    public void updateVipExchangeList(ArrayList<ScoreUseQueryVO.RowsBean> lists) {
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
        Intent intent = new Intent(getActivity(), VipExchangeDetailActivity.class);
        intent.putExtra(Intentkey.VIP_SCORE_EXCHANGE_DETAIL, mAdapter.getDataList().get(position));
        launch(intent);
    }
}
