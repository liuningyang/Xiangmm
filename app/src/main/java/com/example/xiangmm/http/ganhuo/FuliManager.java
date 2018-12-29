package com.example.xiangmm.http.ganhuo;

import com.example.xiangmm.beans.zhihu.ganhuo.GankItemBean;
import com.example.xiangmm.http.HttpManager;

import io.reactivex.Observable;

/**
 * Created by 利用 on 2018/12/26.
 */

public class FuliManager {
    private static GanhuoServer sGanhuoServer;
    public static GanhuoServer getGanhuoServer(){
        if (sGanhuoServer == null){
            synchronized (GanhuoServer.class){
                if (sGanhuoServer == null){
                    sGanhuoServer = HttpManager.getInstance().getServer(GanhuoServer.HOST,GanhuoServer.class);
                }
            }
        }
        return sGanhuoServer;
    }
    public Observable<GankItemBean> getGirlList(int num, int page){
        return sGanhuoServer.getGirlList(num,page);
    }
}
