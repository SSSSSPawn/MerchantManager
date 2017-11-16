package com.bec.merchantmanager.bean;

import java.util.List;

/**
 * Created by admin on 2017/11/16.
 */

public class MemberTimeVO extends BaseBean {


    /**
     * page : 1
     * records : 1
     * rows : [{"custCompanyName":"南京亚青体育产业发展有限公司","custId":21,"goodsId":"171110216368","goodsName":"中华牙膏","membName":"shwan","membTel":"15298369684","recordTime":1510730882924,"times":3,"uid":"5de9405f-6d69-462b-969f-2bfb698afd5e"}]
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
         * custCompanyName : 南京亚青体育产业发展有限公司
         * custId : 21
         * goodsId : 171110216368
         * goodsName : 中华牙膏
         * membName : shwan
         * membTel : 15298369684
         * recordTime : 1510730882924
         * times : 3
         * uid : 5de9405f-6d69-462b-969f-2bfb698afd5e
         */

        private String custCompanyName;
        private int custId;
        private String goodsId;
        private String goodsName;
        private String membName;
        private String membTel;
        private long recordTime;
        private int times;
        private String uid;

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

        public long getRecordTime() {
            return recordTime;
        }

        public void setRecordTime(long recordTime) {
            this.recordTime = recordTime;
        }

        public int getTimes() {
            return times;
        }

        public void setTimes(int times) {
            this.times = times;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }
    }
}
