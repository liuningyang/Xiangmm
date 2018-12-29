package com.example.xiangmm.http.zhi;



import com.example.xiangmm.beans.zhihu.zhi.DailyListBean;
import com.example.xiangmm.beans.zhihu.zhi.SectionListBean;
import com.example.xiangmm.http.HttpManager;

import io.reactivex.Observable;

/**
 * Created by 利用 on 2018/12/21.
 */

public class ZhihuManager {
    private static ZhihuApis myServer;
    public static ZhihuApis getMyServer(){
        if (myServer == null){
            synchronized (ZhihuApis.class){
                if (myServer == null){
                    myServer = HttpManager.getInstance().getServer(ZhihuApis.HOST,ZhihuApis.class);

                }
            }
        }
        return  myServer;
    }

    public Observable<DailyListBean> getDailyList(){
        return myServer.getDailyList();
    }
    public Observable<SectionListBean> getSectionList(){
        return myServer.getSectionList();
    }
}
