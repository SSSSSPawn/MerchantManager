package com.iotek.merchantmanager.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.iotek.merchantmanager.Presenter.DayTradeFormsPresenter;
import com.iotek.merchantmanager.Utils.DateUtils;
import com.iotek.merchantmanager.Utils.LogUtil;
import com.iotek.merchantmanager.Utils.MPChartUtil;
import com.iotek.merchantmanager.Utils.Preference;
import com.iotek.merchantmanager.activity.TradeFormDetailActivity;
import com.iotek.merchantmanager.adapter.DayTradeFormAdapter;
import com.iotek.merchantmanager.base.ListFragment;
import com.iotek.merchantmanager.bean.DayTradeFormVO;
import com.iotek.merchantmanager.bean.PayStylePieEntry;
import com.iotek.merchantmanager.bean.TradeFormDetailVO;
import com.iotek.merchantmanager.bean.params.TradeFormDetailParamsVO;
import com.iotek.merchantmanager.constant.CacheKey;
import com.iotek.merchantmanager.constant.StatusKey;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.OnClick;
import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/10/11.
 */

public class DayTradeListFragment extends ListFragment implements DayTradeFormsPresenter.MvpView {

    @Bind(R.id.ll_empty) LinearLayout ll_empty;

    @Bind(R.id.ll_content) LinearLayout mLayout;

    @Bind(R.id.pie_chart) PieChart mChart;

    @Bind(R.id.tv_trade_detail) TextView tv_trade_detail;

    private DayTradeFormsPresenter mPresenter = new DayTradeFormsPresenter();

    private ArrayList<DayTradeFormVO.RowsBean> listData = new ArrayList<>();

    private ArrayList<PayStylePieEntry> payName = new ArrayList<>();

    private DayTradeFormAdapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter.attachView(this);
        mAdapter = new DayTradeFormAdapter();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mSuperRecyclerView.setLoadingMoreEnabled(false);
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return mAdapter;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_day_trade_data;
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
        mSuperRecyclerView.loadMoreComplete();
    }


    @Override
    public void updateTradeFromList(ArrayList<DayTradeFormVO.RowsBean> lists) {
        listData = lists;
        if (lists.size() == 0) {
            mLayout.setVisibility(View.GONE);
            ll_empty.setVisibility(View.VISIBLE);
        }
        mAdapter.setDataList(lists);

        long custID = Preference.getLong(CacheKey.CUST_ID);
        long rootID = Preference.getLong(CacheKey.ROOT_ID);
        String uuID = Preference.getString(CacheKey.UU_ID);
        String mac = Preference.getString(CacheKey.MAC);

        TradeFormDetailParamsVO paramsVO = new TradeFormDetailParamsVO(custID, rootID, uuID, mac, 10, 1, DateUtils.dateFormatDay(lists.get(0).getReportDay()));

        mPresenter.getTradeFormDetailList(paramsVO);

    }

    @Override
    public void showPayStyle(ArrayList<TradeFormDetailVO.RowsBean> lists) {

        double saleAmount = 0;

        String name = "";

        LogUtil.e("lists lists" + lists.size());

        payName.clear();

        for (int i = 0; i < lists.size(); i++) {

            TradeFormDetailVO.RowsBean rowsBean = lists.get(i);

            LogUtil.e("-->> rowsBean" + rowsBean.toString() + "\n");

            if (rowsBean.getPayType() == StatusKey.XJ_TYPE) {
                saleAmount = rowsBean.getSaleAmount();
                name = rowsBean.getTypeName();
            } else if (rowsBean.getPayType() == StatusKey.WX_TYPE) {
                saleAmount = rowsBean.getSaleAmount();
                name = rowsBean.getTypeName();
            } else if (rowsBean.getPayType() == StatusKey.ZFB_TYPE) {
                saleAmount = rowsBean.getSaleAmount();
                name = rowsBean.getTypeName();
            } else {
                saleAmount = rowsBean.getSaleAmount();
                name = rowsBean.getTypeName();
            }
            PayStylePieEntry pieEntry = new PayStylePieEntry(name, saleAmount);
            payName.add(pieEntry);
        }

        LogUtil.e("payName ----" + payName.toString());

        MPChartUtil.showPieChart(mChart, payName, "支付方式", "支付比例");
    }

    @OnClick(R.id.tv_trade_detail)
    public void onViewClicked() {
        launch(TradeFormDetailActivity.class);
    }

    @Override
    public void stopLoadMore() {

    }

    @Override
    protected boolean isBindEventBus() {
        return false;
    }
}
