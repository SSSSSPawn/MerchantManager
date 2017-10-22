package com.iotek.merchantmanager.bean;

/**
 * Created by Administrator on 2017/10/22.
 */

public class TradeDataVO extends BaseBean {

    private int payType1; //支付方式

    private String goodsName;//商品名称

    private int goodsNum;//销售数量

    private double goodsPrice;//商品单价

    private double goodsAmount;//支付总金额

    public TradeDataVO(int payType1, String goodsName, int goodsNum, double goodsPrice, double goodsAmount) {
        this.payType1 = payType1;
        this.goodsName = goodsName;
        this.goodsNum = goodsNum;
        this.goodsPrice = goodsPrice;
        this.goodsAmount = goodsAmount;
    }

    public int getPayType1() {
        return payType1;
    }

    public void setPayType1(int payType1) {
        this.payType1 = payType1;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(int goodsNum) {
        this.goodsNum = goodsNum;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public double getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(double goodsAmount) {
        this.goodsAmount = goodsAmount;
    }
}
