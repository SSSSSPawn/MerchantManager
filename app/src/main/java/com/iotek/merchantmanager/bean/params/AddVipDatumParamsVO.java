package com.iotek.merchantmanager.bean.params;

import com.iotek.merchantmanager.bean.BaseBean;

/**
 * Created by admin on 2017/11/8.
 */

public class AddVipDatumParamsVO extends BaseBean {

    private long custId;
    private long rootId;
    private String uuid;
    private String mac;

    private String membTel;
    private int membLevel;
    private String levelName;
    private int pswFlag;
    private String password;
    private int gender;

    private String birthday;
    private String Email;
    private String Address;

    public AddVipDatumParamsVO(long custId, long rootId, String uuid, String mac, String membTel, int membLevel, String levelName, int pswFlag, String password, int gender) {
        this.custId = custId;
        this.rootId = rootId;
        this.uuid = uuid;
        this.mac = mac;
        this.membTel = membTel;
        this.membLevel = membLevel;
        this.levelName = levelName;
        this.pswFlag = pswFlag;
        this.password = password;
        this.gender = gender;
    }

    public AddVipDatumParamsVO(long custId, long rootId, String uuid, String mac, String membTel, int membLevel, String levelName, int pswFlag, String password, int gender, String birthday, String email, String address) {
        this.custId = custId;
        this.rootId = rootId;
        this.uuid = uuid;
        this.mac = mac;
        this.membTel = membTel;
        this.membLevel = membLevel;
        this.levelName = levelName;
        this.pswFlag = pswFlag;
        this.password = password;
        this.gender = gender;
        this.birthday = birthday;
        Email = email;
        Address = address;
    }
}
