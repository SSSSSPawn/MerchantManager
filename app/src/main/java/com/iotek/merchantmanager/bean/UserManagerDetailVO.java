package com.iotek.merchantmanager.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by admin on 2017/8/28.
 */

public class UserManagerDetailVO extends BaseBean{


    /**
     * page : 1
     * records : 8
     * rows : [{"custId":21,"custName":"亚青","custPhone":"13605154259","lastLoginIp":"121.237.61.160","lastLoginTime":1505705467756,"loginIp":"121.237.61.160","loginTime":1505705542119,"mystatus":1,"realName":"朱国治","recordTime":1497943876211,"roleId":7,"rolePname":"商户管理员","sysId":3,"userId":35,"userIdentity":"332526197709220039","userName":"13605154259","userStatus":1},{"custId":21,"custName":"亚青","custPhone":"13605154259","lastLoginIp":"121.237.60.121","lastLoginTime":1504147582162,"loginIp":"121.237.60.121","loginTime":1504178499712,"mystatus":1,"realName":"史志强","recordTime":1498121599450,"roleId":8,"rolePname":"商户操作员","sysId":3,"userId":45,"userIdentity":"320104197811290821","userName":"15005199784","userStatus":1},{"custId":21,"custName":"亚青","custPhone":"13605154259","lastLoginIp":"180.111.233.172","lastLoginTime":1502357613199,"loginIp":"222.95.164.114","loginTime":1502873308791,"mystatus":1,"realName":"张志明","recordTime":1498131911159,"roleId":8,"rolePname":"商户操作员","sysId":3,"userId":46,"userIdentity":"32082619950815053x","userName":"18751583966","userStatus":1},{"custId":21,"custName":"亚青","custPhone":"13605154259","lastLoginIp":"117.136.66.134","lastLoginTime":1505439851144,"loginIp":"117.136.66.134","loginTime":1505442162537,"mystatus":1,"realName":"胡骏","recordTime":1499825654464,"roleId":7,"rolePname":"商户管理员","sysId":3,"userId":47,"userIdentity":"320105197908081431","userName":"13951982893","userStatus":1},{"custId":21,"custName":"亚青","custPhone":"13605154259","lastLoginIp":"121.237.61.160","lastLoginTime":1505720688769,"loginIp":"121.237.61.160","loginTime":1505720810269,"mystatus":1,"realName":"张月仙","recordTime":1504163353038,"roleId":7,"rolePname":"商户管理员","sysId":3,"userId":83,"userIdentity":"320589636987541210","userName":"13814689521","userStatus":1},{"custId":21,"custName":"亚青","custPhone":"13605154259","lastLoginIp":"121.237.62.241","lastLoginTime":1504229793096,"loginIp":"121.237.62.241","loginTime":1504230412411,"mystatus":1,"realName":"测试号","recordTime":1504228821218,"roleId":7,"rolePname":"商户管理员","sysId":3,"userId":84,"userIdentity":"320596321236987412","userName":"13814689000","userStatus":1},{"custId":21,"custName":"亚青","custPhone":"13605154259","lastLoginIp":"117.136.45.148","lastLoginTime":1505556396787,"loginIp":"117.136.45.148","loginTime":1505556453324,"mystatus":1,"realName":"秦德灏","recordTime":1505109645536,"roleId":7,"rolePname":"商户管理员","sysId":3,"userId":109,"userIdentity":"320721199609263616","userName":"15952056387","userStatus":1},{"custId":21,"custName":"亚青","custPhone":"13605154259","lastLoginIp":"121.237.61.160","lastLoginTime":1505720498112,"loginIp":"121.237.61.160","loginTime":1505720574339,"mystatus":1,"realName":"李卓鹏","recordTime":1505183232204,"roleId":7,"rolePname":"商户管理员","sysId":3,"userId":114,"userIdentity":"321322199411202637","userName":"15996244906","userStatus":1}]
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

    public static class RowsBean implements Serializable{
        /**
         * custId : 21
         * custName : 亚青
         * custPhone : 13605154259
         * lastLoginIp : 121.237.61.160
         * lastLoginTime : 1505705467756
         * loginIp : 121.237.61.160
         * loginTime : 1505705542119
         * mystatus : 1
         * realName : 朱国治
         * recordTime : 1497943876211
         * roleId : 7
         * rolePname : 商户管理员
         * sysId : 3
         * userId : 35
         * userIdentity : 332526197709220039
         * userName : 13605154259
         * userStatus : 1
         */

        private int custId;
        private String custName;
        private String custPhone;
        private String lastLoginIp;
        private long lastLoginTime;
        private String loginIp;
        private long loginTime;
        private String mystatus;
        private String realName;
        private long recordTime;
        private int roleId;
        private String rolePname;
        private int sysId;
        private int userId;
        private String userIdentity;
        private String userName;
        private int userStatus;

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

        public String getCustPhone() {
            return custPhone;
        }

        public void setCustPhone(String custPhone) {
            this.custPhone = custPhone;
        }

        public String getLastLoginIp() {
            return lastLoginIp;
        }

        public void setLastLoginIp(String lastLoginIp) {
            this.lastLoginIp = lastLoginIp;
        }

        public long getLastLoginTime() {
            return lastLoginTime;
        }

        public void setLastLoginTime(long lastLoginTime) {
            this.lastLoginTime = lastLoginTime;
        }

        public String getLoginIp() {
            return loginIp;
        }

        public void setLoginIp(String loginIp) {
            this.loginIp = loginIp;
        }

        public long getLoginTime() {
            return loginTime;
        }

        public void setLoginTime(long loginTime) {
            this.loginTime = loginTime;
        }

        public String getMystatus() {
            return mystatus;
        }

        public void setMystatus(String mystatus) {
            this.mystatus = mystatus;
        }

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

        public long getRecordTime() {
            return recordTime;
        }

        public void setRecordTime(long recordTime) {
            this.recordTime = recordTime;
        }

        public int getRoleId() {
            return roleId;
        }

        public void setRoleId(int roleId) {
            this.roleId = roleId;
        }

        public String getRolePname() {
            return rolePname;
        }

        public void setRolePname(String rolePname) {
            this.rolePname = rolePname;
        }

        public int getSysId() {
            return sysId;
        }

        public void setSysId(int sysId) {
            this.sysId = sysId;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getUserIdentity() {
            return userIdentity;
        }

        public void setUserIdentity(String userIdentity) {
            this.userIdentity = userIdentity;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getUserStatus() {
            return userStatus;
        }

        public void setUserStatus(int userStatus) {
            this.userStatus = userStatus;
        }

        @Override
        public String toString() {
            return "RowsBean{" +
                    "custId=" + custId +
                    ", custName='" + custName + '\'' +
                    ", custPhone='" + custPhone + '\'' +
                    ", lastLoginIp='" + lastLoginIp + '\'' +
                    ", lastLoginTime=" + lastLoginTime +
                    ", loginIp='" + loginIp + '\'' +
                    ", loginTime=" + loginTime +
                    ", mystatus=" + mystatus +
                    ", realName='" + realName + '\'' +
                    ", recordTime=" + recordTime +
                    ", roleId=" + roleId +
                    ", rolePname='" + rolePname + '\'' +
                    ", sysId=" + sysId +
                    ", userId=" + userId +
                    ", userIdentity='" + userIdentity + '\'' +
                    ", userName='" + userName + '\'' +
                    ", userStatus=" + userStatus +
                    '}';
        }
    }


    @Override
    public String toString() {
        return "UserManagerDetailVO{" +
                "page=" + page +
                ", records=" + records +
                ", total=" + total +
                ", rows=" + rows +
                '}';
    }
}
