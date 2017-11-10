package com.bec.merchantmanager.Utils;

import android.graphics.Color;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.bec.merchantmanager.bean.PayStylePieEntry;

import java.util.ArrayList;

/**
 * Created by admin on 2017/10/20.
 */

public class MPChartUtil {

    public static void showPieChart(PieChart mChart, ArrayList<PayStylePieEntry> datas, String label, String conterText) {

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

        mChart.setCenterText(conterText);

        mChart.setDrawEntryLabels(!mChart.isDrawEntryLabelsEnabled());

        mChart.setRotationAngle(0);
        mChart.setRotationEnabled(true);
        mChart.setHighlightPerTapEnabled(true);

        setPieChartData(mChart, datas, label);

        mChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);
        Legend l = mChart.getLegend();
        l.setXEntrySpace(2f);//设置距离饼图的距离，防止与饼图重合  
        l.setYEntrySpace(2f);//设置比例块换行...  
        l.setWordWrapEnabled(true);
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(true);
        l.setEnabled(true);//图例不显示
    }

    public static void setPieChartData(PieChart mChart, ArrayList<PayStylePieEntry> datas, String label) {

        ArrayList<PieEntry> entries = new ArrayList<>();

        for (int i = 0; i < datas.size(); i++) {
            entries.add(new PieEntry((float) datas.get(i).getMoney(), datas.get(i).getPayName() + "\n\n¥" + datas.get(i).getMoney()));
            //datas.get(i).getPayName() + "\n\n¥" + datas.get(i).getMoney();
        }

        PieDataSet dataSet = new PieDataSet(entries, label);
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
        data.setValueTextSize(12f);
        data.setValueTextColor(Color.BLACK);
        mChart.setData(data);
        mChart.highlightValues(null);

        mChart.invalidate();
    }
}
