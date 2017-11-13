package com.bec.merchantmanager.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/11/12.
 */

public class VipLogVO extends BaseBean {


    /**
     * page : 1
     * records : 14
     * rows : [
     * {"balance":0,"custCompanyName":"南京亚青体育产业发展有限公司","custId":21,"membName":"石头","membTel":"13851423893","operBalance":0,"operName":"张月仙","operType":11,"recordTime":1510478629537,"uid":"1ac91c3c-f807-4bae-a665-f2afc2ccc6d2"},
     * {"custCompanyName":"南京亚青体育产业发展有限公司","custId":21,"membName":"茉莉","membTel":"13814679521","operBalance":22,"operName":"朱国治","operType":3,"orderId":"2017111015035000007889","payType":8,"prodName":"会员卡支付","recordTime":1510297430483,"uid":"269b298e-2580-454c-aab1-aab47c2ed50a"},
     * {"custCompanyName":"南京亚青体育产业发展有限公司","custId":21,"membName":"豆子","membTel":"13814689521","operName":"朱国治","operType":5,"recordTime":1510297085535,"uid":"e6864154-5b8c-46a3-abbc-cb9a2c914ba9"},
     * {"custCompanyName":"南京亚青体育产业发展有限公司","custId":21,"membName":"豆子","membTel":"13814689521","operName":"朱国治","operType":5,"recordTime":1510297073836,"uid":"29822cb8-9670-4f38-a85b-853daa1d6021"},
     * {"custCompanyName":"南京亚青体育产业发展有限公司","custId":21,"membName":"豆子","membTel":"13814689521","operName":"朱国治","operType":5,"recordTime":1510297061786,"uid":"1d698949-eeac-452f-a368-425a47221c52"},
     * {"custCompanyName":"南京亚青体育产业发展有限公司","custId":21,"membName":"豆子","membTel":"13814689521","operName":"朱国治","operType":5,"recordTime":1510297055477,"uid":"bd9800f2-04a9-4b15-9703-94f7f42dcbe4"},
     * {"custCompanyName":"南京亚青体育产业发展有限公司","custId":21,"membName":"豆子","membTel":"13814689521","operName":"朱国治","operType":5,"recordTime":1510297049136,"uid":"2bd91e06-212a-43a5-8b81-91aa9455d597"},
     * {"custCompanyName":"南京亚青体育产业发展有限公司","custId":21,"membName":"豆子","membTel":"13814689521","operName":"朱国治","operType":5,"recordTime":1510297040088,"uid":"8e8d722f-b932-45ea-8755-d851326fb50d"},
     * {"addBalance":0,"balance":1000,"custCompanyName":"南京亚青体育产业发展有限公司","custId":21,"membName":"豆子","membTel":"13814689521","operBalance":1000,"operName":"朱国治","operType":2,"payType":0,"prodName":"现金","recordTime":1510297012932,"uid":"d07daf70-77f1-41aa-a236-2a81dd3cd884"},
     * {"balance":1350,"custCompanyName":"南京亚青体育产业发展有限公司","custId":21,"membName":"豆子","membTel":"13814689521","operBalance":0,"operName":"bec","operType":11,"recordTime":1510296988694,"uid":"2445d7e1-0cd1-498c-8ebe-cbc729945933"},
     * {"addBalance":50,"balance":1350,"custCompanyName":"南京亚青体育产业发展有限公司","custId":21,"membName":"豆子","membTel":"13814689521","operBalance":0,"operName":"朱国治","operType":2,"payType":0,"prodName":"现金","recordTime":1510296103506,"uid":"bd79bd29-0ddb-451a-ba01-3e96d9598c7c"},{"custCompanyName":"南京亚青体育产业发展有限公司","custId":21,"goodsId":"2121150526412319172614","membName":"豆子","membTel":"13814689521","operBalance":1,"operName":"朱国治","operTimes":10,"operType":7,"payType":0,"prodName":"现金","recordTime":1510280429549,"uid":"488c73ca-0d22-45fb-813e-ef5a27407180"},{"custCompanyName":"南京亚青体育产业发展有限公司","custId":21,"goodsId":"2121150391115839329226","membName":"shwan","membTel":"15298369684","operName":"朱国治","operTimes":1,"operType":10,"orderId":"2017111010190700007814","payType":8,"prodName":"会员卡支付","recordTime":1510280417677,"uid":"bce65ff7-ee9a-4896-8313-c85a5d3f536a"},{"custCompanyName":"南京亚青体育产业发展有限公司","custId":21,"goodsId":"2121150467749130632923","membName":"shwan","membTel":"15298369684","operName":"朱国治","operTimes":1,"operType":10,"orderId":"2017111010190700007814","payType":8,"prodName":"会员卡支付","recordTime":1510280417674,"uid":"a89f51c1-c78d-40a0-8433-b7b20b4ece32"}]
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

    public static class RowsBean extends BaseBean{
        /**
         * balance : 0
         * custCompanyName : 南京亚青体育产业发展有限公司
         * custId : 21
         * membName : 石头
         * membTel : 13851423893
         * operBalance : 0
         * operName : 张月仙
         * operType : 11
         * recordTime : 1510478629537
         * uid : 1ac91c3c-f807-4bae-a665-f2afc2ccc6d2
         * orderId : 2017111015035000007889
         * payType : 8
         * prodName : 会员卡支付
         * addBalance : 0
         * goodsId : 2121150526412319172614
         * operTimes : 10
         */

        private double balance;
        private String custCompanyName;
        private int custId;
        private String membName;
        private String membTel;
        private double operBalance;
        private String operName;
        private int operType;
        private long recordTime;
        private String uid;
        private String orderId;
        private int payType;
        private String prodName;
        private double addBalance;
        private String goodsId;
        private int operTimes;

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        public String getCustCompanyName() {
            return custCompanyName;
        }

        public void setCustCompanyName(String custCompanyName) {
            this.custCompanyName = custCompanyName;
        }

        public int getCustId() {
            return custId;
        }

        public void setCustId(int custId) {
            this.custId = custId;
        }

        public String getMembName() {
            return membName;
        }

        public void setMembName(String membName) {
            this.membName = membName;
        }

        public String getMembTel() {
            return membTel;
        }

        public void setMembTel(String membTel) {
            this.membTel = membTel;
        }

        public double getOperBalance() {
            return operBalance;
        }

        public void setOperBalance(double operBalance) {
            this.operBalance = operBalance;
        }

        public String getOperName() {
            return operName;
        }

        public void setOperName(String operName) {
            this.operName = operName;
        }

        public int getOperType() {
            return operType;
        }

        public void setOperType(int operType) {
            this.operType = operType;
        }

        public long getRecordTime() {
            return recordTime;
        }

        public void setRecordTime(long recordTime) {
            this.recordTime = recordTime;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public int getPayType() {
            return payType;
        }

        public void setPayType(int payType) {
            this.payType = payType;
        }

        public String getProdName() {
            return prodName;
        }

        public void setProdName(String prodName) {
            this.prodName = prodName;
        }

        public double getAddBalance() {
            return addBalance;
        }

        public void setAddBalance(double addBalance) {
            this.addBalance = addBalance;
        }

        public String getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(String goodsId) {
            this.goodsId = goodsId;
        }

        public int getOperTimes() {
            return operTimes;
        }

        public void setOperTimes(int operTimes) {
            this.operTimes = operTimes;
        }
    }
}
