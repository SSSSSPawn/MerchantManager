package com.iotek.merchantmanager.constant;

/**
 * Created by admin on 2017/9/20.
 */

public interface StatusKey {

    String NORMAL_CODE = "1";

    String NORMAL = "正常";

    /**
     * 0.现金  1.微信支付  2.支付宝  8.会员卡  9.储蓄卡 10.信用卡
     */
    int XJ_TYPE = 0;

    int WX_TYPE = 1;

    int ZFB_TYPE = 2;

    int HYK_TYPE = 8;

    int CXK_TYPE = 9;

    int XYK_TYPE = 10;

    /*** 1.销售数据  2.退货数据*/
    int SALES_DATA = 1;

    int RETURN_GOODS_DATA = 2;


    /**
     * 3.本周数据  4.本月数据
     */
    int WEEK_DAY_DATA = 3;

    int MONTH_DAY_DATA = 4;

}
