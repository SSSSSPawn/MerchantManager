package com.iotek.merchantmanager.net;

import com.google.gson.JsonObject;
import com.iotek.merchantmanager.bean.LoginVO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
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
    @POST("app/inter/dologin.json")
    Observable<LoginVO> login(@Query("onsitetime") String onsiteTime,
                              @Query("mac") String mac,
                              @Query("userName") String userName,
                              @Query("userPasswd") String userPassword,
                              @Query("appversion") String appversion);


    /**
     * 获取系统时间
     * @return
     */
    @GET("app/getSysTime.json")
    Call<JsonObject> getSysTime();


}
