package com.example.administrator.zijixiangmu.moban;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.ViewGroup;

import com.example.administrator.zijixiangmu.base.BaseModel;
import com.example.administrator.zijixiangmu.base.BasePresenter;
import com.example.administrator.zijixiangmu.base.BaseView;
import com.example.administrator.zijixiangmu.utils.Utilss;
import com.yatoooon.screenadaptation.ScreenAdapterTools;


/**
 * Created by Administrator on 2018/5/30.
 */

public abstract class BaseActivity<P extends BasePresenter,M extends BaseModel> extends Activity {

    public P mPresenter;
    public M mModer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScreenAdapterTools.getInstance().loadView((ViewGroup) getWindow().getDecorView());
        init();
    }

    private void init() {
        setContentView(getLayoutId());
        mPresenter= Utilss.getT(this,0);
        mModer=Utilss.getT(this,1);
        if(this instanceof BaseView){
            mPresenter.setMV(mModer,this);
        }
        initView();

    }

    protected abstract void initView();

    public abstract int getLayoutId();
}
