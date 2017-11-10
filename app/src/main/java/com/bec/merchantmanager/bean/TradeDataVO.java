package com.bec.merchantmanager.bean;

/**
 * Created by Administrator on 2017/10/22.
 */

public class TradeDataVO extends BaseBean {

    private int payType1; //支付方式

    private int orderType;//订单类型

    private double receiveAmount;// 实收金额

    private double oriAmount;//原价金额

    private String cashier;//收银员

    private long saleTime;//销售时间

    public TradeDataVO(int payType1, int orderType, double receiveAmount, double oriAmount, String cashier, long saleTime) {
        this.payType1 = payType1;
        this.orderType = orderType;
        this.receiveAmount = receiveAmount;
        this.oriAmount = oriAmount;
        this.cashier = cashier;
        this.saleTime = saleTime;
    }

    public int getPayType1() {
        return payType1;
    }

    public void setPayType1(int payType1) {
        this.payType1 = payType1;
    }

    public int getOrderType() {
        return orderType;
    }

    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }

    public double getReceiveAmount() {
        return receiveAmount;
    }

    public void setReceiveAmount(double receiveAmount) {
        this.receiveAmount = receiveAmount;
    }

    public double getOriAmount() {
        return oriAmount;
    }

    public void setOriAmount(double oriAmount) {
        this.oriAmount = oriAmount;
    }

    public String getCashier() {
        return cashier;
    }

    public void setCashier(String cashier) {
        this.cashier = cashier;
    }

    public long getSaleTime() {
        return saleTime;
    }

    public void setSaleTime(long saleTime) {
        this.saleTime = saleTime;
    }
}
