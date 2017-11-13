package com.bec.merchantmanager.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.bec.merchantmanager.Presenter.VipScoreRulePresenter;
import com.bec.merchantmanager.R;
import com.bec.merchantmanager.adapter.VipScoreRuleAdapter;
import com.bec.merchantmanager.base.ListFragment;
import com.bec.merchantmanager.bean.ScoreExchangeQueryVO;
import com.getbase.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import butterknife.Bind;

import static com.bec.merchantmanager.R.id.ll_empty;

/**
 * Created by admin on 2017/11/13.
 */

public class VipScoreRuleFragment extends ListFragment implements VipScoreRulePresenter.MvpView {

    @Bind(ll_empty) LinearLayout mLayout;

    @Bind(R.id.fab_add) FloatingActionButton mFloatingActionButton;

    private VipScoreRuleAdapter mAdapter;

    private VipScoreRulePresenter mPresenter = new VipScoreRulePresenter();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.attachView(this);
        mAdapter = new VipScoreRuleAdapter();
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return mAdapter;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_vip_score_rule;
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
                mPresenter.getVipScoreRuleData(1);
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
    public void updateVipScoreRuleList(ArrayList<ScoreExchangeQueryVO.RowsBean> lists) {
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
}
