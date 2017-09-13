package com.iotek.merchantmanager.bean;

import java.util.List;

/**
 * Created by admin on 2017/9/13.
 */

public class LoginVO extends BaseBean {


    /**
     * obj : {"custId":38,"rootId":47,"uuid":"48142d28-722b-4a45-bef2-f665294054df"}
     * rows : [{"legalName":"小二","realName":"不二家","custNo":"888301054410001","custLname":"不二家零食店","custName":"不二家零食店","custCompanyName":"不二家糖果有限公司"}]
     * rspcod : 200
     * rspmsg : 登录成功
     */

    private ObjBean obj;
    private int rspcod;
    private String rspmsg;
    private List<RowsBean> rows;

    public ObjBean getObj() {
        return obj;
    }

    public void setObj(ObjBean obj) {
        this.obj = obj;
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

    public static class ObjBean {
        /**
         * custId : 38
         * rootId : 47
         * uuid : 48142d28-722b-4a45-bef2-f665294054df
         */

        private int custId;
        private int rootId;
        private String uuid;

        public int getCustId() {
            return custId;
        }

        public void setCustId(int custId) {
            this.custId = custId;
        }

        public int getRootId() {
            return rootId;
        }

        public void setRootId(int rootId) {
            this.rootId = rootId;
        }

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }
    }

    public static class RowsBean {
        /**
         * legalName : 小二
         * realName : 不二家
         * custNo : 888301054410001
         * custLname : 不二家零食店
         * custName : 不二家零食店
         * custCompanyName : 不二家糖果有限公司
         */

        private String legalName;
        private String realName;
        private String custNo;
        private String custLname;
        private String custName;
        private String custCompanyName;

        public String getLegalName() {
            return legalName;
        }

        public void setLegalName(String legalName) {
            this.legalName = legalName;
        }

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

        public String getCustNo() {
            return custNo;
        }

        public void setCustNo(String custNo) {
            this.custNo = custNo;
        }

        public String getCustLname() {
            return custLname;
        }

        public void setCustLname(String custLname) {
            this.custLname = custLname;
        }

        public String getCustName() {
            return custName;
        }

        public void setCustName(String custName) {
            this.custName = custName;
        }

        public String getCustCompanyName() {
            return custCompanyName;
        }

        public void setCustCompanyName(String custCompanyName) {
            this.custCompanyName = custCompanyName;
        }
    }
}
