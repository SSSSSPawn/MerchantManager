package com.bec.merchantmanager.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bec.merchantmanager.Presenter.HistoryDataPresenter;
import com.bec.merchantmanager.R;
import com.bec.merchantmanager.Utils.DateUtils;
import com.bec.merchantmanager.Utils.LogUtil;
import com.bec.merchantmanager.Utils.TimeUtils;
import com.bec.merchantmanager.base.BaseActivity;
import com.bec.merchantmanager.bean.DayTradeFormVO;
import com.bec.merchantmanager.bean.LineChartBeanVO;
import com.bec.merchantmanager.view.LineChartView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

import static com.bec.merchantmanager.Utils.TimeUtils.getCurrentMonday;

/**
 * Created by admin on 2017/10/25.
 */

public class HistoryDataActivity extends BaseActivity implements HistoryDataPresenter.MvpView{

    @Bind(R.id.ll_content) LinearLayout ll_content;

    @Bind(R.id.ll_empty) LinearLayout ll_empty;

    @Bind(R.id.line_chart_view) LineChartView mLineChartView;

    @Bind(R.id.line_chart_view_month) LineChartView mLineChartViewMonth;

    @Bind(R.id.tv_week_empty) TextView tv_week_empty;

    @Bind(R.id.tv_month_empty) TextView tv_month_empty;

    @Bind(R.id.iv_history_switch) ImageView iv_history_switch;

    private HistoryDataPresenter mPresenter = new HistoryDataPresenter();

    private List<LineChartBeanVO> mChartBeanVOs = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter.attachView(this);

//        //本周的数据
//        mPresenter.getDayTradeLists(1, getCurrentMonday() + " 00:00:00", TimeUtils.getPreviousSunday() + " 23:59:59");

        //本月所有的数据
        mPresenter.getDayTradeLists(1, TimeUtils.getMinMonthDate(getCurrentMonday()) + " 00:00:00",
                TimeUtils.getMaxMonthDate(getCurrentMonday()) + " 23:59:59");

    }

    @Override
    protected boolean isBindEventBus() {
        return false;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_history_data;
    }


    @OnClick({R.id.iv_history_switch})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_history_switch:
                launch(HistoryListDataActivity.class);
                break;
        }
    }

    @Override
    public void updateTradeFromList(ArrayList<DayTradeFormVO.RowsBean> lists) {

        LogUtil.e(" lists lists lists ===>>" + lists.size());

        ArrayList<DayTradeFormVO.RowsBean> mWeekList = new ArrayList<>();

        if (lists.size() == 0) {
            ll_content.setVisibility(View.GONE);
            ll_empty.setVisibility(View.VISIBLE);
            return;
        }

        for (int i = 0; i < lists.size(); i++) {

            DayTradeFormVO.RowsBean bean = lists.get(i);

            long reportDay = bean.getReportDay();

            long startSeconds = getMillionSeconds(TimeUtils.getMinMonthDate(getCurrentMonday()) + " 00:00:00");

            long endSeconds = getMillionSeconds(TimeUtils.getMinMonthDate(getCurrentMonday()) + " 23:59:59");

            if (reportDay >= startSeconds && reportDay <= endSeconds) {
                mWeekList.add(bean);
            }
        }

        for (int i = mWeekList.size() - 1; i >= 0; i--) {
            DayTradeFormVO.RowsBean bean = lists.get(i);

            long reportDay = bean.getReportDay();
            double saleAmount = bean.getSaleAmount();

            String money = DateUtils.formatMoney(saleAmount);
            String format = DateUtils.dateFormat(reportDay, "EE");

            LineChartBeanVO vo = new LineChartBeanVO(format, saleAmount, money);

            mChartBeanVOs.add(vo);
        }

        if (mChartBeanVOs.size() == 0) {
            tv_week_empty.setVisibility(View.VISIBLE);
        } else {
            mLineChartView.setData(mChartBeanVOs);
        }

        mChartBeanVOs.clear();

        for (int i = lists.size() - 1; i >= 0; i--) {
            DayTradeFormVO.RowsBean bean = lists.get(i);

            long reportDay = bean.getReportDay();
            double saleAmount = bean.getSaleAmount();

            String money = DateUtils.formatMoney(saleAmount);
            String format = DateUtils.dateFormat(reportDay, "MM-dd");

            LineChartBeanVO vo = new LineChartBeanVO(format, saleAmount, money);

            mChartBeanVOs.add(vo);
        }

        if (mChartBeanVOs.size() == 0) {
            tv_month_empty.setVisibility(View.VISIBLE);
        } else {
            mLineChartViewMonth.setData(mChartBeanVOs);
        }
    }

    public long getMillionSeconds(String time) {

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            long timeStart = sdf.parse(time).getTime();
            return timeStart;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return -1;
    }


    @Override
    protected void onDestroy() {
        mPresenter.detachView();
        super.onDestroy();
    }
}
