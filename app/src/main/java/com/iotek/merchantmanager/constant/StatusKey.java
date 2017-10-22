package com.iotek.merchantmanager.constant;

/**
 * Created by admin on 2017/9/20.
 */

public interface StatusKey {

    String NORMAL_CODE = "1";

    String NORMAL = "正常";

    /** 0.现金  1.微信支付  2.支付宝 */
    int XJ_TYPE = 0;

    int WX_TYPE = 1;

    int ZFB_TYPE = 2;


    /*** 1.销售数据  2.退货数据*/
    int SALES_DATA = 1;

    int RETURN_GOODS_DATA = 2;

}
