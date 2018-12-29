package com.example.xiangmm.http.weixin;

import com.example.xiangmm.beans.zhihu.weixin.WXItemBean;
import com.example.xiangmm.http.HttpManager;

import io.reactivex.Observable;

/**
 * Created by 利用 on 2018/12/25.
 */

public class WeixinManager {
    private static WeixinServer myServer;
    public static WeixinServer getMyServer(){
        if (myServer == null){
            synchronized (WeixinServer.class){
                if (myServer == null){
                    myServer = HttpManager.getInstance().getServer(WeixinServer.HOST,WeixinServer.class);

                }
            }
        }
        return  myServer;
    }

    public Observable<WXItemBean> getWXHot(String key,int num,int page){
        return myServer.getWXHot(key,num,page);
    }

}
