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
    private int membLevel;
    private String membName;
    private int pswFlag;
    private String password;
    private int gender;

    private String cardId;
    private String birthday;
    private String Email;
    private String Address;


    public AddVipDatumParamsVO(long custId, long rootId, String uuid, String mac, String membTel, int membLevel,
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

    public AddVipDatumParamsVO(long custId, long rootId, String uuid, String mac, String membTel, int membLevel,
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

    @Override
    public String toString() {
        return "AddVipDatumParamsVO{" +
                "custId=" + custId +
                ", rootId=" + rootId +
                ", uuid='" + uuid + '\'' +
                ", mac='" + mac + '\'' +
                ", membTel='" + membTel + '\'' +
                ", membLevel=" + membLevel +
                ", levelName='" + membName + '\'' +
                ", pswFlag=" + pswFlag +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                '}';
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

    public int getMembLevel() {
        return membLevel;
    }

    public void setMembLevel(int membLevel) {
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
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
