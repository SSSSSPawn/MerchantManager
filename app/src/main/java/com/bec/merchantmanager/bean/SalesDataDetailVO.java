package com.bec.merchantmanager.bean;

import java.util.List;

/**
 * Created by admin on 2017/10/23.
 */

public class SalesDataDetailVO extends BaseBean {


    /**
     * page : 1
     * records : 2
     * rows : [{"cashier":"13605154259","custId":21,"custPname":"亚青","custPphone":"13605154259","custStatus":"1","deviceType":2,"erpSaleDetails":[],"flagDiscount":0,"invStatus":"0","membFlag":5,"myStatus":"1","orderId":"2017102315414800006177","orderType":2,"oriAmount":100,"oriOrderId":"2017102315373100006175","payType1":1,"receiveAmount":100,"returnReason":"默认原因","saleTime":1508744255125,"type1Amount":100,"typeName1":"微信支付"},{"cashier":"13605154259","custId":21,"custPname":"亚青","custPphone":"13605154259","custStatus":"1","deviceType":2,"erpSaleDetails":[],"flagDiscount":0,"invCode":"032001500111","invNumber":"43507565","invStatus":"1","membFlag":5,"myStatus":"1","orderId":"2017102318005400006187","orderType":2,"oriAmount":1,"oriOrderId":"2017102315172900006174","payType1":2,"receiveAmount":1,"returnReason":"默认原因","saleTime":1508743051138,"type1Amount":1,"typeName1":"支付宝"}]
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
         * cashier : 13605154259
         * custId : 21
         * custPname : 亚青
         * custPphone : 13605154259
         * custStatus : 1
         * deviceType : 2
         * erpSaleDetails : []
         * flagDiscount : 0
         * invStatus : 0
         * membFlag : 5
         * myStatus : 1
         * orderId : 2017102315414800006177
         * orderType : 2
         * oriAmount : 100
         * oriOrderId : 2017102315373100006175
         * payType1 : 1
         * receiveAmount : 100
         * returnReason : 默认原因
         * saleTime : 1508744255125
         * type1Amount : 100
         * typeName1 : 微信支付
         * invCode : 032001500111
         * invNumber : 43507565
         */

        private String cashier;
        private int custId;
        private String custPname;
        private String custPphone;
        private String custStatus;
        private int deviceType;
        private int flagDiscount;
        private String invStatus;
        private int membFlag;
        private String myStatus;
        private String orderId;
        private int orderType;
        private int oriAmount;
        private String oriOrderId;
        private int payType1;
        private int receiveAmount;
        private String returnReason;
        private long saleTime;
        private int type1Amount;
        private String typeName1;
        private String invCode;
        private String invNumber;
        private List<?> erpSaleDetails;

        public String getCashier() {
            return cashier;
        }

        public void setCashier(String cashier) {
            this.cashier = cashier;
        }

        public int getCustId() {
            return custId;
        }

        public void setCustId(int custId) {
            this.custId = custId;
        }

        public String getCustPname() {
            return custPname;
        }

        public void setCustPname(String custPname) {
            this.custPname = custPname;
        }

        public String getCustPphone() {
            return custPphone;
        }

        public void setCustPphone(String custPphone) {
            this.custPphone = custPphone;
        }

        public String getCustStatus() {
            return custStatus;
        }

        public void setCustStatus(String custStatus) {
            this.custStatus = custStatus;
        }

        public int getDeviceType() {
            return deviceType;
        }

        public void setDeviceType(int deviceType) {
            this.deviceType = deviceType;
        }

        public int getFlagDiscount() {
            return flagDiscount;
        }

        public void setFlagDiscount(int flagDiscount) {
            this.flagDiscount = flagDiscount;
        }

        public String getInvStatus() {
            return invStatus;
        }

        public void setInvStatus(String invStatus) {
            this.invStatus = invStatus;
        }

        public int getMembFlag() {
            return membFlag;
        }

        public void setMembFlag(int membFlag) {
            this.membFlag = membFlag;
        }

        public String getMyStatus() {
            return myStatus;
        }

        public void setMyStatus(String myStatus) {
            this.myStatus = myStatus;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public int getOrderType() {
            return orderType;
        }

        public void setOrderType(int orderType) {
            this.orderType = orderType;
        }

        public int getOriAmount() {
            return oriAmount;
        }

        public void setOriAmount(int oriAmount) {
            this.oriAmount = oriAmount;
        }

        public String getOriOrderId() {
            return oriOrderId;
        }

        public void setOriOrderId(String oriOrderId) {
            this.oriOrderId = oriOrderId;
        }

        public int getPayType1() {
            return payType1;
        }

        public void setPayType1(int payType1) {
            this.payType1 = payType1;
        }

        public int getReceiveAmount() {
            return receiveAmount;
        }

        public void setReceiveAmount(int receiveAmount) {
            this.receiveAmount = receiveAmount;
        }

        public String getReturnReason() {
            return returnReason;
        }

        public void setReturnReason(String returnReason) {
            this.returnReason = returnReason;
        }

        public long getSaleTime() {
            return saleTime;
        }

        public void setSaleTime(long saleTime) {
            this.saleTime = saleTime;
        }

        public int getType1Amount() {
            return type1Amount;
        }

        public void setType1Amount(int type1Amount) {
            this.type1Amount = type1Amount;
        }

        public String getTypeName1() {
            return typeName1;
        }

        public void setTypeName1(String typeName1) {
            this.typeName1 = typeName1;
        }

        public String getInvCode() {
            return invCode;
        }

        public void setInvCode(String invCode) {
            this.invCode = invCode;
        }

        public String getInvNumber() {
            return invNumber;
        }

        public void setInvNumber(String invNumber) {
            this.invNumber = invNumber;
        }

        public List<?> getErpSaleDetails() {
            return erpSaleDetails;
        }

        public void setErpSaleDetails(List<?> erpSaleDetails) {
            this.erpSaleDetails = erpSaleDetails;
        }
    }
}
