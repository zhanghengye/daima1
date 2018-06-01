package com.example.administrator.zijixiangmu.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Administrator on 2018/5/31.
 */

public class NetUtils {
    public static boolean isNet(Context context){
        ConnectivityManager cm= (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
            if(cm==null){
                return false;
            }else{
                if(cm.getActiveNetworkInfo()==null){
                    return  false;

                }else{
                    if(cm.getActiveNetworkInfo().getState()== NetworkInfo.State.CONNECTED){
                        return true;
                    }
                    return false;
                }
            }


    }


}
