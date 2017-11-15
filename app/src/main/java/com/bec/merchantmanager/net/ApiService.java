package com.bec.merchantmanager.net;

import com.bec.merchantmanager.bean.BBCBankVO;
import com.bec.merchantmanager.bean.CodeMessageVO;
import com.bec.merchantmanager.bean.DayTradeFormVO;
import com.bec.merchantmanager.bean.LoginVO;
import com.bec.merchantmanager.bean.MonthTradeDetailVO;
import com.bec.merchantmanager.bean.MonthTradeFormVO;
import com.bec.merchantmanager.bean.QueryMembLevelVO;
import com.bec.merchantmanager.bean.ReturnGoodsItemDataVO;
import com.bec.merchantmanager.bean.SalesDataDetailVO;
import com.bec.merchantmanager.bean.SalesDataItemDetailVO;
import com.bec.merchantmanager.bean.ScoreExchangeQueryVO;
import com.bec.merchantmanager.bean.SelectShiftReportVO;
import com.bec.merchantmanager.bean.SelectTaxInvDataVO;
import com.bec.merchantmanager.bean.TradeFormPayDetailVO;
import com.bec.merchantmanager.bean.UserManagerDetailVO;
import com.bec.merchantmanager.bean.VipDatumDataVO;
import com.bec.merchantmanager.bean.VipLogVO;
import com.bec.merchantmanager.bean.YYYShiftReportVO;
import com.bec.merchantmanager.bean.params.AddUserParamsVO;
import com.bec.merchantmanager.bean.params.AddVipDatumParamsVO;
import com.bec.merchantmanager.bean.params.AddVipRankParamsVO;
import com.bec.merchantmanager.bean.params.LoginParamsVO;
import com.bec.merchantmanager.bean.params.MembLevelEditParamsVO;
import com.bec.merchantmanager.bean.params.MembMoneyResetParamsVO;
import com.bec.merchantmanager.bean.params.QueryAllMembParamsVO;
import com.bec.merchantmanager.bean.params.QueryMembLevelParamsVO;
import com.bec.merchantmanager.bean.params.QueryUserParamsVO;
import com.bec.merchantmanager.bean.params.SalesDataDetailParamsVO;
import com.bec.merchantmanager.bean.params.SalesDataParamsVO;
import com.bec.merchantmanager.bean.params.ScoreExchangeAddParamsVO;
import com.bec.merchantmanager.bean.params.ScoreExchangeDeleteParamsVO;
import com.bec.merchantmanager.bean.params.ScoreExchangeParamsVO;
import com.bec.merchantmanager.bean.params.ScoreExchangeUpdateParamsVO;
import com.bec.merchantmanager.bean.params.SelectShiftReportDetailParamsVO;
import com.bec.merchantmanager.bean.params.SelectShiftReportParamsVO;
import com.bec.merchantmanager.bean.params.SelectTaxInvDataParamsVO;
import com.bec.merchantmanager.bean.params.TradeFormDetailParamsVO;
import com.bec.merchantmanager.bean.params.TradeFormParamsVO;
import com.bec.merchantmanager.bean.params.UserParamsVO;
import com.bec.merchantmanager.bean.params.VipLogParamsVO;
import com.bec.merchantmanager.bean.params.YYYShiftRefortParamsVO;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by admin on 2017/9/12.
 */

public interface ApiService {


    /**
     * 登录
     *
     * @param onsiteTime
     * @param mac
     * @param userName
     * @param userPassword
     * @param appversion
     * @return
     */
    @FormUrlEncoded
    @POST("app/inter/dologin.json")
    Call<LoginVO> login(@Field("onsitetime") String onsiteTime, @Field("mac") String mac, @Field("userName") String userName, @Field("userPasswd") String userPassword, @Field("appversion") String appversion);


    /**
     * 登陆
     *
     * @param params
     * @return
     */
    @POST("app/inter/dologin.json")
    Observable<LoginVO> login(@Body LoginParamsVO params);

    /**
     * 查询 操作员列表
     *
     * @param params
     * @return
     */
    @POST("app/inter/userQuery.json")
    Call<UserManagerDetailVO> queryUser(@Body QueryUserParamsVO params);

    /**
     * 重置密码
     *
     * @param params
     * @return
     */
    @POST("app/inter/userResetPasswd.json")
    Call<CodeMessageVO> resetPasswds(@Body UserParamsVO params);


    /**
     * 删除用户
     *
     * @param params
     * @return
     */
    @POST("app/inter/userDelete.json")
    Call<CodeMessageVO> userDelete(@Body UserParamsVO params);

    /**
     * 添加操作员
     *
     * @param paramsVO
     * @return
     */
    @POST("app/inter/userAdd.json")
    Call<CodeMessageVO> userAdd(@Body AddUserParamsVO paramsVO);

    /**
     * 跳到平安页面
     *
     * @param params
     * @return
     */
    @POST("app/redirectToPingAn.json")
    Call<BBCBankVO> redirectToPingAn(@Body RequestBody params);


    /**
     * 获取系统时间
     *
     * @return
     */
    @POST("app/getSysTime.json")
    Call<CodeMessageVO> getSysTime();

    /**
     * 日交易报表查询
     *
     * @return
     */
    @POST("app/inter/dayReport.json")
    Call<DayTradeFormVO> getDayTradeForm(@Body TradeFormParamsVO paramsVO);

//    @POST("app/inter/dayReport.json")
//    Observable<DayTradeFormVO> getDayTradeForms(@Body TradeFormParamsVO paramsVO);


    /**
     * 日交易详情报表查询
     *
     * @return
     */
    @POST("app/inter/dayDetailReport.json")
    Call<TradeFormPayDetailVO> getDayTradeDetail(@Body TradeFormDetailParamsVO paramsVO);

    /**
     * 月交易报表查询
     *
     * @param paramsVO
     * @return
     */
    @POST("app/inter/monthReport.json")
    Call<MonthTradeFormVO> getMonthTradeForm(@Body TradeFormParamsVO paramsVO);

    /**
     * 月交易详情
     *
     * @param paramsVO
     * @return
     */
    @POST("app/inter/monthDetailReport.json")
    Call<MonthTradeDetailVO> getMonthTradeDetail(@Body TradeFormDetailParamsVO paramsVO);

    /**
     * 销售/退货数据查询
     */
    @POST("app/inter/selectSaleDataReport.json")
    Call<SalesDataDetailVO> saleDataList(@Body SalesDataParamsVO paramsVO);

    /**
     * 退货数据查询
     */
    @POST("app/inter/selectSaleDataReport.json")
    Call<ReturnGoodsItemDataVO> saleReturnDataList(@Body SalesDataParamsVO paramsVO);

    /**
     * 销售数据明细查询接口
     *
     * @return
     */
    @POST("app/inter/selectSaleDetailReport.json")
    Call<SalesDataItemDetailVO> saleItemDataList(@Body SalesDataDetailParamsVO paramsVO);

    /**
     * 交接班报表查询
     */
    @POST("app/inter/selectShiftReport.json")
    Call<SelectShiftReportVO> selectShiftReport(@Body SelectShiftReportParamsVO paramsVO);


    /**
     * 交接班明细查询
     *
     * @param paramsVO
     * @return
     */
    @POST("app/inter/selectShiftReportDetail.json")
    Call<CodeMessageVO> selectShiftReportDetail(@Body SelectShiftReportDetailParamsVO paramsVO);

    /**
     * 营业员报表查询
     *
     * @param paramsVO
     * @return
     */
    @POST("app/inter/yyyShiftReport.json")
    Call<YYYShiftReportVO> yyyShiftReport(@Body YYYShiftRefortParamsVO paramsVO);


    /**
     * 发票数据查询
     *
     * @return
     */
    @POST("app/inter/selectTaxInvData.json")
    Call<SelectTaxInvDataVO> selectTaxInvData(@Body SelectTaxInvDataParamsVO paramsVO);


    /**
     * 会员等级查询
     *
     * @param paramsVO
     * @return
     */
    @POST("app/inter/queryMembLevel.json")
    Call<QueryMembLevelVO> queryMembLevel(@Body QueryMembLevelParamsVO paramsVO);

    /**
     * 新增会员等级
     *
     * @return
     */
    @POST("app/inter/membLevelAdd.json")
    Call<CodeMessageVO> addVipRank(@Body AddVipRankParamsVO paramsVO);

    /**
     * 会员等级修改
     *
     * @param paramsVO
     * @return
     */
    @POST("app/inter/membLevelEdit.json")
    Call<CodeMessageVO> membLevelEdit(@Body MembLevelEditParamsVO paramsVO);

    /**
     * 会员查询接口
     *
     * @param paramsVO
     * @return
     */
    @POST("app/inter/queryAllMemb.json")
    Call<VipDatumDataVO> queryAllMemb(@Body QueryAllMembParamsVO paramsVO);


    /**
     * 新增会员
     *
     * @return
     */
    @POST("app/inter/membAdd.json")
    Call<CodeMessageVO> membAdd(@Body AddVipDatumParamsVO paramsVO);


    /**
     * 修改会员信息
     *
     * @param paramsVO
     * @return
     */
    @POST("app/inter/membEdit.json")
    Call<CodeMessageVO> membEdit(@Body AddVipDatumParamsVO paramsVO);


    /**
     * 会员积分清零
     *
     * @param paramsVO
     * @return
     */
    @POST("app/inter/membMoneyReset.json")
    Call<CodeMessageVO> membMoneyReset(@Body MembMoneyResetParamsVO paramsVO);


    /**
     * 会员日志查询
     *
     * @return
     */
    @POST("app/inter/membDetailQuery.json")
    Call<VipLogVO> membDetailQuery(@Body VipLogParamsVO paramsVO);


    /**
     * 积分兑换规则查询接口
     *
     * @return
     */
    @POST("app/inter/scoreExchangeQuery.json")
    Call<ScoreExchangeQueryVO> scoreExchangeQuery(@Body ScoreExchangeParamsVO paramsVO);


    /**
     * 删除积分兑换规则
     *
     * @return
     */
    @POST("app/inter/scoreExchangeDelete.json")
    Call<CodeMessageVO> scoreExchangeDelete(@Body ScoreExchangeDeleteParamsVO paramsVO);


    /**
     * 新增积分兑换规则
     *
     * @return
     */
    @POST("app/inter/scoreExchangeAdd.json")
    Call<CodeMessageVO> scoreExchangeAdd(@Body ScoreExchangeAddParamsVO paramsVO);


    /**
     * 修改积分兑换规则
     *
     * @param paramsVO
     * @return
     */
    @POST("app/inter/scoreExchangeEdit.json")
    Call<CodeMessageVO> scoreExchangeEdit(@Body ScoreExchangeUpdateParamsVO paramsVO);

}
