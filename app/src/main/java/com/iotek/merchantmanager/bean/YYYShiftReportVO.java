package com.iotek.merchantmanager.bean;

import java.util.List;

/**
 * Created by admin on 2017/11/3.
 */

public class YYYShiftReportVO extends BaseBean {


    /**
     * page : 1
     * rows : [{"custId":21,"custName":"亚青","operName":"13605154259","realAmount":4.241502603E8,"returnAmount":27240473,"returnCount":396,"saleAmount":2.135946853E8,"saleCount":1294},{"custId":21,"custName":"亚青","operName":"13814689521","realAmount":1534896.64,"returnAmount":15546.14,"returnCount":141,"saleAmount":1609524.64,"saleCount":568},{"custId":21,"custName":"亚青","operName":"13951982893","realAmount":228053,"returnAmount":14191,"returnCount":20,"saleAmount":228053,"saleCount":62},{"custId":21,"custName":"亚青","operName":"15005199784","realAmount":100804,"returnAmount":395,"returnCount":28,"saleAmount":101464,"saleCount":71},{"custId":21,"custName":"亚青","operName":"15952056387","realAmount":34600.31,"returnAmount":1515.71,"returnCount":8,"saleAmount":15381.31,"saleCount":43},{"custId":21,"custName":"亚青","operName":"15996244906","realAmount":1113215208,"returnAmount":113482,"returnCount":68,"saleAmount":1026718,"saleCount":357},{"custId":21,"custName":"亚青","operName":"18013916711","realAmount":700,"returnAmount":350,"returnCount":1,"saleAmount":700,"saleCount":2},{"custId":21,"custName":"亚青","operName":"18751583966","realAmount":3.560453999E8,"returnAmount":3578969,"returnCount":69,"saleAmount":355060975,"saleCount":426},{"custId":21,"custName":"亚青","operName":"用户","realAmount":800,"returnAmount":0,"returnCount":0,"saleAmount":800,"saleCount":1}]
     * rspcod : 200
     * rspmsg : 成功
     */

    private int page;
    private int rspcod;
    private String rspmsg;
    private List<RowsBean> rows;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRspcod() {
        return rspcod;
    }

    public void setRspcod(int rspcod) {
        this.rspcod = rspcod;
    }

    public String getRspmsg() {
        return rspmsg;
    }

    public void setRspmsg(String rspmsg) {
        this.rspmsg = rspmsg;
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
         * custName : 亚青
         * operName : 13605154259
         * realAmount : 4.241502603E8
         * returnAmount : 27240473
         * returnCount : 396
         * saleAmount : 2.135946853E8
         * saleCount : 1294
         */

        private int custId;
        private String custName;
        private String operName;
        private double realAmount;
        private double returnAmount;
        private int returnCount;
        private double saleAmount;
        private int saleCount;

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
    }
}
