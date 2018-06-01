package com.example.administrator.zijixiangmu.message;

import com.example.administrator.zijixiangmu.bean.Wai;

import rx.Observable;

/**
 * Created by Administrator on 2018/5/31.
 */

public class WebMessage {
    public static final String Error = "Error";
    public static <T extends Wai> Observable<T> flatResult(T dot){
        return Observable.create(subscriber -> {
            switch (dot.getCode()){
                case 0:
                    subscriber.onNext(dot);
                    break;
                default:
                    try{
                        if(dot.getCode()==-2){

                        }else{
                            subscriber.onError(new Exception(dot.getCode()+dot.getMessage(), new Throwable()));
                        }
                    }catch (Exception e){
                        subscriber.onError(new Exception("数据错误", new Throwable()));
                    }
                    break;
            }
            subscriber.onCompleted();
        });
    }

}
