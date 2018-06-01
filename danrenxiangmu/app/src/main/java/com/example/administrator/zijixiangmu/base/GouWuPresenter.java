package com.example.administrator.zijixiangmu.base;
import com.example.administrator.zijixiangmu.bean.Li;
import com.example.administrator.zijixiangmu.bean.ZuiLi;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
* Created by TMVPHelper on 2018/05/30
*/
public class GouWuPresenter extends GouWuContract.Presenter{

    @Override
    public void loginPas(String phone, String psw) {
        mModel.getLogin(phone,psw)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        zuiLiLi -> mView.getUrlDataOk(0), throwable -> {
                            if(throwable.getMessage().contains("Failed to connect")){
                                mView.getUrlDataNo("网络请求错误");
                            }else{
                                mView.getUrlDataNo(throwable.getMessage());
                            }
                        });

                        /*zuiLiLi -> {
                    mView.getUrlDataOk(0);
                },throwable -> {
                    if(throwable.getMessage().contains("Failed to connect")){
                        mView.getUrlDataOk(1);
                    }else{
                        mView.getUrlDataOk(2);
                    }
                });*/
    }

    @Override
    public void loginYanZheng(String phone, String type) {
        mModel.getLoginYanZhengma(phone, type)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(stringLi -> mView.getUrlDataOk(10), throwable -> {
                    if(throwable.getMessage().contains("Failed to connect")){
                        mView.getUrlDataNo("网络请求错误");
                    }else{
                        mView.getUrlDataNo(throwable.getMessage());
                    }
                });
    }

    @Override
    public void loginYanZhengDenglu(String phone, String code) {
            mModel.loginYanZhengDenglu(phone, code)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(stringLi -> mView.getUrlDataOk(11), throwable -> {
                        if(throwable.getMessage().contains("Failed to connect")){
                            mView.getUrlDataNo("网络请求错误");
                        }else{
                            mView.getUrlDataNo(throwable.getMessage());
                        }
                    });
    }

    @Override
    public void YanzhengYanzheng(String phone, String code, String type) {
            mModel.zhuceYanZheng(phone, code, type)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(stringLi -> mView.getUrlDataOk(20), throwable -> {
                        if(throwable.getMessage().contains("Failed to connect")){
                            mView.getUrlDataNo("网络请求错误");
                        }else{
                            mView.getUrlDataNo(throwable.getMessage());
                        }
                    });
    }

    @Override
    public void XinMiMa(String phone, String paw, String code) {
        mModel.XinMiMa(phone, paw, code)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(zuiLiLi -> mView.getUrlDataOk(100), throwable -> {
                    if(throwable.getMessage().contains("Failed to connect")){
                        mView.getUrlDataNo("网络请求错误");
                    }else{
                        mView.getUrlDataNo(throwable.getMessage());
                    }
                });
    }
}