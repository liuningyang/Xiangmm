package com.example.xiangmm.http.shuju;

import com.example.xiangmm.beans.zhihu.shuju.News;
import com.example.xiangmm.beans.zhihu.shuju.XinWenInfon;
import com.example.xiangmm.beans.zhihu.weixin.WXItemBean;
import com.example.xiangmm.http.HttpManager;
import com.example.xiangmm.http.weixin.WeixinServer;

import io.reactivex.Observable;

/**
 * Created by 利用 on 2018/12/27.
 */

public class ShujuManager {
    private static ShujuServer sShujuServer;
    public static ShujuServer getShujuServer(){
        if (sShujuServer == null){
            synchronized (ShujuServer.class){
                if (sShujuServer == null){
                    sShujuServer = HttpManager.getInstance().getServer(ShujuServer.HOST,ShujuServer.class);

                }
            }
        }
        return  sShujuServer;
    }

    public Observable<News> getNews(String appkey){
        return sShujuServer.getNews(appkey);
    }
    public Observable<XinWenInfon> getXinWen(String appkey,String category,int page){
        return sShujuServer.getXinWen(appkey,category,page);
    }
}
