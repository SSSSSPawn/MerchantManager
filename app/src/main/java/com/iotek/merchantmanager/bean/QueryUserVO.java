package com.iotek.merchantmanager.bean;

/**
 * Created by Administrator on 2017/9/21.
 */

public class QueryUserVO {
    
    private long custId;
    private long rootId;
    private String uuID;
    private String mac;
    private int userID;

    public QueryUserVO(long custId, long rootId, String uuID, String mac, int userID) {
        this.custId = custId;
        this.rootId = rootId;
        this.uuID = uuID;
        this.mac = mac;
        this.userID = userID;
    }

    public int getUserID() {
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
}
