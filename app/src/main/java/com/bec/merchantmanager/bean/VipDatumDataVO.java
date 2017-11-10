package com.bec.merchantmanager.bean;

import java.util.List;

/**
 * Created by admin on 2017/11/7.
 */

public class VipDatumDataVO extends BaseBean {


    /**
     * obj : [{"address":"","balance":985,"birthday":"","cardId":"","custCompanyName":"南京亚青体育产业发展有限公司","custId":21,"discount":"75","email":"","gender":1,"levelName":"三级","membLevel":3,"membName":"司涛","membNum":"123456789","membTel":"15862957096","operName":"bec","pswFlag":0,"recordTime":1503541310799,"registerDate":1503541310799,"score":1000,"state":1,"uid":"d0f6020f-4ac5-4ee5-bdd4-89c8d0cbae7a"},{"address":"","balance":2032050.2,"birthday":"","cardId":"","custCompanyName":"南京亚青体育产业发展有限公司","custId":21,"discount":"60","email":"","gender":0,"levelName":"二级","membLevel":2,"membName":"shwan","membTel":"15298369684","operName":"bec","pswFlag":0,"recordTime":1503541322832,"registerDate":1503541322832,"score":990276,"state":1,"uid":"ee24f72e-a426-4e78-8db3-46a04ffd6674"}]
     * rspcod : 200
     * rspmsg : 获取会员信息成功
     */

    private int rspcod;
    private String rspmsg;
    private List<ObjBean> obj;

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

    public List<ObjBean> getObj() {
        return obj;
    }

    public void setObj(List<ObjBean> obj) {
        this.obj = obj;
    }

    public static class ObjBean extends BaseBean{
        /**
         * address :
         * balance : 985
         * birthday :
         * cardId :
         * custCompanyName : 南京亚青体育产业发展有限公司
         * custId : 21
         * discount : 75
         * email :
         * gender : 1
         * levelName : 三级
         * membLevel : 3
         * membName : 司涛
         * membNum : 123456789
         * membTel : 15862957096
         * operName : bec
         * pswFlag : 0
         * recordTime : 1503541310799
         * registerDate : 1503541310799
         * score : 1000
         * state : 1
         * uid : d0f6020f-4ac5-4ee5-bdd4-89c8d0cbae7a
         */

        private String address;
        private double balance;
        private String birthday;
        private String cardId;
        private String custCompanyName;
        private int custId;
        private String discount;
        private String email;
        private int gender;
        private String levelName;
        private int membLevel;
        private String membName;
        private String membNum;
        private String membTel;
        private String operName;
        private int pswFlag;
        private long recordTime;
        private long registerDate;
        private int score;
        private int state;
        private String uid;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getCardId() {
            return cardId;
        }

        public void setCardId(String cardId) {
            this.cardId = cardId;
        }

        public String getCustCompanyName() {
            return custCompanyName;
        }

        public void setCustCompanyName(String custCompanyName) {
            this.custCompanyName = custCompanyName;
        }

        public int getCustId() {
            return custId;
        }

        public void setCustId(int custId) {
            this.custId = custId;
        }

        public String getDiscount() {
            return discount;
        }

        public void setDiscount(String discount) {
            this.discount = discount;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public String getLevelName() {
            return levelName;
        }

        public void setLevelName(String levelName) {
            this.levelName = levelName;
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

        public String getMembNum() {
            return membNum;
        }

        public void setMembNum(String membNum) {
            this.membNum = membNum;
        }

        public String getMembTel() {
            return membTel;
        }

        public void setMembTel(String membTel) {
            this.membTel = membTel;
        }

        public String getOperName() {
            return operName;
        }

        public void setOperName(String operName) {
            this.operName = operName;
        }

        public int getPswFlag() {
            return pswFlag;
        }

        public void setPswFlag(int pswFlag) {
            this.pswFlag = pswFlag;
        }

        public long getRecordTime() {
            return recordTime;
        }

        public void setRecordTime(long recordTime) {
            this.recordTime = recordTime;
        }

        public long getRegisterDate() {
            return registerDate;
        }

        public void setRegisterDate(long registerDate) {
            this.registerDate = registerDate;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }
    }
}
