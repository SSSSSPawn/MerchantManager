package com.iotek.merchantmanager.net;

import com.iotek.merchantmanager.bean.AddUserParamsVO;
import com.iotek.merchantmanager.bean.CodeMessageVO;
import com.iotek.merchantmanager.bean.LoginParamsVO;
import com.iotek.merchantmanager.bean.LoginVO;
import com.iotek.merchantmanager.bean.UserManagerDetailVO;
import com.iotek.merchantmanager.bean.UserParamsVO;

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
    Call<UserManagerDetailVO> queryUser(@Body RequestBody params);

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
     * 获取系统时间
     *
     * @return
     */
    @POST("app/getSysTime.json")
    Call<CodeMessageVO> getSysTime();

}
