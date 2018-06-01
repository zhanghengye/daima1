package com.example.administrator.zijixiangmu.base;

import com.example.administrator.zijixiangmu.bean.Accounts;
import com.example.administrator.zijixiangmu.bean.Li;
import com.example.administrator.zijixiangmu.bean.ZuiLi;

import rx.Observable;

/**
 * Created by Administrator on 2018/5/30.
 */

public class GouWuContract {

   public interface View extends BaseView {
      void getUrlDataOk(int code);
      void getUrlDataNo(String str);
    }

   public interface Model extends BaseModel {
        Observable<Li<ZuiLi>> getLogin(String phone,String pas);
        Observable<Li<String>> getLoginYanZhengma(String phone,String type);
       Observable<Li<ZuiLi>> loginYanZhengDenglu(String phone, String code);
       Observable<Li<String>> zhuceYanZheng(String phone,String code,String type);
       Observable<Li<ZuiLi>> XinMiMa(String phone,String paw,String code);
    }

   public abstract static class Presenter extends BasePresenter<Model, View> {
           public abstract void loginPas(String phone,String psw);
           public abstract  void loginYanZheng(String phone,String type);
           public abstract void loginYanZhengDenglu(String phone,String code);
           public abstract void YanzhengYanzheng(String phone,String code,String type);
           public abstract void XinMiMa(String phone,String paw,String code);
    }
}