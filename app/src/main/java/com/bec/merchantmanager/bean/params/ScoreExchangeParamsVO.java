package com.bec.merchantmanager.bean.params;

import com.bec.merchantmanager.bean.BaseBean;

/**
 * Created by admin on 2017/11/13.
 */

public class ScoreExchangeParamsVO extends BaseBean {

    private long custId;
    private long rootId;
    private String mac;
    private String uuid;
    private int limit;
    private int page;


    public ScoreExchangeParamsVO(long custId, long rootId, String mac, String uuid, int limit, int page) {
        this.custId = custId;
        this.rootId = rootId;
        this.mac = mac;
        this.uuid = uuid;
        this.limit = limit;
        this.page = page;
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
