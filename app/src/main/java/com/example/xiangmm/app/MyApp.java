package com.example.xiangmm.app;

import android.app.Application;

/**
 * Created by 利用 on 2018/12/21.
 */

public class MyApp extends Application {
    private static  MyApp myApp;


    @Override
    public void onCreate() {
        super.onCreate();
        myApp = this;
    }
    public static  MyApp getMyApp(){
        return  myApp;
    }
}
