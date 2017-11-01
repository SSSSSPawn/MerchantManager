package com.iotek.merchantmanager.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;

import com.github.mikephil.charting.charts.PieChart;
import com.iotek.merchantmanager.Presenter.MonthPayTypePresenter;
import com.iotek.merchantmanager.Utils.DateUtils;
import com.iotek.merchantmanager.Utils.LogUtil;
import com.iotek.merchantmanager.Utils.MPChartUtil;
import com.iotek.merchantmanager.Utils.Preference;
import com.iotek.merchantmanager.base.BaseActivity;
import com.iotek.merchantmanager.bean.MonthTradeDetailVO;
import com.iotek.merchantmanager.bean.PayStylePieEntry;
import com.iotek.merchantmanager.bean.params.TradeFormDetailParamsVO;
import com.iotek.merchantmanager.constant.CacheKey;
import com.iotek.merchantmanager.constant.Intentkey;
import com.iotek.merchantmanager.constant.StatusKey;
import com.iotek.merchantmanager.view.AppBar;

import java.util.ArrayList;

import butterknife.Bind;
import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/10/31.
 */

public class MonthPayTypeActivity extends BaseActivity implements MonthPayTypePresenter.MvpView {

    @Bind(R.id.appBar) AppBar mAppBar;

    @Bind(R.id.ll_empty) LinearLayout ll_empty;

    @Bind(R.id.pie_chart) PieChart mPieChart;

    private MonthPayTypePresenter mPresenter = new MonthPayTypePresenter();

    private ArrayList<PayStylePieEntry> payName = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter.attachView(this);

        mAppBar.setTitle("月支付占比");
        mAppBar.setTextColor(getResources().getColor(R.color.white));

        long custID = Preference.getLong(CacheKey.CUST_ID);
        long rootID = Preference.getLong(CacheKey.ROOT_ID);
        String uuID = Preference.getString(CacheKey.UU_ID);
        String mac = Preference.getString(CacheKey.MAC);

        long extra = getIntent().getLongExtra(Intentkey.MONTH_DATA, -1);
        TradeFormDetailParamsVO paramsVO = new TradeFormDetailParamsVO(custID, rootID, uuID, mac, Integer.MAX_VALUE, 1, extra + "");
        mPresenter.getTradeFormDetailList(paramsVO);
    }

    @Override
    protected boolean isBindEventBus() {
        return false;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_month_pay_type;
    }

    @Override
    public void updateMonthTradeDetailList(ArrayList<MonthTradeDetailVO.RowsBean> lists) {

        double saleAmount;

        String formatMoney;

        String name;

        payName.clear();

        for (int i = 0; i < lists.size(); i++) {

            MonthTradeDetailVO.RowsBean rowsBean = lists.get(i);

            LogUtil.e("-->> rowsBean" + rowsBean.toString() + "\n");

            if (rowsBean.getPayType() == StatusKey.XJ_TYPE) {
                saleAmount = rowsBean.getSaleAmount();
                formatMoney = DateUtils.formatMoney(saleAmount);
                name = rowsBean.getTypeName();
            } else if (rowsBean.getPayType() == StatusKey.WX_TYPE) {
                saleAmount = rowsBean.getSaleAmount();
                formatMoney = DateUtils.formatMoney(saleAmount);
                name = rowsBean.getTypeName();
            } else if (rowsBean.getPayType() == StatusKey.ZFB_TYPE) {
                saleAmount = rowsBean.getSaleAmount();
                formatMoney = DateUtils.formatMoney(saleAmount);
                name = rowsBean.getTypeName();
            } else {
                saleAmount = rowsBean.getSaleAmount();
                formatMoney = DateUtils.formatMoney(saleAmount);
                name = rowsBean.getTypeName();
            }
            PayStylePieEntry pieEntry = new PayStylePieEntry(name, formatMoney);
            payName.add(pieEntry);
        }

        MPChartUtil.showPieChart(mPieChart, payName, "支付方式", "支付比例");
    }

    @Override
    public void emptyData() {
        ll_empty.setVisibility(View.VISIBLE);
        mPieChart.setVisibility(View.GONE);
    }

    @Override
    protected void onDestroy() {
        mPresenter.detachView();
        super.onDestroy();
    }
}
