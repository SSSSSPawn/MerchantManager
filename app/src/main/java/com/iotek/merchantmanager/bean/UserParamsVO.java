package com.iotek.merchantmanager.bean;

/**
 * Created by Administrator on 2017/9/21.
 */

public class UserParamsVO extends BaseBean{
    
    private long custId;
    private long rootId;
    private String uuID;
    private String mac;
    private long userID;
    private  long roleId;

    public UserParamsVO(long custId, long rootId, String uuID, String mac, long userID) {
        this.custId = custId;
        this.rootId = rootId;
        this.uuID = uuID;
        this.mac = mac;
        this.userID = userID;
    }

    public UserParamsVO(long custId, long rootId, String uuID, String mac, long userID, long roleId) {
        this.custId = custId;
        this.rootId = rootId;
        this.uuID = uuID;
        this.mac = mac;
        this.userID = userID;
        this.roleId = roleId;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public long getCustId() {
        return custId;
    }

    public void setCustId(long custId) {
        this.custId = custId;
    }

    public long getRootId() {
        return rootId;
    }

    public void setRootId(long rootId) {
        this.rootId = rootId;
    }

    public String getUuID() {
        return uuID;
    }

    public void setUuID(String uuID) {
        this.uuID = uuID;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    @Override
    public String toString() {
        return "QueryUserVO{" +
                "custId=" + custId +
                ", rootId=" + rootId +
                ", uuID='" + uuID + '\'' +
                ", mac='" + mac + '\'' +
                ", userID=" + userID +
                ", roleId=" + roleId +
                '}';
    }
}
