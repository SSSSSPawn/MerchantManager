package com.bec.merchantmanager.bean;

import java.util.List;

/**
 * Created by admin on 2017/11/2.
 */

public class SelectShiftReportVO extends BaseBean {


    /**
     * page : 1
     * rows : [{"couponAmount":0,"custId":21,"custName":"亚青","operName":"13605154259","realAmount":40064,"returnAmount":2175,"returnCount":12,"saleAmount":42214,"saleCount":60,"shiftEndTime":1509008941000,"shiftId":"2120171026170901","shiftStartTime":1506590251000},{"custId":21,"custName":"亚青","operName":"13605154259","realAmount":351,"returnAmount":0,"returnCount":0,"saleAmount":351,"saleCount":1,"shiftEndTime":1506590251000,"shiftId":"2120170928171732","shiftStartTime":1506590136000},{"couponAmount":0,"custId":21,"custName":"亚青","operName":"13605154259","realAmount":1.0182224335E8,"returnAmount":141272,"returnCount":86,"saleAmount":1.0182615035E8,"saleCount":153,"shiftEndTime":1506590136000,"shiftId":"2120170928171537","shiftStartTime":1504596210000},{"couponAmount":0,"custId":21,"custName":"亚青","operName":"13814689521","realAmount":70151.5,"returnAmount":4021.14,"returnCount":11,"saleAmount":70151.5,"saleCount":31,"shiftEndTime":1505871471000,"shiftId":"2120170920093751","shiftStartTime":1505352916000},{"couponAmount":0,"custId":21,"custName":"亚青","operName":"15952056387","realAmount":2466.6,"returnAmount":303.71,"returnCount":4,"saleAmount":2467.6,"saleCount":17,"shiftEndTime":1505792489000,"shiftId":"2120170919114129"},{"couponAmount":0,"custId":21,"custName":"亚青","operName":"15996244906","realAmount":123059,"returnAmount":1001,"returnCount":2,"saleAmount":123059,"saleCount":8,"shiftEndTime":1505357573000,"shiftId":"2120170914105253","shiftStartTime":1504776094000},{"couponAmount":0,"custId":21,"custName":"亚青","operName":"13814689521","realAmount":409818,"returnAmount":10451,"returnCount":15,"saleAmount":471845,"saleCount":37,"shiftEndTime":1505352916000,"shiftId":"2120170914093516","shiftStartTime":1504857761000},{"couponAmount":0,"custId":21,"custName":"亚青","operName":"13814689521","realAmount":32104,"returnAmount":900,"returnCount":3,"saleAmount":32554,"saleCount":12,"shiftEndTime":1504857761000,"shiftId":"2120170908160241","shiftStartTime":1504835186000},{"custId":21,"custName":"亚青","operName":"13814689521","realAmount":681,"returnAmount":0,"returnCount":0,"saleAmount":907,"saleCount":9,"shiftEndTime":1504835186000,"shiftId":"2120170908094626","shiftStartTime":1504777868000},{"couponAmount":0,"custId":21,"custName":"亚青","operName":"13814689521","realAmount":1005145,"returnAmount":173,"returnCount":110,"saleAmount":1015009,"saleCount":335,"shiftEndTime":1504777868000,"shiftId":"2120170907175108"}]
     */

    private int page;
    private List<RowsBean> rows;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<RowsBean> getRows() {
        return rows;
    }

    public void setRows(List<RowsBean> rows) {
        this.rows = rows;
    }

    public static class RowsBean {
        /**
         * couponAmount : 0
         * custId : 21
         * custName : 亚青
         * operName : 13605154259
         * realAmount : 40064
         * returnAmount : 2175
         * returnCount : 12
         * saleAmount : 42214
         * saleCount : 60
         * shiftEndTime : 1509008941000
         * shiftId : 2120171026170901
         * shiftStartTime : 1506590251000
         */

        private double couponAmount;
        private int custId;
        private String custName;
        private String operName;
        private double realAmount;
        private double returnAmount;
        private int returnCount;
        private double saleAmount;
        private int saleCount;
        private long shiftEndTime;
        private String shiftId;
        private long shiftStartTime;

        public double getCouponAmount() {
            return couponAmount;
        }

        public void setCouponAmount(double couponAmount) {
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

        public String getOperName() {
            return operName;
        }

        public void setOperName(String operName) {
            this.operName = operName;
        }

        public double getRealAmount() {
            return realAmount;
        }

        public void setRealAmount(double realAmount) {
            this.realAmount = realAmount;
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

        public long getShiftEndTime() {
            return shiftEndTime;
        }

        public void setShiftEndTime(long shiftEndTime) {
            this.shiftEndTime = shiftEndTime;
        }

        public String getShiftId() {
            return shiftId;
        }

        public void setShiftId(String shiftId) {
            this.shiftId = shiftId;
        }

        public long getShiftStartTime() {
            return shiftStartTime;
        }

        public void setShiftStartTime(long shiftStartTime) {
            this.shiftStartTime = shiftStartTime;
        }
    }
}
