package com.iotek.merchantmanager.bean;

/**
 * Created by admin on 2017/10/26.
 */

public class LineChartBeanVO extends BaseBean {

    private String xValues;

    private double yValues;

    private String values;

    public LineChartBeanVO(String xValues, double yValues) {
        this.xValues = xValues;
        this.yValues = yValues;
    }

    public LineChartBeanVO(String xValues, double yValues, String values) {
        this.xValues = xValues;
        this.yValues = yValues;
        this.values = values;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    public String getxValues() {
        return xValues;
    }

    public void setxValues(String xValues) {
        this.xValues = xValues;
    }

    public double getyValues() {
        return yValues;
    }

    public void setyValues(double yValues) {
        this.yValues = yValues;
    }
}
