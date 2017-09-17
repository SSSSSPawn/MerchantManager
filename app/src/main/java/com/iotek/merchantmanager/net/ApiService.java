package com.iotek.merchantmanager.net;

import com.iotek.merchantmanager.bean.LoginVO;

import org.json.JSONObject;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by admin on 2017/9/12.
 */

public interface ApiService {


    /**
     * 登录  表单形式提交
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
    Call<LoginVO> login(@Field("onsitetime") String onsiteTime,
                        @Field("mac") String mac,
                        @Field("userName") String userName,
                        @Field("userPasswd") String userPassword,
                        @Field("appversion") String appversion);


    /**
     * 登陆  JSON格式提交
     *
     * @param params
     * @return
     */
    @Headers({"Content-type:application/json;charset=UTF-8"})
    @POST("app/inter/dologin.json")
    Observable<LoginVO> login(@Body RequestBody params);


    /**
     * 获取系统时间
     *
     * @return
     */
    @GET("app/getSysTime.json")
    Call<JSONObject> getSysTime();


}
