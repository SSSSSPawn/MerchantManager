package com.iotek.merchantmanager.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.LinearLayout;

import com.iotek.merchantmanager.Presenter.TradeFormDetailPresenter;
import com.iotek.merchantmanager.Utils.DateUtils;
import com.iotek.merchantmanager.Utils.Preference;
import com.iotek.merchantmanager.adapter.TradeFormDetailAdapter;
import com.iotek.merchantmanager.base.BaseActivity;
import com.iotek.merchantmanager.bean.TradeFormDetailVO;
import com.iotek.merchantmanager.bean.params.TradeFormDetailParamsVO;
import com.iotek.merchantmanager.constant.CacheKey;
import com.iotek.merchantmanager.constant.Intentkey;
import com.iotek.merchantmanager.view.AppBar;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

import butterknife.Bind;
import iotek.com.merchantmanager.R;

import static iotek.com.merchantmanager.R.id.ll_empty;
import static iotek.com.merchantmanager.R.id.super_recycler_view;

/**
 * Created by admin on 2017/10/17.
 */

public class TradeFormDetailActivity extends BaseActivity implements TradeFormDetailPresenter.MvpView,XRecyclerView.LoadingListener{

    @Bind(R.id.appBar) AppBar mAppBar;

    @Bind(super_recycler_view) XRecyclerView mSuperRecyclerView;

    @Bind(ll_empty) LinearLayout mLlEmpty;

    private TradeFormDetailAdapter mAdapter;

    private TradeFormDetailPresenter mPresenter = new TradeFormDetailPresenter();

    private TradeFormDetailParamsVO paramsVO;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter.attachView(this);

        long dayTime = getIntent().getExtras().getLong(Intentkey.TRADE_FORM_DETAIL_DAY);
        String day = DateUtils.dateFormatDay(dayTime);

        mAppBar.setTitle("报表详情");
        mAppBar.setTextColor(getResources().getColor(R.color.white));

        mAdapter = new TradeFormDetailAdapter();

        long custID = Preference.getLong(CacheKey.CUST_ID);
        long rootID = Preference.getLong(CacheKey.ROOT_ID);
        String uuID = Preference.getString(CacheKey.UU_ID);
        String mac = Preference.getString(CacheKey.MAC);

        paramsVO = new TradeFormDetailParamsVO(custID,rootID,uuID,mac,10,1,day);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mSuperRecyclerView.setLayoutManager(layoutManager);

        mSuperRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mSuperRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.LineSpinFadeLoader);
        mSuperRecyclerView.setArrowImageView(R.drawable.iconfont_downgrey);

        mSuperRecyclerView.setLoadingListener(this);
        mSuperRecyclerView.setAdapter(mAdapter);
        mSuperRecyclerView.refresh();

    }

    @Override
    protected boolean isBindEventBus() {
        return false;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_trade_form_detail;
    }

    @Override
    public void updateUserList(ArrayList<TradeFormDetailVO.RowsBean> lists) {
        if (lists.size() == 0) {
            mSuperRecyclerView.setVisibility(View.GONE);
            mLlEmpty.setVisibility(View.VISIBLE);
        }
        mAdapter.setDataList(lists);
    }

    @Override
    public void onRefresh() {
        mPresenter.getTradeFormDetailList(paramsVO);
        mSuperRecyclerView.refreshComplete();
    }

    @Override
    public void onLoadMore() {

    }

    @Override
    protected void onDestroy() {
        mPresenter.detachView();
        super.onDestroy();
    }
}
