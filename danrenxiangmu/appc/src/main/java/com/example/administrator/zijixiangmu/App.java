package com.example.administrator.zijixiangmu;

import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;
import com.yatoooon.screenadaptation.ScreenAdapterTools;

/**
 * Created by Administrator on 2018/5/30.
 */

public class App extends Application {
    public static String phone;
    public static String code;
    private static Context mContext;


    public static synchronized App context() {
        return (App) mContext;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        ScreenAdapterTools.init(this);
        //初始化第三方分享
        initShareSdk();
        //初始化logger库
        initLogger();
    }
    private void initLogger() {
        if (BuildConfig.DEBUG ) {
            Logger.init("jingp").setLogLevel(LogLevel.FULL);
        }else{
            Logger.init("jingp").setLogLevel(LogLevel.NONE);

        }
    }
    private void initShareSdk() {

        mContext = getApplicationContext();

    }
}
