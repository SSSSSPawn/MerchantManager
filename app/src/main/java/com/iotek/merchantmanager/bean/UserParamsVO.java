package com.iotek.merchantmanager.bean;

/**
 * Created by Administrator on 2017/9/21.
 */

public class UserParamsVO extends BaseBean{
    
    private long custId;
    private long rootId;
    private String uuid;
    private String mac;
    private long userId;
    private  long roleId;

    public UserParamsVO(long custId, long rootId, String uuid, String mac, long userId) {
        this.custId = custId;
        this.rootId = rootId;
        this.uuid = uuid;
        this.mac = mac;
        this.userId = userId;
    }

    public UserParamsVO(long custId, long rootId, String uuid, String mac, long userId, long roleId) {
        this.custId = custId;
        this.rootId = rootId;
        this.uuid = uuid;
        this.mac = mac;
        this.userId = userId;
        this.roleId = roleId;
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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }
}
