package com.iotek.merchantmanager.bean;

/**
 * Created by admin on 2017/10/12.
 */

public class TradeFormParamsVO extends BaseBean {

    private long custId;
    private long rootId;
    private String uuid;
    private String mac;
    private int limit;
    private int page;


    public TradeFormParamsVO(long custId, long rootId, String uuid, String mac, int limit, int page) {
        this.custId = custId;
        this.rootId = rootId;
        this.uuid = uuid;
        this.mac = mac;
        this.limit = limit;
        this.page = page;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
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
}
