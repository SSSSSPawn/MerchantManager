package com.bec.merchantmanager.bean.params;

import com.bec.merchantmanager.bean.BaseBean;

/**
 * Created by admin on 2017/11/8.
 */

public class AddVipDatumParamsVO extends BaseBean {

    private long custId;
    private long rootId;
    private String mac;
    private String uuid;

    private String membTel;
    private String membLevel;
    private String membName;
    private int pswFlag;
    private String password;
    private int gender;

    private String cardId;
    private String birthday;
    private String email;
    private String address;


    public AddVipDatumParamsVO(long custId, long rootId, String uuid, String mac, String membTel, String membLevel,
                               String membName, int pswFlag, String password, int gender) {
        this.custId = custId;
        this.rootId = rootId;
        this.uuid = uuid;
        this.mac = mac;
        this.membTel = membTel;
        this.membLevel = membLevel;
        this.membName = membName;
        this.pswFlag = pswFlag;
        this.password = password;
        this.gender = gender;
    }

    public AddVipDatumParamsVO(long custId, long rootId, String uuid, String mac, String membTel, String membLevel,
                               String membName, int pswFlag, int gender) {
        this.custId = custId;
        this.rootId = rootId;
        this.uuid = uuid;
        this.mac = mac;
        this.membTel = membTel;
        this.membLevel = membLevel;
        this.membName = membName;
        this.pswFlag = pswFlag;
        this.gender = gender;
    }

    public AddVipDatumParamsVO(long custId, long rootId, String uuid, String mac, String membTel, String membLevel,
                               String membName, int gender) {
        this.custId = custId;
        this.rootId = rootId;
        this.uuid = uuid;
        this.mac = mac;
        this.membTel = membTel;
        this.membLevel = membLevel;
        this.membName = membName;
        this.gender = gender;
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

    public String getMembTel() {
        return membTel;
    }

    public void setMembTel(String membTel) {
        this.membTel = membTel;
    }

    public String getMembLevel() {
        return membLevel;
    }

    public void setMembLevel(String membLevel) {
        this.membLevel = membLevel;
    }

    public String getMembName() {
        return membName;
    }

    public void setMembName(String membName) {
        this.membName = membName;
    }

    public int getPswFlag() {
        return pswFlag;
    }

    public void setPswFlag(int pswFlag) {
        this.pswFlag = pswFlag;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
