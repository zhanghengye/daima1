package com.example.administrator.zijixiangmu.services;

import com.example.administrator.zijixiangmu.bean.Accounts;
import com.example.administrator.zijixiangmu.bean.Li;
import com.example.administrator.zijixiangmu.bean.ZuiLi;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Administrator on 2018/5/31.
 */

public interface NetService {
    @FormUrlEncoded
    @POST("api/account/login")
   Observable<Li<ZuiLi>> getLogin(@Field("phone")String phone,@Field("password")String psw);
    @FormUrlEncoded
    @POST("api/account/captcha/create")
    Observable<Li<String>> getLoginYanZhengMa(@Field("phone")String phone,@Field("type")String type);
    @FormUrlEncoded
    @POST("api/account/loginBySMS")
    Observable<Li<ZuiLi>> getLoginYanZhenMaDeng(@Field("phone")String phone, @Field("code")String code);
    @FormUrlEncoded
    @POST("api/account/captcha/verify")
    Observable<Li<String>> getYanZhengYanZheng(@Field("phone")String phone,@Field("code")String code,@Field("type")String type);
    @FormUrlEncoded
    @POST("api/account/register")
    Observable<Li<ZuiLi>> setXinPaw(@Field("phone")String phone,@Field("password")String psd,@Field("code")String code);

}
