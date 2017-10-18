package com.iotek.merchantmanager.bean.params;

import com.iotek.merchantmanager.bean.BaseBean;

/**
 * Created by admin on 2017/9/25.
 */

public class LoginParamsVO extends BaseBean {

    private String onsitetime;
    private String mac;
    private String userName;
    private String userPasswd;
    private String appversion;

    public LoginParamsVO(String onsiteTime, String mac, String userName, String userPassword, String appverSion) {
        this.onsitetime = onsiteTime;
        this.mac = mac;
        this.userName = userName;
        this.userPasswd = userPassword;
        this.appversion = appverSion;
    }

    public String getOnsitetime() {
        return onsitetime;
    }

    public void setOnsitetime(String onsitetime) {
        this.onsitetime = onsitetime;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPasswd() {
        return userPasswd;
    }

    public void setUserPasswd(String userPasswd) {
        this.userPasswd = userPasswd;
    }

    public String getAppversion() {
        return appversion;
    }

    public void setAppversion(String appversion) {
        this.appversion = appversion;
    }
}
