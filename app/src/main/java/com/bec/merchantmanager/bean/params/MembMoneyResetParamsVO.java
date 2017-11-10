package com.bec.merchantmanager.bean.params;

import com.bec.merchantmanager.bean.BaseBean;

/**
 * Created by admin on 2017/11/10.
 */

public class MembMoneyResetParamsVO extends BaseBean {

    private long custId;
    private long rootId;
    private String mac;
    private String uuid;
    private String uid;

    public MembMoneyResetParamsVO(long custId, long rootId, String mac, String uuid, String uid) {
        this.custId = custId;
        this.rootId = rootId;
        this.mac = mac;
        this.uuid = uuid;
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

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
