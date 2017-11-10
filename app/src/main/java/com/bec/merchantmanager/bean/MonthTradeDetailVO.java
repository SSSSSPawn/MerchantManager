package com.bec.merchantmanager.bean;

import java.util.List;

/**
 * Created by admin on 2017/10/31.
 */

public class MonthTradeDetailVO extends BaseBean{


    /**
     * page : 1
     * records : 3
     * rows : [{"custId":21,"payType":1000,"recordTime":1506787200264,"reportMonth":1504195200000,"returnAmount":0,"saleAmount":62,"uid":"a8d0106d-2431-4354-93d0-ac55fb1c40a0"},{"custId":21,"payType":8,"recordTime":1506787200259,"reportMonth":1504195200000,"returnAmount":-2926,"saleAmount":81507,"typeName":"会员卡支付","uid":"590e38da-7da4-4ba9-bef8-8c0f9fa61002"},{"custId":21,"payType":5,"recordTime":1506787200255,"reportMonth":1504195200000,"returnAmount":-12,"saleAmount":14,"typeName":"银联卡支付","uid":"64e31f88-8e81-4da4-aad2-6942684d1943"}]
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
         * payType : 1000
         * recordTime : 1506787200264
         * reportMonth : 1504195200000
         * returnAmount : 0
         * saleAmount : 62
         * uid : a8d0106d-2431-4354-93d0-ac55fb1c40a0
         * typeName : 会员卡支付
         */

        private int custId;
        private int payType;
        private long recordTime;
        private long reportMonth;
        private double returnAmount;
        private double saleAmount;
        private String uid;
        private String typeName;

        public int getCustId() {
            return custId;
        }

        public void setCustId(int custId) {
            this.custId = custId;
        }

        public int getPayType() {
            return payType;
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

        public long getReportMonth() {
            return reportMonth;
        }

        public void setReportMonth(long reportMonth) {
            this.reportMonth = reportMonth;
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

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }
    }
}
