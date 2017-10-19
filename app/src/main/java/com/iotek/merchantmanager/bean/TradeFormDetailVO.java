package com.iotek.merchantmanager.bean;

import java.util.List;

/**
 * Created by admin on 2017/10/17.
 */

public class TradeFormDetailVO extends BaseBean {


    /**
     * page : 1
     * records : 3
     * rows : [{"custId":21,"payType":2,"recordTime":1507744800239,"reportDay":1507651200000,"returnAmount":-350,"saleAmount":351,"typeName":"支付宝","uid":"7f4c623d-d785-44cc-bdfc-7f543cab8a18"},{"custId":21,"payType":1,"recordTime":1507744800232,"reportDay":1507651200000,"returnAmount":0,"saleAmount":1,"typeName":"微信支付","uid":"d54675f7-d121-44a5-b0f4-45da7affc71e"},{"custId":21,"payType":0,"recordTime":1507744800223,"reportDay":1507651200000,"returnAmount":-1,"saleAmount":7505,"typeName":"现金","uid":"197a95d9-69a4-44d8-8682-cbc3941ea974"}]
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
         * custId : 21
         * payType : 2
         * recordTime : 1507744800239
         * reportDay : 1507651200000
         * returnAmount : -350
         * saleAmount : 351
         * typeName : 支付宝
         * uid : 7f4c623d-d785-44cc-bdfc-7f543cab8a18
         */

        private int custId;
        private int payType;
        private long recordTime;
        private long reportDay;
        private double returnAmount;
        private double saleAmount;
        private String typeName;
        private String uid;

        public int getCustId() {
            return custId;
        }

        public void setCustId(int custId) {
            this.custId = custId;
        }

        public int getPayType() {
            return payType;
        }

        public double getReturnAmount() {
            return returnAmount;
        }

        public void setReturnAmount(double returnAmount) {
            this.returnAmount = returnAmount;
        }

        public double getSaleAmount() {
            return saleAmount;
        }

        public void setSaleAmount(double saleAmount) {
            this.saleAmount = saleAmount;
        }

        public void setPayType(int payType) {
            this.payType = payType;
        }

        public long getRecordTime() {
            return recordTime;
        }

        public void setRecordTime(long recordTime) {
            this.recordTime = recordTime;
        }

        public long getReportDay() {
            return reportDay;
        }

        public void setReportDay(long reportDay) {
            this.reportDay = reportDay;
        }

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        @Override
        public String toString() {
            return "RowsBean{" +
                    "custId=" + custId +
                    ", payType=" + payType +
                    ", recordTime=" + recordTime +
                    ", reportDay=" + reportDay +
                    ", returnAmount=" + returnAmount +
                    ", saleAmount=" + saleAmount +
                    ", typeName='" + typeName + '\'' +
                    ", uid='" + uid + '\'' +
                    '}';
        }
    }
}
