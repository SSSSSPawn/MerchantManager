package com.iotek.merchantmanager.bean;

/**
 * Created by admin on 2017/9/1.
 */

public class UserManagerVO extends BaseBean{

    private String tv_number;
    private String tv_name;
    private String tv_role;


    public UserManagerVO(String tv_number, String tv_name, String tv_role) {
        this.tv_number = tv_number;
        this.tv_name = tv_name;
        this.tv_role = tv_role;
    }

    public String getTv_number() {
        return tv_number;
    }

    public void setTv_number(String tv_number) {
        this.tv_number = tv_number;
    }

    public String getTv_name() {
        return tv_name;
    }

    public void setTv_name(String tv_name) {
        this.tv_name = tv_name;
    }

    public String getTv_role() {
        return tv_role;
    }

    public void setTv_role(String tv_role) {
        this.tv_role = tv_role;
    }
}
