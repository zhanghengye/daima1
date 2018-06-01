package com.example.administrator.zijixiangmu.base;

import com.example.administrator.zijixiangmu.bean.Accounts;
import com.example.administrator.zijixiangmu.bean.Li;
import com.example.administrator.zijixiangmu.bean.ZuiLi;
import com.example.administrator.zijixiangmu.message.WebMessage;
import com.example.administrator.zijixiangmu.services.NetService;

import rx.Observable;

/**
* Created by TMVPHelper on 2018/05/30
*/
public class GouWuModel implements GouWuContract.Model{

    private final NetService netService;

    public GouWuModel() {
        netService = mRetrofitManager.build().create(NetService.class);
    }

    @Override
    public Observable<Li<ZuiLi>> getLogin(String phone, String pas) {
        return netService.getLogin(phone,pas).flatMap(WebMessage::flatResult);
    }

    @Override
    public Observable<Li<String>> getLoginYanZhengma(String phone, String type) {
        Observable<Li<String>>  result= netService.getLoginYanZhengMa(phone,type);
        return result.flatMap(WebMessage::flatResult);
    }

    @Override
    public Observable<Li<ZuiLi>> loginYanZhengDenglu(String phone, String code) {
        return netService.getLoginYanZhenMaDeng(phone, code).flatMap(WebMessage::flatResult);
    }

    @Override
    public Observable<Li<String>> zhuceYanZheng(String phone, String code, String type) {
        return netService.getYanZhengYanZheng(phone, code, type).flatMap(WebMessage::flatResult);
    }

    @Override
    public Observable<Li<ZuiLi>> XinMiMa(String phone, String paw, String code) {
        return netService.setXinPaw(phone, paw, code).flatMap(WebMessage::flatResult);
    }
}