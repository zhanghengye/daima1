package com.example.administrator.zijixiangmu.utils;

import java.lang.reflect.ParameterizedType;

/**
 * Created by Administrator on 2018/5/30.
 */

public class Utilss {
    public static <T>T getT(Object o,int i){

        try {
            return ((Class<T>)(((ParameterizedType)(o.getClass().getGenericSuperclass())).getActualTypeArguments()[i])).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }
    public static Class<?> forName(String className){

        try {
            return  Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    return null;
    }

}
