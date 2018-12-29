package com.example.xiangmm.http;



import com.example.xiangmm.app.MyApp;
import com.example.xiangmm.utils.SystemUtil;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 利用 on 2018/12/21.
 */

public class HttpManager {
    private static  HttpManager httpManager;
    private HttpManager(){

    }
    public  static  HttpManager getInstance(){
        if (httpManager == null){
            synchronized (HttpManager.class){
                if (httpManager == null){
                    httpManager = new HttpManager();
                }
            }
        }
        return httpManager;
    }
    public Retrofit getRetrofit(String basUrl){
        return  new Retrofit.Builder()
                .baseUrl(basUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(getOkhttpClient())
                .build();
    }

    private OkHttpClient getOkhttpClient() {
        //缓存文件定义：缓存到当前项目的包路径下
        Cache cache = new Cache(new File(MyApp.getMyApp().getCacheDir(), "Cache"), 1024 * 1024 * 10);
        //网络请求的Log日志输出
        HttpLoggingInterceptor httpLoggingInterceptor =  new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        MyCacheinterceptor myCacheinterceptor = new MyCacheinterceptor();

        return new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5,TimeUnit.SECONDS)
                .readTimeout(5,TimeUnit.SECONDS)
                .cache(cache)
                .addInterceptor(myCacheinterceptor)
                .addNetworkInterceptor(myCacheinterceptor)
                .retryOnConnectionFailure(true)
                .build();
    }
    //缓存拦截器
    private class  MyCacheinterceptor implements Interceptor{

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            //判断网络条件，如果有网络，我们直接获取网络上的数据，没网络的话，就去缓存里面取数据
            if (!SystemUtil.isNetworkConnected()){
                request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();

            }
            Response response = chain.proceed(request);
            if (SystemUtil.isNetworkConnected()){
                int maxAge = 0;
                return response.newBuilder()
                        //清除头信息，服务器如果不支持，会返回干扰信息，不清除下面不能生效
                      .removeHeader("Pragma")
                        .header("Cache-Control","public,max-age="+maxAge)
                        .build();

            }
            else {
                int maxStale = 60 * 60 * 24 * 7;
                return response.newBuilder()
                        .removeHeader("Pragma")
                        //这里的设置的是我们的没有网络的缓存时间，想设置多少就是多少。
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        .build();
            }

        }
    }
    public <S> S getServer(String baseUrl,Class<S> tSClass){
        return getRetrofit(baseUrl).create(tSClass);
    }
}
