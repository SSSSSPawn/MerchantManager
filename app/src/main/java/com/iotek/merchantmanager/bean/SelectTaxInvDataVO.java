package com.iotek.merchantmanager.bean;

import java.util.List;

/**
 * Created by admin on 2017/11/3.
 */

public class SelectTaxInvDataVO extends BaseBean {


    /**
     * page : 1
     * records : 10
     * rows : [{"auditor":"李卓鹏","beneficiary":"李卓鹏","checkCode":"05135562543688622331","collectTaxMode":0,"custId":21,"custLname":"南京亚青体育产业发展有限公司","devType":"1","diskCode":"-1","invCode":"032001500111","invDate":1509690213000,"invDitailFlag":"0","invNumber":"44938028","invOperate":"李卓鹏","invOrderId":"10104920171103145114","invStatus":0,"invTypeCode":"026","invTypeSpecial":"00","isMakeInv":1,"makeInvType":"0","orderId":"2018564607101729262300081","payEmail":"921720013@qq.com","payMobile":"13287260909","payUnit":"个人","pdfAddress":"https://fpkj.vpiaotong.com/d/OTI2MzQxMDc0MjczODYxNjMy.pt","qrcode":"Qk3CAwAAAAAAAD4AAAAoAAAASwAAAEsAAAABAAEAAAAAAIQDAAAAAAAAAAAAAAAAAAACAAAAAAAA///////////////////gAAAAAz8wAPzM/DAgAAAAAz8wAPzM/DAgAAA/88AzMz8MzPPgAAA/88AzMz8MzPPgAAAwMwMzDDz/8w/gAAAwMwMzDDz/8w/gAAAwMzMM8wP/8D8gAAAwMzMM8wP/8D8gAAAwM8DD8/P/ADwgAAAwM8DD8/P/ADwgAAA/8zAz/PA/PzzgAAA/8zAz/PA/PzzgAAAAAzMwD88/Mw8gAAAAAzMwD88/Mw8gAAD//wwwA/zAPzAgAAD//wwwA/zAPzAgAAAA8MAMP8wAAADgAAAA8MAMP8wAAADgAADDzPM/P8w88MzgAADDzPM/P8w88MzgAAAw8DwAAD8DPAPgAAAw8DwAAD8DPAPgAAAMP8DzAwwM8w8gAAAMP8DzAwwM8w8gAADzwA8w8AAMMDMgAADzwA8w8AAMMDMgAAAzzzDzMMPDwPPgAAAzzzDzMMPDwPPgAADAwMw/z8ADDwzgAADAwMw/z8ADDwzgAADw/AA//Pw/z8zgAADw/AA//Pw/z8zgAADzAAwDzwM8/w/gAADzAAwDzwM8/w/gAAAw/MP/wPz/zzzgAAAw/MP/wPz/zzzgAAADwDAMMM/88zMgAAADwDAMMM/88zMgAAD8PAPPPAzAAPAgAAD8PAPPPAzAAPAgAADPwwMDAzwDDMPgAADPwwMDAzwDDMPgAADDDP8DwwAw88wgAADDDP8DwwAw88wgAAADM/M/wPM/DzPgAAADM/M/wPM/DzPgAADM/zzA8DP88wMgAADM/zzA8DP88wMgAADzAzPzw//MMDMgAADzAzPzw//MMDMgAAAMD8zA/PDA8/DgAAAMD8zA/PDA8/DgAAAPAAwwz8wzzAzgAAAPAAwwz8wzzAzgAAAD/zw8P8wzz8/gAAAD/zw8P8wzz8/gAAAwwPAPPzw/88wgAAAwwPAPPzw/88wgAAD//zPPA8zz///gAAD//zPPA8zz///gAAAAAzMzMzMzMAAgAAAAAzMzMzMzMAAgAAA/88M//M//M/8gAAA/88M//M//M/8gAAAwM//wAAP88wMgAAAwM//wAAP88wMgAAAwMw8/wD/MMwMgAAAwMw8/wD/MMwMgAAAwM8MwPzAAMwMgAAAwM8MwPzAAMwMgAAA/8wAA/Dzz8/8gAAA/8wAA/Dzz8/8gAAAAAw/8Mw8z8AAgAAAAAw/8Mw8z8AAgAAA=","sendType":0,"sumAmount":1.94,"sumTaxAmount":0.06,"sumTotal":2},{"auditor":"朱国治","beneficiary":"朱国治","collectTaxMode":0,"custId":21,"custLname":"南京亚青体育产业发展有限公司","devType":"1","diskCode":"-1","invDitailFlag":"0","invOperate":"朱国治","invOrderId":"10104820171102145226","invStatus":2,"invTypeCode":"026","invTypeSpecial":"00","isMakeInv":0,"makeInvType":"0","orderId":"2017110214522500006914","sendType":0,"sumAmount":9.71,"sumTaxAmount":0.29,"sumTotal":10},{"auditor":"秦德灏","beneficiary":"秦德灏","collectTaxMode":0,"custId":21,"custLname":"南京亚青体育产业发展有限公司","devType":"1","diskCode":"-1","invDitailFlag":"0","invOperate":"秦德灏","invOrderId":"10104720171102104300","invStatus":2,"invTypeCode":"026","invTypeSpecial":"00","isMakeInv":0,"makeInvType":"0","orderId":"2017110210425600006907","sendType":0,"sumAmount":3.4,"sumTaxAmount":0.1,"sumTotal":3.5},{"auditor":"秦德灏","beneficiary":"秦德灏","collectTaxMode":0,"custId":21,"custLname":"南京亚青体育产业发展有限公司","devType":"1","diskCode":"-1","invDitailFlag":"0","invOperate":"秦德灏","invOrderId":"10104620171102103018","invStatus":2,"invTypeCode":"026","invTypeSpecial":"00","isMakeInv":0,"makeInvType":"0","orderId":"2017110210301400006906","sendType":0,"sumAmount":19.42,"sumTaxAmount":0.58,"sumTotal":20},{"auditor":"秦德灏","beneficiary":"秦德灏","collectTaxMode":0,"custId":21,"custLname":"南京亚青体育产业发展有限公司","devType":"1","diskCode":"-1","invDitailFlag":"0","invFailCause":"单价必须为正数","invOperate":"秦德灏","invOrderId":"10104520171102102806","invStatus":1,"invTypeCode":"026","invTypeSpecial":"00","isMakeInv":0,"makeInvType":"0","orderId":"2017110210280400006905","payEmail":"935602177@qq.com","payMobile":"15365259293","payTaxRegNo":"91320206346337655Q","payUnit":"江苏物云通物流科技有限公司","sendType":0,"sumAmount":3.4,"sumTaxAmount":0.1,"sumTotal":3.5},{"auditor":"秦德灏","beneficiary":"秦德灏","collectTaxMode":0,"custId":21,"custLname":"南京亚青体育产业发展有限公司","devType":"1","diskCode":"-1","invDitailFlag":"0","invOperate":"秦德灏","invOrderId":"10104420171101155656","invStatus":2,"invTypeCode":"026","invTypeSpecial":"00","isMakeInv":0,"makeInvType":"0","orderId":"2017110115565300006882","sendType":0,"sumAmount":9.71,"sumTaxAmount":0.29,"sumTotal":10},{"auditor":"李卓鹏","beneficiary":"李卓鹏","checkCode":"07457272709226409546","collectTaxMode":0,"custId":21,"custLname":"南京亚青体育产业发展有限公司","devType":"1","diskCode":"-1","invCode":"032001500111","invDate":1509515736000,"invDitailFlag":"0","invNumber":"44938013","invOperate":"李卓鹏","invOrderId":"10104320171101141813","invStatus":0,"invTypeCode":"026","invTypeSpecial":"00","isMakeInv":1,"makeInvType":"0","orderId":"2017110114180500006877","payMobile":"15996244906","payUnit":"李卓鹏","pdfAddress":"https://fpkj.vpiaotong.com/d/OTI1NjA5MjU2MDU0NTg3Mzky.pt","qrcode":"Qk3CAwAAAAAAAD4AAAAoAAAASwAAAEsAAAABAAEAAAAAAIQDAAAAAAAAAAAAAAAAAAACAAAAAAAA///////////////////gAAAAAwzMAPzM/DAgAAAAAwzMAPzM/DAgAAA/88PzMzMM/PPgAAA/88PzMzMM/PPgAAAwMzwDDDz/8zPgAAAwMzwDDDz/8zPgAAAwMwwA8wA/8A8gAAAwMwwA8wA/8A8gAAAwM8//8/M/ADwgAAAwM8//8/M/ADwgAAA/8zAz/PAzPzzgAAA/8zAz/PAzPzzgAAAAAzP8D88DMw8gAAAAAzP8D88DMw8gAAD//w88A/zAPzAgAAD//w88A/zAPzAgAAAMMwzwP8wDAADgAAAMMwzwP8wDAADgAADADPAzP8z/8MzgAADADPAzP8z/8MzgAAA8A/88AD8DPw/gAAA8A/88AD8DPw/gAAADz/DPAw/M8w8gAAADz/DPAw/M8w8gAAA88P8M8wDMMDMgAAA88P8M8wDMMDMgAAAD/wPPMMPPzPPgAAAD/wPPMMPPzPPgAAA/8wzDzwA/AwzgAAA/8wzDzwA/AwzgAAAAP8/z/Pw/z8zgAAAAP8/z/Pw/z8zgAAAww8MDzwM//w/gAAAww8MDzwM//w/gAADM/wDDwPA8DzzgAADM/wDDwPA8DzzgAAD8MzMMMP888z8gAAD8MzMMMP888z8gAADDzMD/PDzAAMAgAADDzMD/PDzAAMAgAAD/Azw/AzwDDMPgAAD/Azw/AzwDDMPgAAAP/8zAw8Aw88zgAAAP/8zAw8Aw88zgAADw8AP/wDMDPzPgAADw8AP/wDMDPzPgAAD/D8Dw8DP88wMgAAD/D8Dw8DP88wMgAAAP8zAPw//MMDMgAAAP8zAPw//MMDMgAAADzPzA/P8D8/DgAAADzPzA/P8D8/DgAAD8ADzAz/wzzPzgAAD8ADzAz/wzzPzgAADwzzDwP8/zz//gAADwzzDwP8/zz//gAAAwwPzzPzz/88wgAAAwwPzzPzz/88wgAAD//zAAA8z////gAAD//zAAA8z////gAAAAAzMzMzMzMAAgAAAAAzMzMzMzMAAgAAA/88A8PM/PM/8gAAA/88A8PM/PM/8gAAAwM/DAwAPM8wMgAAAwM/DAwAPM8wMgAAAwMwzPAD/MMwMgAAAwMwzPAD/MMwMgAAAwM8Dw/zDDMwMgAAAwM8Dw/zDDMwMgAAA/8wMPPDwz8/8gAAA/8wMPPDwz8/8gAAAAAwPz8w8z8AAgAAAAAwPz8w8z8AAgAAA=","sendType":0,"sumAmount":0.01,"sumTaxAmount":0,"sumTotal":0.01},{"auditor":"李卓鹏","beneficiary":"李卓鹏","collectTaxMode":0,"custId":21,"custLname":"南京亚青体育产业发展有限公司","devType":"1","diskCode":"-1","invDitailFlag":"0","invFailCause":"业务异常，请联系运维","invOperate":"李卓鹏","invOrderId":"10104220171101141746","invStatus":1,"invTypeCode":"026","invTypeSpecial":"00","isMakeInv":0,"makeInvType":"0","orderId":"2017110114174000006876","payMobile":"13814689521","payUnit":"个人","sendType":0,"sumAmount":0.01,"sumTaxAmount":0,"sumTotal":0.01},{"auditor":"李卓鹏","beneficiary":"李卓鹏","checkCode":"03303613035095592537","collectTaxMode":0,"custId":21,"custLname":"南京亚青体育产业发展有限公司","devType":"1","diskCode":"-1","invCode":"032001500111","invDate":1509515727000,"invDitailFlag":"0","invNumber":"44938011","invOperate":"李卓鹏","invOrderId":"10104120171101141713","invStatus":0,"invTypeCode":"026","invTypeSpecial":"00","isMakeInv":1,"makeInvType":"0","orderId":"2017110114170900006875","payMobile":"15298369684","payUnit":"银企通","pdfAddress":"https://fpkj.vpiaotong.com/d/OTI1NjA5MjE2NTA2NDk0OTc2.pt","qrcode":"Qk3CAwAAAAAAAD4AAAAoAAAASwAAAEsAAAABAAEAAAAAAIQDAAAAAAAAAAAAAAAAAAACAAAAAAAA///////////////////gAAAAAz8MAPzM8DAgAAAAAz8MAPzM8DAgAAA/88zDMzMM/PPgAAA/88zDMzMM/PPgAAAwMzD/DDz/8zPgAAAwMzD/DDz/8zPgAAAwMzPw8wA/8D8gAAAwMzPw8wA/8D8gAAAwM8P/8/M/ADwgAAAwM8P/8/M/ADwgAAA/8zM//PA/PzzgAAA/8zM//PA/PzzgAAAAAzwwD88DMw8gAAAAAzwwD88DMw8gAAD//zPwA/zAPzAgAAD//zPwA/zAPzAgAAAPAzzAP8wAAADgAAAPAzzAP8wAAADgAADMzMPDP88888zgAADMzMPDP88888zgAAAz8zAwAD/D/8/gAAAz8zAwAD/D/8/gAAA8DA//Aw/M8z8gAAA8DA//Aw/M8z8gAAAD8APw8wDMMDMgAAAD8APw8wDMMDMgAAAM/P8DMMPDzPPgAAAM/P8DMMPDzPPgAADDM8MPzwADPwzgAADDM8MPzwADPwzgAADPPzAD/Pw/z8zgAADPPzAD/Pw/z8zgAADMMz8zzwM//w/gAADMMz8zzwM//w/gAAAwzz8zwPD/DzzgAAAwzz8zwPD/DzzgAADDwMM8MM/8MA8gAADDwMM8MM/8MA8gAAD8PAMzPDzAAPAgAAD8PAMzPDzAAPAgAAAzM8P/AzwDDMDgAAAzM8P/AzwDDMDgAAAM/8www8Awz8zgAAAM/8www8Awz8zgAAAzM/AzwDMDPzPgAAAzM/AzwDMDPzPgAADAPA888DP88wMgAADAPA888DP88wMgAAAPwPA/w/zMMDMgAAAPwPA/w/zMMDMgAADD/wDM/P/D8PDgAADD/wDM/P/D8PDgAADzAAzAz/wzDwDgAADzAAzAz/wzDwDgAAD/D8zwP8wzz8/gAAD/D8zwP8wzz8/gAAAwwMA/Pzw/88wgAAAwwMA/Pzw/88wgAAD//w8AA8zz///gAAD//w8AA8zz///gAAAAAzMzMzMzMAAgAAAAAzMzMzMzMAAgAAA/8/zP/M//M/8gAAA/8/zP/M//M/8gAAAwM/DwAAP88wMgAAAwM/DwAAP88wMgAAAwMzMPAD/PMwMgAAAwMzMPAD/PMwMgAAAwM/wwPzPDMwMgAAAwM/wwPzPDMwMgAAA/8wA8/DzzM/8gAAA/8wA8/DzzM/8gAAAAAzw/8w8z8AAgAAAAAzw/8w8z8AAgAAA=","sendType":0,"sumAmount":0.01,"sumTaxAmount":0,"sumTotal":0.01},{"auditor":"李卓鹏","beneficiary":"李卓鹏","checkCode":"04086598757351034055","collectTaxMode":0,"custId":21,"custLname":"南京亚青体育产业发展有限公司","devType":"1","diskCode":"-1","invCode":"032001500111","invDate":1509515798000,"invDitailFlag":"0","invNumber":"44938014","invOperate":"李卓鹏","invOrderId":"10104020171101141635","invStatus":0,"invTypeCode":"026","invTypeSpecial":"00","isMakeInv":1,"makeInvType":"0","orderId":"2017110114163100006873","payMobile":"13814689521","payUnit":"个人","pdfAddress":"https://fpkj.vpiaotong.com/d/OTI1NjA5NTQ4MjUzMDAzNzc2.pt","qrcode":"Qk3CAwAAAAAAAD4AAAAoAAAASwAAAEsAAAABAAEAAAAAAIQDAAAAAAAAAAAAAAAAAAACAAAAAAAA///////////////////gAAAAAzzAAPzMzDAgAAAAAzzAAPzMzDAgAAA/88APMzMM/PPgAAA/88APMzMM/PPgAAAwMzzPDDz/8w/gAAAwMzzPDDz/8w/gAAAwMwD88wA/8D8gAAAwMwD88wA/8D8gAAAwM8/D8/M/ADwgAAAwM8/D8/M/ADwgAAA/8wz//PA/PzzgAAA/8wz//PA/PzzgAAAAAzwAD88zMw8gAAAAAzwAD88zMw8gAAD//wAwA/zAPzAgAAD//wAwA/zAPzAgAAAA8zzAP8wDAADgAAAA8zzAP8wDAADgAADDPAPDP888MwzgAADDPAPDP888MwzgAAA8Mw8MAD8D///gAAA8Mw8MAD8D///gAAAMPM/zAwwM8w8gAAAMPM/zAwwM8w8gAAA/wDw88wAMMDMgAAA/wDw88wAMMDMgAAAAPAM/MMPDwPPgAAAAPAM/MMPDwPPgAADAAAPzzwA/PwzgAADAAAPzzwA/PwzgAAAw/M8P/Pw/z8zgAAAw/M8P/Pw/z8zgAAAA8wPzzwM//w/gAAAA8wPzzwM//w/gAAAPDw/zwPz/z/zgAAAPDw/zwPz/z/zgAADPwP/wMMP8M88gAADPwP/wMMP8M88gAAAw/PzzPDzAAPwgAAAw/PzzPDzAAPwgAADPwDzPAzwDDMPgAADPwDzPAzwDDMPgAADPzMDww8A8w88gAADPzMDww8A8w88gAADMAA8/wDMPDzPgAADMAA8/wDMPDzPgAADMD/DA8DP88wMgAADMD/DA8DP88wMgAAAPAzw/w/zMMDMgAAAPAzw/w/zMMDMgAAA8zDzM/P/DM/DgAAA8zDzM/P/DM/DgAADz8Pzwz/zzzPzgAADz8Pzwz/zzzPzgAAA/zPMMP8wzz8/gAAA/zPMMP8wzz8/gAAAwwPPzPzw/88wgAAAwwPPzPzw/88wgAAD//wDPA8zz///gAAD//wDPA8zz///gAAAAAzMzMzMzMAAgAAAAAzMzMzMzMAAgAAA/8/w/PM/DM/8gAAA/8/w/PM/DM/8gAAAwM8ADwAP88wMgAAAwM8ADwAP88wMgAAAwMw8MAD/MMwMgAAAwMw8MAD/MMwMgAAAwM8w8PzDAMwMgAAAwM8w8PzDAMwMgAAA/8z8zPDzzM/8gAAA/8z8zPDzzM/8gAAAAAzD88w8z8AAgAAAAAzD88w8z8AAgAAA=","sendType":0,"sumAmount":0.01,"sumTaxAmount":0,"sumTotal":0.01}]
     * total : 1
     */

    private int page;
    private int records;
    private int total;
    private List<RowsBean> rows;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRecords() {
        return records;
    }

    public void setRecords(int records) {
        this.records = records;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<RowsBean> getRows() {
        return rows;
    }

    public void setRows(List<RowsBean> rows) {
        this.rows = rows;
    }

    public static class RowsBean {
        /**
         * auditor : 李卓鹏
         * beneficiary : 李卓鹏
         * checkCode : 05135562543688622331
         * collectTaxMode : 0
         * custId : 21
         * custLname : 南京亚青体育产业发展有限公司
         * devType : 1
         * diskCode : -1
         * invCode : 032001500111
         * invDate : 1509690213000
         * invDitailFlag : 0
         * invNumber : 44938028
         * invOperate : 李卓鹏
         * invOrderId : 10104920171103145114
         * invStatus : 0
         * invTypeCode : 026
         * invTypeSpecial : 00
         * isMakeInv : 1
         * makeInvType : 0
         * orderId : 2018564607101729262300081
         * payEmail : 921720013@qq.com
         * payMobile : 13287260909
         * payUnit : 个人
         * pdfAddress : https://fpkj.vpiaotong.com/d/OTI2MzQxMDc0MjczODYxNjMy.pt
         * qrcode : Qk3CAwAAAAAAAD4AAAAoAAAASwAAAEsAAAABAAEAAAAAAIQDAAAAAAAAAAAAAAAAAAACAAAAAAAA///////////////////gAAAAAz8wAPzM/DAgAAAAAz8wAPzM/DAgAAA/88AzMz8MzPPgAAA/88AzMz8MzPPgAAAwMwMzDDz/8w/gAAAwMwMzDDz/8w/gAAAwMzMM8wP/8D8gAAAwMzMM8wP/8D8gAAAwM8DD8/P/ADwgAAAwM8DD8/P/ADwgAAA/8zAz/PA/PzzgAAA/8zAz/PA/PzzgAAAAAzMwD88/Mw8gAAAAAzMwD88/Mw8gAAD//wwwA/zAPzAgAAD//wwwA/zAPzAgAAAA8MAMP8wAAADgAAAA8MAMP8wAAADgAADDzPM/P8w88MzgAADDzPM/P8w88MzgAAAw8DwAAD8DPAPgAAAw8DwAAD8DPAPgAAAMP8DzAwwM8w8gAAAMP8DzAwwM8w8gAADzwA8w8AAMMDMgAADzwA8w8AAMMDMgAAAzzzDzMMPDwPPgAAAzzzDzMMPDwPPgAADAwMw/z8ADDwzgAADAwMw/z8ADDwzgAADw/AA//Pw/z8zgAADw/AA//Pw/z8zgAADzAAwDzwM8/w/gAADzAAwDzwM8/w/gAAAw/MP/wPz/zzzgAAAw/MP/wPz/zzzgAAADwDAMMM/88zMgAAADwDAMMM/88zMgAAD8PAPPPAzAAPAgAAD8PAPPPAzAAPAgAADPwwMDAzwDDMPgAADPwwMDAzwDDMPgAADDDP8DwwAw88wgAADDDP8DwwAw88wgAAADM/M/wPM/DzPgAAADM/M/wPM/DzPgAADM/zzA8DP88wMgAADM/zzA8DP88wMgAADzAzPzw//MMDMgAADzAzPzw//MMDMgAAAMD8zA/PDA8/DgAAAMD8zA/PDA8/DgAAAPAAwwz8wzzAzgAAAPAAwwz8wzzAzgAAAD/zw8P8wzz8/gAAAD/zw8P8wzz8/gAAAwwPAPPzw/88wgAAAwwPAPPzw/88wgAAD//zPPA8zz///gAAD//zPPA8zz///gAAAAAzMzMzMzMAAgAAAAAzMzMzMzMAAgAAA/88M//M//M/8gAAA/88M//M//M/8gAAAwM//wAAP88wMgAAAwM//wAAP88wMgAAAwMw8/wD/MMwMgAAAwMw8/wD/MMwMgAAAwM8MwPzAAMwMgAAAwM8MwPzAAMwMgAAA/8wAA/Dzz8/8gAAA/8wAA/Dzz8/8gAAAAAw/8Mw8z8AAgAAAAAw/8Mw8z8AAgAAA=
         * sendType : 0
         * sumAmount : 1.94
         * sumTaxAmount : 0.06
         * sumTotal : 2
         * invFailCause : 单价必须为正数
         * payTaxRegNo : 91320206346337655Q
         */

        private String auditor;
        private String beneficiary;
        private String checkCode;
        private int collectTaxMode;
        private int custId;
        private String custLname;
        private String devType;
        private String diskCode;
        private String invCode;
        private long invDate;
        private String invDitailFlag;
        private String invNumber;
        private String invOperate;
        private String invOrderId;
        private int invStatus;
        private String invTypeCode;
        private String invTypeSpecial;
        private int isMakeInv;
        private int makeInvType;
        private String orderId;
        private String payEmail;
        private String payMobile;
        private String payUnit;
        private String pdfAddress;
        private String qrcode;
        private int sendType;
        private double sumAmount;
        private double sumTaxAmount;
        private double sumTotal;
        private String invFailCause;
        private String payTaxRegNo;

        public String getAuditor() {
            return auditor;
        }

        public void setAuditor(String auditor) {
            this.auditor = auditor;
        }

        public String getBeneficiary() {
            return beneficiary;
        }

        public void setBeneficiary(String beneficiary) {
            this.beneficiary = beneficiary;
        }

        public String getCheckCode() {
            return checkCode;
        }

        public void setCheckCode(String checkCode) {
            this.checkCode = checkCode;
        }

        public int getCollectTaxMode() {
            return collectTaxMode;
        }

        public void setCollectTaxMode(int collectTaxMode) {
            this.collectTaxMode = collectTaxMode;
        }

        public int getCustId() {
            return custId;
        }

        public void setCustId(int custId) {
            this.custId = custId;
        }

        public String getCustLname() {
            return custLname;
        }

        public void setCustLname(String custLname) {
            this.custLname = custLname;
        }

        public String getDevType() {
            return devType;
        }

        public void setDevType(String devType) {
            this.devType = devType;
        }

        public String getDiskCode() {
            return diskCode;
        }

        public void setDiskCode(String diskCode) {
            this.diskCode = diskCode;
        }

        public String getInvCode() {
            return invCode;
        }

        public void setInvCode(String invCode) {
            this.invCode = invCode;
        }

        public long getInvDate() {
            return invDate;
        }

        public void setInvDate(long invDate) {
            this.invDate = invDate;
        }

        public String getInvDitailFlag() {
            return invDitailFlag;
        }

        public void setInvDitailFlag(String invDitailFlag) {
            this.invDitailFlag = invDitailFlag;
        }

        public String getInvNumber() {
            return invNumber;
        }

        public void setInvNumber(String invNumber) {
            this.invNumber = invNumber;
        }

        public String getInvOperate() {
            return invOperate;
        }

        public void setInvOperate(String invOperate) {
            this.invOperate = invOperate;
        }

        public String getInvOrderId() {
            return invOrderId;
        }

        public void setInvOrderId(String invOrderId) {
            this.invOrderId = invOrderId;
        }

        public int getInvStatus() {
            return invStatus;
        }

        public void setInvStatus(int invStatus) {
            this.invStatus = invStatus;
        }

        public String getInvTypeCode() {
            return invTypeCode;
        }

        public void setInvTypeCode(String invTypeCode) {
            this.invTypeCode = invTypeCode;
        }

        public String getInvTypeSpecial() {
            return invTypeSpecial;
        }

        public void setInvTypeSpecial(String invTypeSpecial) {
            this.invTypeSpecial = invTypeSpecial;
        }

        public int getIsMakeInv() {
            return isMakeInv;
        }

        public void setIsMakeInv(int isMakeInv) {
            this.isMakeInv = isMakeInv;
        }

        public int getMakeInvType() {
            return makeInvType;
        }

        public void setMakeInvType(int makeInvType) {
            this.makeInvType = makeInvType;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getPayEmail() {
            return payEmail;
        }

        public void setPayEmail(String payEmail) {
            this.payEmail = payEmail;
        }

        public String getPayMobile() {
            return payMobile;
        }

        public void setPayMobile(String payMobile) {
            this.payMobile = payMobile;
        }

        public String getPayUnit() {
            return payUnit;
        }

        public void setPayUnit(String payUnit) {
            this.payUnit = payUnit;
        }

        public String getPdfAddress() {
            return pdfAddress;
        }

        public void setPdfAddress(String pdfAddress) {
            this.pdfAddress = pdfAddress;
        }

        public String getQrcode() {
            return qrcode;
        }

        public void setQrcode(String qrcode) {
            this.qrcode = qrcode;
        }

        public int getSendType() {
            return sendType;
        }

        public void setSendType(int sendType) {
            this.sendType = sendType;
        }

        public double getSumAmount() {
            return sumAmount;
        }

        public void setSumAmount(double sumAmount) {
            this.sumAmount = sumAmount;
        }

        public double getSumTaxAmount() {
            return sumTaxAmount;
        }

        public void setSumTaxAmount(double sumTaxAmount) {
            this.sumTaxAmount = sumTaxAmount;
        }

        public double getSumTotal() {
            return sumTotal;
        }

        public void setSumTotal(double sumTotal) {
            this.sumTotal = sumTotal;
        }

        public String getInvFailCause() {
            return invFailCause;
        }

        public void setInvFailCause(String invFailCause) {
            this.invFailCause = invFailCause;
        }

        public String getPayTaxRegNo() {
            return payTaxRegNo;
        }

        public void setPayTaxRegNo(String payTaxRegNo) {
            this.payTaxRegNo = payTaxRegNo;
        }
    }
}
