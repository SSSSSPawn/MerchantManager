package com.bec.merchantmanager.bean;

import java.util.List;

/**
 * Created by admin on 2017/11/4.
 */

public class QueryMembLevelVO extends BaseBean {


    /**
     * page : 1
     * records : 4
     * rows : [{"custCompanyName":"南京亚青体育产业发展有限公司","custId":21,"discount":"50","levelName":"一级","membLevel":1,"recordTime":1503541202324,"uid":"631f7edd-0a01-4c5b-b692-043150e05854"},{"custCompanyName":"南京亚青体育产业发展有限公司","custId":21,"discount":"60","levelName":"二级","membLevel":2,"recordTime":1503541211266,"uid":"1ec22612-31cd-4515-9d7a-5535506f333e"},{"custCompanyName":"南京亚青体育产业发展有限公司","custId":21,"discount":"75","levelName":"三级","membLevel":3,"recordTime":1503541219990,"uid":"d279f320-b68a-4b4f-bf63-562a799cd087"},{"custCompanyName":"南京亚青体育产业发展有限公司","custId":21,"discount":"81","levelName":"四级","membLevel":4,"recordTime":1503541231502,"uid":"69487e83-3f47-4022-976f-b73412b95375"}]
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
         * discount : 50
         * levelName : 一级
         * membLevel : 1
         * recordTime : 1503541202324
         * uid : 631f7edd-0a01-4c5b-b692-043150e05854
         */

        private String custCompanyName;
        private int custId;
        private String discount;
        private String levelName;
        private int membLevel;
        private long recordTime;
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

        public String getDiscount() {
            return discount;
        }

        public void setDiscount(String discount) {
            this.discount = discount;
        }

        public String getLevelName() {
            return levelName;
        }

        public void setLevelName(String levelName) {
            this.levelName = levelName;
        }

        public int getMembLevel() {
            return membLevel;
        }

        public void setMembLevel(int membLevel) {
            this.membLevel = membLevel;
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
    }
}
