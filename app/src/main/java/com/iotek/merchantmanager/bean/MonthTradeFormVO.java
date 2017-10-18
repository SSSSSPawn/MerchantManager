package com.iotek.merchantmanager.bean;

import java.util.List;

/**
 * Created by admin on 2017/10/16.
 */

public class MonthTradeFormVO extends BaseBean {


    /**
     * page : 1
     * records : 1
     * rows : [{"cost":0,"couponAmount":0,"custId":21,"custName":"亚青","profits":0,"realAmount":1.0220585845E8,"recordTime":1507734175131,"reportMonth":1504195200000,"returnAmount":-1.5591852911E8,"returnCount":23,"saleAmount":1.0346462945E8,"saleCount":23}]
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
         * cost : 0
         * couponAmount : 0
         * custId : 21
         * custName : 亚青
         * profits : 0
         * realAmount : 1.0220585845E8
         * recordTime : 1507734175131
         * reportMonth : 1504195200000
         * returnAmount : -1.5591852911E8
         * returnCount : 23
         * saleAmount : 1.0346462945E8
         * saleCount : 23
         */

        private int cost;
        private int couponAmount;
        private int custId;
        private String custName;
        private int profits;
        private double realAmount;
        private long recordTime;
        private long reportMonth;
        private double returnAmount;
        private int returnCount;
        private double saleAmount;
        private int saleCount;

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        public int getCouponAmount() {
            return couponAmount;
        }

        public void setCouponAmount(int couponAmount) {
            this.couponAmount = couponAmount;
        }

        public int getCustId() {
            return custId;
        }

        public void setCustId(int custId) {
            this.custId = custId;
        }

        public String getCustName() {
            return custName;
        }

        public void setCustName(String custName) {
            this.custName = custName;
        }

        public int getProfits() {
            return profits;
        }

        public void setProfits(int profits) {
            this.profits = profits;
        }

        public double getRealAmount() {
            return realAmount;
        }

        public void setRealAmount(double realAmount) {
            this.realAmount = realAmount;
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

        public int getReturnCount() {
            return returnCount;
        }

        public void setReturnCount(int returnCount) {
            this.returnCount = returnCount;
        }

        public double getSaleAmount() {
            return saleAmount;
        }

        public void setSaleAmount(double saleAmount) {
            this.saleAmount = saleAmount;
        }

        public int getSaleCount() {
            return saleCount;
        }

        public void setSaleCount(int saleCount) {
            this.saleCount = saleCount;
        }
    }
}
