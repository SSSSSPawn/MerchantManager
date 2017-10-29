package com.iotek.merchantmanager.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.iotek.merchantmanager.Presenter.HistoryDataPresenter;
import com.iotek.merchantmanager.Utils.DateUtils;
import com.iotek.merchantmanager.Utils.LogUtil;
import com.iotek.merchantmanager.Utils.TimeUtils;
import com.iotek.merchantmanager.base.BaseActivity;
import com.iotek.merchantmanager.bean.DayTradeFormVO;
import com.iotek.merchantmanager.bean.LineChartBeanVO;
import com.iotek.merchantmanager.view.AppBar;
import com.iotek.merchantmanager.view.LineChartView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import iotek.com.merchantmanager.R;

import static com.iotek.merchantmanager.Utils.TimeUtils.getCurrentMonday;

/**
 * Created by admin on 2017/10/25.
 */

public class HistoryDataActivity extends BaseActivity implements HistoryDataPresenter.MvpView{

    private String daySalesXs = "本周销售趋势";

    private String daySalesTh = "本周退货趋势";

    @Bind(R.id.appBar) AppBar mAppBar;

    @Bind(R.id.ll_content) LinearLayout ll_content;

    @Bind(R.id.ll_empty) LinearLayout ll_empty;

    @Bind(R.id.line_chart_view) LineChartView mLineChartView;

    @Bind(R.id.tv_sales) TextView tvSales;

    @Bind(R.id.tv_sales_date) TextView tvSalesDate;

    private HistoryDataPresenter mPresenter = new HistoryDataPresenter();

    private List<LineChartBeanVO> mChartBeanVOs = new ArrayList<>();

    private ArrayList<DayTradeFormVO.RowsBean> mWeekList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter.attachView(this);

        //本周的数据
        mPresenter.getDayTradeLists(1, getCurrentMonday() + " 00:00:00", TimeUtils.getPreviousSunday() + " 23:59:59");

        //本月所有的数据
        // mPresenter.getDayTradeLists(1, TimeUtils.getMinMonthDate(getCurrentMonday()) + " 00:00:00", TimeUtils.getMaxMonthDate(getCurrentMonday()) + " 23:59:59");

        mAppBar.setTitle("历史数据");
        mAppBar.setTextColor(getResources().getColor(R.color.white));

    }

    private void initData(int dataType) {

        //本月的数据
       // mPresenter.getDayTradeList(1, TimeUtils.getMinMonthDate(getCurrentMonday()) + " 00:00:00", TimeUtils.getMaxMonthDate(getCurrentMonday()) + " 23:59:59");

    }

    @Override
    protected boolean isBindEventBus() {
        return false;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_history_data;
    }


    @OnClick({R.id.tv_sales, R.id.tv_sales_date})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_sales:
                mChartBeanVOs.clear();
                setLineChartData();
                break;
        }



    }

    @Override
    public void updateTradeFromList(ArrayList<DayTradeFormVO.RowsBean> lists) {

        LogUtil.e(" lists lists lists ===>>" + lists.size());

        mWeekList = lists;

        if (lists.size() == 0) {
            ll_content.setVisibility(View.GONE);
            ll_empty.setVisibility(View.VISIBLE);
            return;
        }

        for (int i = lists.size()-1; i >= 0; i--) {
            DayTradeFormVO.RowsBean bean = lists.get(i);

            long reportDay = bean.getReportDay();
            double saleAmount = bean.getSaleAmount();

            String money = DateUtils.formatMoney(saleAmount);
            String format = DateUtils.dateFormat(reportDay, "EE");

            LineChartBeanVO vo = new LineChartBeanVO(format, saleAmount, money);

            mChartBeanVOs.add(vo);
        }

        mLineChartView.setData(mChartBeanVOs);
    }


    private void setLineChartData() {
        if (daySalesTh.equals(tvSalesDate.getText().toString())) {
            tvSales.setText("退货趋势");
            tvSalesDate.setText("本周销售趋势");
            for (int i = mWeekList.size() - 1; i >= 0; i--) {
                DayTradeFormVO.RowsBean bean = mWeekList.get(i);

                long reportDay = bean.getReportDay();
                double saleAmount = bean.getSaleAmount();

                String money = DateUtils.formatMoney(saleAmount);
                String format = DateUtils.dateFormat(reportDay, "EE");

                LineChartBeanVO vo = new LineChartBeanVO(format, saleAmount, money);

                mChartBeanVOs.add(vo);
            }
            mLineChartView.setData(mChartBeanVOs);
        } else if (daySalesXs.equals(tvSalesDate.getText().toString())) {
            tvSales.setText("销售趋势");
            tvSalesDate.setText("本周退货趋势");
            for (int i = mWeekList.size() - 1; i >= 0; i--) {
                DayTradeFormVO.RowsBean bean = mWeekList.get(i);

                long reportDay = bean.getReportDay();
                double returnAmount = bean.getReturnAmount();

                String money = DateUtils.formatMoney(returnAmount);
                String format = DateUtils.dateFormat(reportDay, "EE");

                LineChartBeanVO vo = new LineChartBeanVO(format, returnAmount, money);

                mChartBeanVOs.add(vo);
            }
            mLineChartView.setData(mChartBeanVOs);

        }
    }


    @Override
    protected void onDestroy() {
        mPresenter.detachView();
        super.onDestroy();
    }
}
