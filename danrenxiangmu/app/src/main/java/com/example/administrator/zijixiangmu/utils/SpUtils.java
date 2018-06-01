package com.example.administrator.zijixiangmu.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2018/6/1.
 */

public class SpUtils {

    public SpUtils() {

    }

    public static void setPhone(Context context,String name,String phone, Object psw){
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        if(psw instanceof String){
            edit.putString(phone,(String)psw);
        }else if(psw instanceof Integer){
            edit.putInt(phone,(Integer) psw);
        }else if(psw instanceof Boolean){
            edit.putBoolean(phone,(Boolean)psw);
        }else if(psw instanceof Long){
            edit.putLong(phone,(Long)psw);
        }else if(psw instanceof Float){
            edit.putFloat(phone,(Float)psw);
        }else{
            edit.putString(phone,psw.toString());
        }
        edit.commit();
    }
    public static Object getPhone(Context context,String name,String phone, Object  defaultObject){
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        if(defaultObject instanceof String){
           return sp.getString(phone,(String)defaultObject);
        }else if(defaultObject instanceof Integer){
            return sp.getInt(phone,(Integer) defaultObject);
        }else if(defaultObject instanceof Boolean){
            return  sp.getBoolean(phone,(Boolean)defaultObject);
        }else if(defaultObject instanceof Long){
            return sp.getLong(phone,(Long)defaultObject);
        }else if(defaultObject instanceof Float){
            return sp.getFloat(phone,(Float)defaultObject);
        }else{
            return sp.getString(phone,defaultObject.toString());
        }
    }

}
