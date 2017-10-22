package com.iotek.merchantmanager.bean.params;

import com.iotek.merchantmanager.bean.BaseBean;

/**
 * Created by Administrator on 2017/10/22.
 */

public class SalesDataParamsVO extends BaseBean {

    private long custId;
    private long rootId;
    private String uuid;
    private String mac;
    private int limit;
    private int page;
    private int orderType;
    private String sTime;
    private String eTime;

    public SalesDataParamsVO(long custId, long rootId, String uuid, String mac, int limit, int page, int orderType, String sTime, String eTime) {
        this.custId = custId;
        this.rootId = rootId;
        this.uuid = uuid;
        this.mac = mac;
        this.limit = limit;
        this.page = page;
        this.orderType = orderType;
        this.sTime = sTime;
        this.eTime = eTime;
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

    public int getOrderType() {
        return orderType;
    }

    public void setOrderType(int orderType) {
        this.orderType = orderType;
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
}
