package com.iotek.merchantmanager.bean;

import java.util.List;

/**
 * Created by admin on 2017/10/12.
 */

public class DayTradeFormVO extends BaseBean {


    /**
     * page : 1
     * records : 3
     * rows : [{"cost":0,"custId":21,"custName":"亚青","profits":0,"realAmount":7857,"reportDay":1507651200000,"returnAmount":-351,"returnCount":2,"saleAmount":7857,"saleCount":18,"shiftTime":1507744800184},{"cost":0,"custId":21,"custName":"亚青","profits":0,"realAmount":10812,"reportDay":1507564800000,"returnAmount":-462,"returnCount":3,"saleAmount":10812,"saleCount":5,"shiftTime":1507734175163},{"cost":0,"custId":21,"custName":"亚青","profits":0,"realAmount":2940,"reportDay":1507478400000,"returnAmount":-700,"returnCount":2,"saleAmount":2940,"saleCount":10,"shiftTime":1507572000037}]
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
         * custId : 21
         * custName : 亚青
         * profits : 0
         * realAmount : 7857
         * reportDay : 1507651200000
         * returnAmount : -351
         * returnCount : 2
         * saleAmount : 7857
         * saleCount : 18
         * shiftTime : 1507744800184
         */

        private double cost;
        private int custId;
        private String custName;
        private double profits;
        private double realAmount;
        private long reportDay;
        private double returnAmount;
        private double returnCount;
        private double saleAmount;
        private double saleCount;
        private long shiftTime;

        public double getCost() {
            return cost;
        }

        public void setCost(double cost) {
            this.cost = cost;
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

        public double getProfits() {
            return profits;
        }

        public void setProfits(double profits) {
            this.profits = profits;
        }

        public double getRealAmount() {
            return realAmount;
        }

        public void setRealAmount(double realAmount) {
            this.realAmount = realAmount;
        }

        public long getReportDay() {
            return reportDay;
        }

        public void setReportDay(long reportDay) {
            this.reportDay = reportDay;
        }

        public double getReturnAmount() {
            return returnAmount;
        }

        public void setReturnAmount(double returnAmount) {
            this.returnAmount = returnAmount;
        }

        public double getReturnCount() {
            return returnCount;
        }

        public void setReturnCount(double returnCount) {
            this.returnCount = returnCount;
        }

        public double getSaleAmount() {
            return saleAmount;
        }

        public void setSaleAmount(double saleAmount) {
            this.saleAmount = saleAmount;
        }

        public double getSaleCount() {
            return saleCount;
        }

        public void setSaleCount(double saleCount) {
            this.saleCount = saleCount;
        }

        public long getShiftTime() {
            return shiftTime;
        }

        public void setShiftTime(long shiftTime) {
            this.shiftTime = shiftTime;
        }
    }
}
