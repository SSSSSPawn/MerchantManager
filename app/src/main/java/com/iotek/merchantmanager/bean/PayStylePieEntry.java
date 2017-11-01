package com.iotek.merchantmanager.bean;

/**
 * Created by admin on 2017/10/19.
 */

public class PayStylePieEntry{

    private String payName;

    private String money;

    public PayStylePieEntry(String payName, String money) {
        this.payName = payName;
        this.money = money;
    }

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "PayStylePieEntry{" +
                "payName='" + payName + '\'' +
                ", money=" + money +
                '}';
    }
}
