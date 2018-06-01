package com.example.administrator.zijixiangmu.message;

import com.example.administrator.zijixiangmu.App;
import com.example.administrator.zijixiangmu.Constants;
import com.example.administrator.zijixiangmu.utils.NetUtils;
import com.google.gson.Gson;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018/5/31.
 */

public class RetrofitMessage {
    public static String BaseUrl= Constants.Web;
    private static OkHttpClient mOkHttpClient;
    private Retrofit mRetrofit;
    public Retrofit build(){
        initOkHttpClient();
        initRetrofit();
        return mRetrofit;
    }
    public RetrofitMessage(){

    }
    private void initOkHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        Interceptor mInterceptor=chain -> {
            Request request = chain.request();
            if(!NetUtils.isNet(App.context())){
                request=request.newBuilder()
                .cacheControl(CacheControl.FORCE_CACHE)
                .build();
            }
            Response response = chain.proceed(request);
            if(NetUtils.isNet(App.context())){
                String s = request.cacheControl().toString();
                return response.newBuilder().header("Cache-Control",s)
                        .removeHeader("Pragma")
                        .build();
            }else{
                return response.newBuilder()
                        .header("Cache-Control","public, only-if-cached, max-stale=2419200")
                        .removeHeader("Pragma")
                        .build();
            }
        };
    if(mOkHttpClient==null){
        synchronized (RetrofitMessage.class){
            if(mOkHttpClient==null){
                Cache cache = new Cache(new File(App.context().getCacheDir(), "Httpcache"), 1024 * 1024 * 100);
                mOkHttpClient = new OkHttpClient.Builder()
                        .cache(cache)
                        .retryOnConnectionFailure(true)
                        .connectTimeout(15, TimeUnit.SECONDS)
                        .addInterceptor(interceptor)
                        .build();
            }
        }
    }


    }

    private void initRetrofit() {
        mRetrofit=new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

    }
    public void setBaseURL(String baseURL) {
        BaseUrl = baseURL;
    }
}
