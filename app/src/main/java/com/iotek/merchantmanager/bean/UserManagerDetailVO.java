package com.iotek.merchantmanager.bean;

/**
 * Created by admin on 2017/8/28.
 */

public class UserManagerDetailVO extends BaseBean{

    private String mTvCode;
    private String mTvCustomName;
    private String mTvFoundTime;
    private String mTvLastLoginIp;
    private String mTvLoginIp;
    private String mTvName;
    private String mTvStatus;
    private String mTvRole;

    public UserManagerDetailVO(String tvCode, String tvCustomName, String tvFoundTime, String tvLastLoginIp, String tvLoginIp, String tvName, String tvStatus, String tvRole) {
        mTvCode = tvCode;
        mTvCustomName = tvCustomName;
        mTvFoundTime = tvFoundTime;
        mTvLastLoginIp = tvLastLoginIp;
        mTvLoginIp = tvLoginIp;
        mTvName = tvName;
        mTvStatus = tvStatus;
        mTvRole = tvRole;
    }

    public String getTvCode() {
        return mTvCode;
    }

    public void setTvCode(String tvCode) {
        mTvCode = tvCode;
    }

    public String getTvCustomName() {
        return mTvCustomName;
    }

    public void setTvCustomName(String tvCustomName) {
        mTvCustomName = tvCustomName;
    }

    public String getTvFoundTime() {
        return mTvFoundTime;
    }

    public void setTvFoundTime(String tvFoundTime) {
        mTvFoundTime = tvFoundTime;
    }

    public String getTvLastLoginIp() {
        return mTvLastLoginIp;
    }

    public void setTvLastLoginIp(String tvLastLoginIp) {
        mTvLastLoginIp = tvLastLoginIp;
    }

    public String getTvLoginIp() {
        return mTvLoginIp;
    }

    public void setTvLoginIp(String tvLoginIp) {
        mTvLoginIp = tvLoginIp;
    }

    public String getTvName() {
        return mTvName;
    }

    public void setTvName(String tvName) {
        mTvName = tvName;
    }

    public String getTvStatus() {
        return mTvStatus;
    }

    public void setTvStatus(String tvStatus) {
        mTvStatus = tvStatus;
    }

    public String getTvRole() {
        return mTvRole;
    }

    public void setTvRole(String tvRole) {
        mTvRole = tvRole;
    }

}
