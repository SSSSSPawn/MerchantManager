package com.bec.merchantmanager.bean;

import java.util.List;

/**
 * Created by admin on 2017/11/16.
 */

public class ScoreUseQueryVO extends BaseBean {


    /**
     * page : 1
     * records : 10
     * rows : [{"curScore":3137,"custCompanyName":"南京亚青体育产业发展有限公司","custId":21,"exchangeMode":1,"goodsId":"相册","membName":"豆子","membTel":"13814689521","oldScore":4137,"operName":"朱国治","recordTime":1503571039228,"ruleNum":1001,"scoreNum":1000,"useFlag":0,"useId":"2120170824100031"},{"curScore":500,"custCompanyName":"南京亚青体育产业发展有限公司","custId":21,"exchangeMode":1,"goodsId":"毛绒娃娃","membName":"豆子","membTel":"13814689521","oldScore":1000,"operName":"朱国治","recordTime":1503646464121,"ruleNum":1002,"scoreNum":500,"useFlag":0,"useId":"2120170825100032"},{"curScore":803,"custCompanyName":"南京亚青体育产业发展有限公司","custId":21,"exchangeMode":1,"goodsId":"相册","membName":"豆子","membTel":"13814689521","oldScore":1803,"operName":"朱国治","recordTime":1503651879380,"ruleNum":1001,"scoreNum":1000,"useFlag":0,"useId":"2120170825100033"},{"curScore":2197,"custCompanyName":"南京亚青体育产业发展有限公司","custId":21,"exchangeMode":1,"goodsId":"相册","membName":"豆子","membTel":"13814689521","oldScore":3197,"operName":"朱国治","recordTime":1503912871764,"ruleNum":1001,"scoreNum":1000,"useFlag":0,"useId":"2120170828100035"},{"curScore":600,"custCompanyName":"南京亚青体育产业发展有限公司","custId":21,"exchangeMode":1,"goodsId":"毛绒娃娃","membName":"司涛","membTel":"15862957096","oldScore":1100,"operName":"朱国治","recordTime":1504148612273,"ruleNum":1002,"scoreNum":500,"useFlag":0,"useId":"2120170831100068"},{"curScore":2121,"custCompanyName":"南京亚青体育产业发展有限公司","custId":21,"exchangeMode":1,"goodsId":"铅笔","membName":"李卓鹏","membTel":"15996244906","oldScore":2321,"operName":"李卓鹏","recordTime":1504577182489,"ruleNum":1003,"scoreNum":200,"useFlag":0,"useId":"2120170905100069"},{"curScore":1921,"custCompanyName":"南京亚青体育产业发展有限公司","custId":21,"exchangeMode":1,"goodsId":"铅笔","membName":"李卓鹏","membTel":"15996244906","oldScore":2121,"operName":"李卓鹏","recordTime":1504577189419,"ruleNum":1003,"scoreNum":200,"useFlag":0,"useId":"2120170905100070"},{"curScore":100,"custCompanyName":"南京亚青体育产业发展有限公司","custId":21,"exchangeMode":1,"goodsId":"毛绒娃娃","membName":"豆子","membTel":"13814689521","oldScore":600,"operName":"张月仙","recordTime":1504594326446,"ruleNum":1002,"scoreNum":500,"useFlag":0,"useId":"2120170905100071"},{"curScore":976,"custCompanyName":"南京亚青体育产业发展有限公司","custId":21,"exchangeMode":1,"goodsId":"铅笔","membName":"shwan","membTel":"15298369684","oldScore":1176,"operName":"朱国治","recordTime":1505182060616,"ruleNum":1003,"scoreNum":200,"useFlag":0,"useId":"2120170912100072"},{"curScore":1776,"custCompanyName":"南京亚青体育产业发展有限公司","custId":21,"exchangeMode":1,"goodsId":"铅笔","membName":"shwan","membTel":"15298369684","oldScore":1976,"operName":"朱国治","recordTime":1505182817347,"ruleNum":1003,"scoreNum":200,"useFlag":0,"useId":"2120170912100073"}]
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
         * curScore : 3137
         * custCompanyName : 南京亚青体育产业发展有限公司
         * custId : 21
         * exchangeMode : 1
         * goodsId : 相册
         * membName : 豆子
         * membTel : 13814689521
         * oldScore : 4137
         * operName : 朱国治
         * recordTime : 1503571039228
         * ruleNum : 1001
         * scoreNum : 1000
         * useFlag : 0
         * useId : 2120170824100031
         */

        private int curScore;
        private String custCompanyName;
        private int custId;
        private int exchangeMode;
        private String goodsId;
        private String membName;
        private String membTel;
        private int oldScore;
        private String operName;
        private long recordTime;
        private int ruleNum;
        private int scoreNum;
        private int useFlag;
        private String useId;
        private double voucher;

        public double getVoucher() {
            return voucher;
        }

        public void setVoucher(double voucher) {
            this.voucher = voucher;
        }

        public int getCurScore() {
            return curScore;
        }

        public void setCurScore(int curScore) {
            this.curScore = curScore;
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

        public int getOldScore() {
            return oldScore;
        }

        public void setOldScore(int oldScore) {
            this.oldScore = oldScore;
        }

        public String getOperName() {
            return operName;
        }

        public void setOperName(String operName) {
            this.operName = operName;
        }

        public long getRecordTime() {
            return recordTime;
        }

        public void setRecordTime(long recordTime) {
            this.recordTime = recordTime;
        }

        public int getRuleNum() {
            return ruleNum;
        }

        public void setRuleNum(int ruleNum) {
            this.ruleNum = ruleNum;
        }

        public int getScoreNum() {
            return scoreNum;
        }

        public void setScoreNum(int scoreNum) {
            this.scoreNum = scoreNum;
        }

        public int getUseFlag() {
            return useFlag;
        }

        public void setUseFlag(int useFlag) {
            this.useFlag = useFlag;
        }

        public String getUseId() {
            return useId;
        }

        public void setUseId(String useId) {
            this.useId = useId;
        }
    }
}
