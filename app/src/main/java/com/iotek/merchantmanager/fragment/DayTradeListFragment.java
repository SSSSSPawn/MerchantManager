package com.iotek.merchantmanager.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.iotek.merchantmanager.Presenter.DayTradeFormsPresenter;
import com.iotek.merchantmanager.Utils.LogUtil;
import com.iotek.merchantmanager.Utils.Preference;
import com.iotek.merchantmanager.adapter.DayTradeFormAdapter;
import com.iotek.merchantmanager.base.ListFragment;
import com.iotek.merchantmanager.bean.DayTradeFormVO;
import com.iotek.merchantmanager.bean.PayStylePieEntry;
import com.iotek.merchantmanager.bean.TradeFormDetailVO;
import com.iotek.merchantmanager.bean.params.TradeFormDetailParamsVO;
import com.iotek.merchantmanager.constant.CacheKey;
import com.iotek.merchantmanager.constant.StatusKey;
import com.iotek.merchantmanager.listener.OnItemClickListener;

import java.util.ArrayList;

import butterknife.Bind;
import iotek.com.merchantmanager.R;

/**
 * Created by admin on 2017/10/11.
 */

public class DayTradeListFragment extends ListFragment implements DayTradeFormsPresenter.MvpView,OnItemClickListener {

    @Bind(R.id.ll_empty) LinearLayout ll_empty;

    @Bind(R.id.ll_content) LinearLayout mLayout;

    @Bind(R.id.pie_chart) PieChart mChart;

    private DayTradeFormsPresenter mPresenter = new DayTradeFormsPresenter();

    private ArrayList<DayTradeFormVO.RowsBean> listData = new ArrayList<>();

    private ArrayList<TradeFormDetailVO.RowsBean> listsType = new ArrayList<>();

    private ArrayList<PayStylePieEntry> payName = new ArrayList<>();

    private DayTradeFormAdapter mAdapter;

    //private double saleAmountAll,saleAmount_XJ,saleAmount_WX,saleAmount_ZFB,saleAmount_Other;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter.attachView(this);
        mAdapter = new DayTradeFormAdapter();
        mAdapter.setOnItemClickListener(this);

        long custID = Preference.getLong(CacheKey.CUST_ID);
        long rootID = Preference.getLong(CacheKey.ROOT_ID);
        String uuID = Preference.getString(CacheKey.UU_ID);
        String mac = Preference.getString(CacheKey.MAC);

        TradeFormDetailParamsVO  paramsVO = new TradeFormDetailParamsVO(custID,rootID,uuID,mac,10,1,"2017-10-18");

        mPresenter.getTradeFormDetailList(paramsVO);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mSuperRecyclerView.setLoadingMoreEnabled(false);

        showPieChart();
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
    }

    @Override
    public void showPayStyle(ArrayList<TradeFormDetailVO.RowsBean> lists) {

        listsType = lists;

        LogUtil.e("listsType listsType-->>" + listsType.size());

        double saleAmount = 0;

        String name = "";


        LogUtil.e("lists lists" + lists.size());

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

            PayStylePieEntry pieEntry = new PayStylePieEntry(name,saleAmount);
            payName.add(pieEntry);
        }

        LogUtil.e("payName ----" + payName.toString());
    }

    @Override
    public void stopLoadMore() {

    }

    @Override
    protected boolean isBindEventBus() {
        return false;
    }

    @Override
    public void OnItemClick(int position) {

    }

    private void showPieChart(){
        mChart.setUsePercentValues(true);
        mChart.getDescription().setEnabled(false);
        mChart.setExtraOffsets(5, 10, 5, 5);

        mChart.setDragDecelerationFrictionCoef(0.95f);

        mChart.setExtraOffsets(20.f, 0.f, 20.f, 0.f);

        mChart.setDrawHoleEnabled(true);
        mChart.setHoleColor(Color.WHITE);

        mChart.setTransparentCircleColor(Color.WHITE);
        mChart.setTransparentCircleAlpha(110);
        mChart.setHoleRadius(58f);
        mChart.setTransparentCircleRadius(61f);

        mChart.setDrawCenterText(true);
        mChart.setCenterText("支付方式");

        mChart.setRotationAngle(0);
        mChart.setRotationEnabled(true);
        mChart.setHighlightPerTapEnabled(true);

        setData(listsType.size(), 100);

        mChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);
        Legend l = mChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setEnabled(true);
    }

    private void setData(int count, float range) {

        String[] mParties = new String[]{
               "支付宝","微信","现金","其他"
        };

        float mult = range;

        ArrayList<PieEntry> entries = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            entries.add(new PieEntry((float) (Math.random() * mult) + mult / 5, mParties[i % mParties.length]));
        }

//        PieEntry ConsumptionBalance = new PieEntry(30, "消费余额 768");
//        pieEntryList.add(CashBalance);
//        pieEntryList.add(ConsumptionBalance);
//
//        PieData pieData = new PieData(entries,"");

        //PieEntry entry = new PieEntry();

        PieDataSet dataSet = new PieDataSet(entries, "");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);

        ArrayList<Integer> colors = new ArrayList<>();

        for (int c : ColorTemplate.COLORFUL_COLORS)
            colors.add(c);

        colors.add(ColorTemplate.getHoloBlue());

        dataSet.setColors(colors);
        dataSet.setValueLinePart1OffsetPercentage(80.f);
        dataSet.setValueLinePart1Length(0.2f);
        dataSet.setValueLinePart2Length(0.4f);
        dataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);

        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.BLACK);
        mChart.setData(data);

        mChart.highlightValues(null);

        mChart.invalidate();
    }
}
