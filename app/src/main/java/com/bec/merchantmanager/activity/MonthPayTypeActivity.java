package com.bec.merchantmanager.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;

import com.bec.merchantmanager.Presenter.MonthPayTypePresenter;
import com.bec.merchantmanager.R;
import com.bec.merchantmanager.Utils.LogUtil;
import com.bec.merchantmanager.Utils.MPChartUtil;
import com.bec.merchantmanager.Utils.Preference;
import com.bec.merchantmanager.base.BaseActivity;
import com.bec.merchantmanager.bean.MonthTradeDetailVO;
import com.bec.merchantmanager.bean.PayStylePieEntry;
import com.bec.merchantmanager.bean.params.TradeFormDetailParamsVO;
import com.bec.merchantmanager.constant.CacheKey;
import com.bec.merchantmanager.constant.Intentkey;
import com.bec.merchantmanager.constant.StatusKey;
import com.bec.merchantmanager.view.AppBar;
import com.github.mikephil.charting.charts.PieChart;

import java.util.ArrayList;

import butterknife.Bind;

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

        String name;

        payName.clear();

        for (int i = 0; i < lists.size(); i++) {

            MonthTradeDetailVO.RowsBean rowsBean = lists.get(i);

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
