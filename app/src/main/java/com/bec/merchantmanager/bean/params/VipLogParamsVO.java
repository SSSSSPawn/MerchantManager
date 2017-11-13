package com.bec.merchantmanager.bean.params;

import com.bec.merchantmanager.bean.BaseBean;

/**
 * Created by admin on 2017/11/13.
 */

public class VipLogParamsVO extends BaseBean {

    private long custId;
    private long rootId;
    private String uuid;
    private String mac;
    private int limit;
    private int page;

    private String sTime;
    private String eTime;
    private int operType;

    public VipLogParamsVO(long custId, long rootId, String uuid, String mac, int limit, int page) {
        this.custId = custId;
        this.rootId = rootId;
        this.uuid = uuid;
        this.mac = mac;
        this.limit = limit;
        this.page = page;
    }

    public VipLogParamsVO(long custId, long rootId, String uuid, String mac, int limit, int page, String sTime, String eTime, int operType) {
        this.custId = custId;
        this.rootId = rootId;
        this.uuid = uuid;
        this.mac = mac;
        this.limit = limit;
        this.page = page;
        this.sTime = sTime;
        this.eTime = eTime;
        this.operType = operType;
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

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getsTime() {
        return sTime;
    }

    public void setsTime(String sTime) {
        this.sTime = sTime;
    }

    public String geteTime() {
        return eTime;
    }

    public void seteTime(String eTime) {
        this.eTime = eTime;
    }

    public int getOperType() {
        return operType;
    }

    public void setOperType(int operType) {
        this.operType = operType;
    }
}
