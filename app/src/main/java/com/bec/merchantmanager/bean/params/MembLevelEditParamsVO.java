package com.bec.merchantmanager.bean.params;

import com.bec.merchantmanager.bean.BaseBean;

/**
 * Created by admin on 2017/11/7.
 */

public class MembLevelEditParamsVO extends BaseBean {

    private long custId;
    private long rootId;
    private String uuid;
    private String mac;
    private int membLevel;
    private String levelName;
    private String discount;
    private String uid;

    public MembLevelEditParamsVO(long custId, long rootId, String uuid, String mac, int membLevel, String levelName, String discount, String uid) {
        this.custId = custId;
        this.rootId = rootId;
        this.uuid = uuid;
        this.mac = mac;
        this.membLevel = membLevel;
        this.levelName = levelName;
        this.discount = discount;
        this.uid = uid;
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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public int getMembLevel() {
        return membLevel;
    }

    public void setMembLevel(int membLevel) {
        this.membLevel = membLevel;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
