package com.iotek.merchantmanager.bean.params;

import com.iotek.merchantmanager.bean.BaseBean;

/**
 * Created by admin on 2017/9/26.
 */

public class AddUserParamsVO extends BaseBean {
    private long custId;
    private long rootId;
    private String uuid;
    private String mac;
    private long userId;
    private  long roleId;
    private String userName;//用户名(手机号)
    private String realName;//姓名
    private String userIdentity;//身份证号码
    private String userPasswd;//用户密码

    public AddUserParamsVO() {
    }

    public AddUserParamsVO(long custId, long rootId, String uuid, String mac, long roleId, String userName, String realName, String userIdentity, String userPasswd) {
        this.custId = custId;
        this.rootId = rootId;
        this.uuid = uuid;
        this.mac = mac;
        this.roleId = roleId;
        this.userName = userName;
        this.realName = realName;
        this.userIdentity = userIdentity;
        this.userPasswd = userPasswd;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(String userIdentity) {
        this.userIdentity = userIdentity;
    }

    public String getUserPasswd() {
        return userPasswd;
    }

    public void setUserPasswd(String userPasswd) {
        this.userPasswd = userPasswd;
    }

    @Override
    public String toString() {
        return "AddUserParamsVO{" +
                "custId=" + custId +
                ", rootId=" + rootId +
                ", uuid='" + uuid + '\'' +
                ", mac='" + mac + '\'' +
                ", userId=" + userId +
                ", roleId=" + roleId +
                ", userName='" + userName + '\'' +
                ", realName='" + realName + '\'' +
                ", userIdentity='" + userIdentity + '\'' +
                ", userPasswd='" + userPasswd + '\'' +
                '}';
    }
}
