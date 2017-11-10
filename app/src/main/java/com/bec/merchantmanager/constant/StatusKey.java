package com.bec.merchantmanager.constant;

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

    /**0.开票成功  1.开票失败  2.开票中 */
    int INV_STATTS_SUCCESS = 0;

    int INV_STATTS_FAIL= 1;

    int INV_STATTS_ING = 2;

    /**0.蓝票 1.红票*/
    int INV_TYPE_BLUE = 0;

    int INV_TYPE_RED = 1;

    /** 会员资料管理 0.禁用   1.启用*/
    int STATE_NO = 0;

    int STATE_YES = 1;

    /** 0.女  1.男*/
    int FEMALE = 0;

    int MALE = 1;

}
