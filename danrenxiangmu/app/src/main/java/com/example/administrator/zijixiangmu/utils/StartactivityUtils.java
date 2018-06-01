package com.example.administrator.zijixiangmu.utils;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by Administrator on 2018/5/30.
 */

public class StartactivityUtils {

    public static void startactivity(Activity fromactivity,Class<? extends Activity> toactivity){
        Intent intent = new Intent(fromactivity, toactivity);
        fromactivity.startActivity(intent);
    }


}
