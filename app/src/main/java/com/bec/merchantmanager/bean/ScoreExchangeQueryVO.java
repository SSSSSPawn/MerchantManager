package com.bec.merchantmanager.bean;

import java.util.List;

/**
 * Created by admin on 2017/11/13.
 */

public class ScoreExchangeQueryVO extends BaseBean {


    /**
     * page : 1
     * records : 8
     * rows : [{"beginDate":1503504000000,"custCompanyName":"南京亚青体育产业发展有限公司","custId":21,"endDate":1533830400000,"exchangeMode":1,"goodsId":"相册","recordTime":1503570949571,"ruleNum":1001,"scoreNum":1000,"uid":"038f8322-3032-4b24-b9fe-a9d5900e58a0"},{"beginDate":1503504000000,"custCompanyName":"南京亚青体育产业发展有限公司","custId":21,"endDate":1510243200000,"exchangeMode":1,"goodsId":"毛绒娃娃","recordTime":1503570979038,"ruleNum":1002,"scoreNum":500,"uid":"ab8b7cd2-6c4e-4575-9a7a-2a54942000c5"},{"beginDate":1503504000000,"custCompanyName":"南京亚青体育产业发展有限公司","custId":21,"endDate":1505923200000,"exchangeMode":1,"goodsId":"铅笔","recordTime":1503570997815,"ruleNum":1003,"scoreNum":200,"uid":"3ee49d67-619b-471b-8d0b-def42b67d835"},{"beginDate":1504195200000,"custCompanyName":"南京亚青体育产业发展有限公司","custId":21,"endDate":1522425600000,"exchangeMode":2,"recordTime":1504232224399,"ruleNum":1004,"scoreNum":100,"uid":"bbbff717-208e-423a-8cd1-4400d9131dd1","voucher":5},{"beginDate":1505145600000,"custCompanyName":"南京亚青体育产业发展有限公司","custId":21,"endDate":1505750400000,"exchangeMode":1,"goodsId":"相册","recordTime":1505217334059,"ruleNum":1005,"scoreNum":200,"uid":"a208b428-2758-41c1-8152-f572f6936ee4"},{"beginDate":1509206400000,"custCompanyName":"南京亚青体育产业发展有限公司","custId":21,"endDate":1525017600000,"exchangeMode":2,"recordTime":1509326069691,"ruleNum":1006,"scoreNum":1000,"uid":"4c62e400-d43b-45c6-bbd4-0bc6e1aa9c37","voucher":1},{"beginDate":1509206400000,"custCompanyName":"南京亚青体育产业发展有限公司","custId":21,"endDate":1509379200000,"exchangeMode":2,"goodsId":"","recordTime":1509354720942,"ruleNum":121,"scoreNum":100,"uid":"e6e6f874-a938-46d0-833e-dc5923d3f9ae","voucher":22},{"beginDate":1511020800000,"custCompanyName":"南京亚青体育产业发展有限公司","custId":21,"endDate":1512144000000,"exchangeMode":2,"goodsId":"","recordTime":1509508604029,"ruleNum":1007,"scoreNum":100,"uid":"56c306cc-2877-4668-8955-dde44eeab09b","voucher":10}]
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
         * beginDate : 1503504000000
         * custCompanyName : 南京亚青体育产业发展有限公司
         * custId : 21
         * endDate : 1533830400000
         * exchangeMode : 1
         * goodsId : 相册
         * recordTime : 1503570949571
         * ruleNum : 1001
         * scoreNum : 1000
         * uid : 038f8322-3032-4b24-b9fe-a9d5900e58a0
         * voucher : 5
         */

        private long beginDate;
        private String custCompanyName;
        private int custId;
        private long endDate;
        private int exchangeMode;
        private String goodsId;
        private long recordTime;
        private String ruleNum;
        private int scoreNum;
        private String uid;
        private int voucher;

        public long getBeginDate() {
            return beginDate;
        }

        public void setBeginDate(long beginDate) {
            this.beginDate = beginDate;
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

        public long getEndDate() {
            return endDate;
        }

        public void setEndDate(long endDate) {
            this.endDate = endDate;
        }

        public int getExchangeMode() {
            return exchangeMode;
        }

        public void setExchangeMode(int exchangeMode) {
            this.exchangeMode = exchangeMode;
        }

        public String getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(String goodsId) {
            this.goodsId = goodsId;
        }

        public long getRecordTime() {
            return recordTime;
        }

        public void setRecordTime(long recordTime) {
            this.recordTime = recordTime;
        }

        public String getRuleNum() {
            return ruleNum;
        }

        public void setRuleNum(String ruleNum) {
            this.ruleNum = ruleNum;
        }

        public int getScoreNum() {
            return scoreNum;
        }

        public void setScoreNum(int scoreNum) {
            this.scoreNum = scoreNum;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public int getVoucher() {
            return voucher;
        }

        public void setVoucher(int voucher) {
            this.voucher = voucher;
        }
    }
}
