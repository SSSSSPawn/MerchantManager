package com.bec.merchantmanager.bean;

/**
 * Created by admin on 2017/10/17.
 */

public class BBCBankVO extends BaseBean {


    /**
     * obj : https://rmb-stg.pingan.com.cn/brcp/uc/cust/uc-third-auth.autoLogin.do?mchId=B170900701&encryptData=0752b38f74714f0eeec90266f957b087ba24b7cb34cae6bbd2357ee4acfe8e2c43c8206dbcd93f3ab17cc139077ffa8623cd5336cfaf1105f9c883bccbb798b6a5aaf0db75abb1ac623c2ab9e0199e6bc340218a27cbfed27d45b1bd7e74db084e078a92975be6f7f1a966c9e54ca3b212545db4789640912f0ae09b6212bf22253d207d053c7f6d755b2caf578972fcd9796ae30a91f4e650ae40949272cdd0e71000ab925eda6ffe4738b234af8ce5befd7f2dd8051a84e37bd0769c19ba36994aa690d707f3571509111bc5dcfee658948f438fd6b31a6da8a0e98a90756200f417339ef536061a67ef32a4a899ea97d92f13e62ec664133d1e620ef360c72ecaa60bd00d
     * rspcod : 200
     * rspmsg : 跳转成功
     */

    private String obj;
    private int rspcod;
    private String rspmsg;

    public String getObj() {
        return obj;
    }

    public void setObj(String obj) {
        this.obj = obj;
    }

    public int getRspcod() {
        return rspcod;
    }

    public void setRspcod(int rspcod) {
        this.rspcod = rspcod;
    }

    public String getRspmsg() {
        return rspmsg;
    }

    public void setRspmsg(String rspmsg) {
        this.rspmsg = rspmsg;
    }
}
