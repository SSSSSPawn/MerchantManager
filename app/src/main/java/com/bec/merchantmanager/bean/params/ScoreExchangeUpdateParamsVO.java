package com.bec.merchantmanager.bean.params;

import com.bec.merchantmanager.bean.BaseBean;

/**
 * Created by admin on 2017/11/14.
 */

public class ScoreExchangeUpdateParamsVO extends BaseBean {

    private long custId;
    private long rootId;
    private String uuid;
    private String uid;
    private String mac;
    private String ruleNum;
    private int scoreNum;
    private int exchangeMode;
    private String goodsId;
    private double voucher;
    private String sTime;
    private String eTime;


    public ScoreExchangeUpdateParamsVO(long custId, long rootId, String uuid,String uid, String mac,
                                       String ruleNum, int scoreNum, int exchangeMode, String goodsId, String sTime, String eTime) {
        this.custId = custId;
        this.rootId = rootId;
        this.uuid = uuid;
        this.mac = mac;
        this.ruleNum = ruleNum;
        this.scoreNum = scoreNum;
        this.exchangeMode = exchangeMode;
        this.goodsId = goodsId;
        this.sTime = sTime;
        this.eTime = eTime;
        this.uid = uid;
    }

    public ScoreExchangeUpdateParamsVO(long custId, long rootId, String uuid,String uid, String mac,
                                       String ruleNum, int scoreNum, int exchangeMode, double voucher, String sTime, String eTime) {
        this.custId = custId;
        this.rootId = rootId;
        this.uuid = uuid;
        this.mac = mac;
        this.ruleNum = ruleNum;
        this.scoreNum = scoreNum;
        this.exchangeMode = exchangeMode;
        this.voucher = voucher;
        this.sTime = sTime;
        this.eTime = eTime;
        this.uid = uid;
    }

    public ScoreExchangeUpdateParamsVO(long custId, long rootId, String uuid, String mac,String uid, String ruleNum,
                                       int scoreNum, int exchangeMode, String goodsId, double voucher, String sTime, String eTime) {
        this.custId = custId;
        this.rootId = rootId;
        this.uuid = uuid;
        this.mac = mac;
        this.ruleNum = ruleNum;
        this.scoreNum = scoreNum;
        this.exchangeMode = exchangeMode;
        this.goodsId = goodsId;
        this.voucher = voucher;
        this.sTime = sTime;
        this.eTime = eTime;
        this.uid = uid;
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

    public String getRuleNum() {
        return ruleNum;
    }

    public void setRuleNum(String ruleNum) {
        this.ruleNum = ruleNum;
    }

    public int getScoreNum() {
        return scoreNum;
    }

    public void setScoreNum(int scoreNum) {
        this.scoreNum = scoreNum;
    }

    public int getExchangeMode() {
        return exchangeMode;
    }

    public void setExchangeMode(int exchangeMode) {
        this.exchangeMode = exchangeMode;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public double getVoucher() {
        return voucher;
    }

    public void setVoucher(double voucher) {
        this.voucher = voucher;
    }

    public String getsTime() {
        return sTime;
    }

    public void setsTime(String sTime) {
        this.sTime = sTime;
    }

    public String geteTime() {
        return eTime;
    }

    public void seteTime(String eTime) {
        this.eTime = eTime;
    }

    @Override
    public String toString() {
        return "ScoreExchangeAddParamsVO{" +
                "custId=" + custId +
                ", rootId=" + rootId +
                ", uuid='" + uuid + '\'' +
                ", mac='" + mac + '\'' +
                ", ruleNum='" + ruleNum + '\'' +
                ", scoreNum=" + scoreNum +
                ", exchangeMode=" + exchangeMode +
                ", goodsId='" + goodsId + '\'' +
                ", voucher=" + voucher +
                ", sTime='" + sTime + '\'' +
                ", eTime='" + eTime + '\'' +
                '}';
    }
}
