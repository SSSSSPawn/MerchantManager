package com.iotek.merchantmanager.bean;

import java.util.List;

/**
 * Created by admin on 2017/10/23.
 */

public class SalesDataItemDetailVO extends BaseBean {


    /**
     * page : 1
     * records : 1
     * rows : [{"goodsAmount":1,"goodsId":"2121150423196605044570","goodsName":"合生元奶粉","goodsNum":1,"goodsPrice":1,"goodsStandard":"500g","goodsUnit":"罐","orderId":"2017101917075800006022","uid":"cde9b714-a864-4ccf-b529-c5bef0274740"}]
     * total : 1
     */

    private int page;
    private int records;
    private int total;
    private List<RowsBean> rows;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRecords() {
        return records;
    }

    public void setRecords(int records) {
        this.records = records;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<RowsBean> getRows() {
        return rows;
    }

    public void setRows(List<RowsBean> rows) {
        this.rows = rows;
    }

    public static class RowsBean {
        /**
         * goodsAmount : 1
         * goodsId : 2121150423196605044570
         * goodsName : 合生元奶粉
         * goodsNum : 1
         * goodsPrice : 1
         * goodsStandard : 500g
         * goodsUnit : 罐
         * orderId : 2017101917075800006022
         * uid : cde9b714-a864-4ccf-b529-c5bef0274740
         */

        private double goodsAmount;
        private String goodsId;
        private String goodsName;
        private int goodsNum;
        private double goodsPrice;
        private String goodsStandard;
        private String goodsUnit;
        private String orderId;
        private String uid;

        public double getGoodsAmount() {
            return goodsAmount;
        }

        public void setGoodsAmount(double goodsAmount) {
            this.goodsAmount = goodsAmount;
        }

        public String getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(String goodsId) {
            this.goodsId = goodsId;
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

        public String getGoodsStandard() {
            return goodsStandard;
        }

        public void setGoodsStandard(String goodsStandard) {
            this.goodsStandard = goodsStandard;
        }

        public String getGoodsUnit() {
            return goodsUnit;
        }

        public void setGoodsUnit(String goodsUnit) {
            this.goodsUnit = goodsUnit;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }
    }
}
