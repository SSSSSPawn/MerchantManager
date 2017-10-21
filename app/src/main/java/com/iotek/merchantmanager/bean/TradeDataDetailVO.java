package com.iotek.merchantmanager.bean;

import java.util.List;

/**
 * Created by admin on 2017/10/21.
 */

public class TradeDataDetailVO extends BaseBean {


    /**
     * page : 1
     * records : 3
     * rows : [{"cashier":"13605154259","custId":21,"custPname":"亚青","custPphone":"13605154259","custStatus":"1","deviceType":2,"erpSaleDetails":[{"goodsAmount":1,"goodsId":"2121150423196605044570","goodsName":"合生元奶粉","goodsNum":1,"goodsPrice":1,"goodsStandard":"500g","goodsUnit":"罐","uid":"cde9b714-a864-4ccf-b529-c5bef0274740"}],"flagDiscount":0,"invStatus":"0","membFlag":5,"myStatus":"1","orderId":"2017101917075800006022","orderType":1,"oriAmount":1,"payType1":0,"receiveAmount":1,"saleTime":1508404078864,"type1Amount":1,"typeName1":"现金"},{"cashier":"15952056387","custId":21,"custPname":"亚青","custPphone":"13605154259","custStatus":"1","deviceType":2,"erpSaleDetails":[{"goodsAmount":1,"goodsId":"212115040840681673611","goodsName":"榴莲酸奶","goodsNum":1,"goodsPrice":1,"goodsStandard":"150g","goodsUnit":"个","uid":"caa6af5e-4434-4808-abfb-852dec9e6041"}],"flagDiscount":0,"invStatus":"0","membFlag":5,"myStatus":"1","orderId":"2017101913574400006021","orderType":1,"oriAmount":1,"payType1":1,"receiveAmount":1,"saleTime":1508392667244,"type1Amount":1,"typeName1":"微信支付"},{"cashier":"15952056387","custId":21,"custPname":"亚青","custPphone":"13605154259","custStatus":"1","deviceType":2,"erpSaleDetails":[{"goodsAmount":1,"goodsId":"2121150423196605044570","goodsName":"合生元奶粉","goodsNum":1,"goodsPrice":1,"goodsStandard":"500g","goodsUnit":"罐","uid":"711ae38f-9f4b-4f32-91cd-154ce2e48e8a"}],"flagDiscount":0,"invStatus":"0","membFlag":5,"myStatus":"1","orderId":"2017101910582500006016","orderType":1,"oriAmount":1,"payType1":1,"receiveAmount":1,"saleTime":1508381908095,"type1Amount":1,"typeName1":"微信支付"}]
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
         * erpSaleDetails : [{"goodsAmount":1,"goodsId":"2121150423196605044570","goodsName":"合生元奶粉","goodsNum":1,"goodsPrice":1,"goodsStandard":"500g","goodsUnit":"罐","uid":"cde9b714-a864-4ccf-b529-c5bef0274740"}]
         * flagDiscount : 0
         * invStatus : 0
         * membFlag : 5
         * myStatus : 1
         * orderId : 2017101917075800006022
         * orderType : 1
         * oriAmount : 1
         * payType1 : 0
         * receiveAmount : 1
         * saleTime : 1508404078864
         * type1Amount : 1
         * typeName1 : 现金
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
        private int payType1;
        private int receiveAmount;
        private long saleTime;
        private int type1Amount;
        private String typeName1;
        private List<ErpSaleDetailsBean> erpSaleDetails;

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

        public List<ErpSaleDetailsBean> getErpSaleDetails() {
            return erpSaleDetails;
        }

        public void setErpSaleDetails(List<ErpSaleDetailsBean> erpSaleDetails) {
            this.erpSaleDetails = erpSaleDetails;
        }

        public static class ErpSaleDetailsBean {
            /**
             * goodsAmount : 1
             * goodsId : 2121150423196605044570
             * goodsName : 合生元奶粉
             * goodsNum : 1
             * goodsPrice : 1
             * goodsStandard : 500g
             * goodsUnit : 罐
             * uid : cde9b714-a864-4ccf-b529-c5bef0274740
             */

            private int goodsAmount;
            private String goodsId;
            private String goodsName;
            private int goodsNum;
            private int goodsPrice;
            private String goodsStandard;
            private String goodsUnit;
            private String uid;

            public int getGoodsAmount() {
                return goodsAmount;
            }

            public void setGoodsAmount(int goodsAmount) {
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

            public int getGoodsPrice() {
                return goodsPrice;
            }

            public void setGoodsPrice(int goodsPrice) {
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

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }
        }
    }
}
