package com.example.administrator.zijixiangmu.base;

/**
 * Created by Administrator on 2018/5/30.
 */

public class BasePresenter<M, V> {

    public M mModel;
    public V mView;

    public void setMV(M m,V v){
        mModel=m;
        mView=v;
    }




}
