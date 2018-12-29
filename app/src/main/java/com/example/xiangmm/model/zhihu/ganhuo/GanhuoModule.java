package com.example.xiangmm.model.zhihu.ganhuo;

import com.example.xiangmm.base.module.HttpFinishCallback;
import com.example.xiangmm.beans.zhihu.ganhuo.GankItemBean;

import com.example.xiangmm.http.BaseObserver;
import com.example.xiangmm.http.ganhuo.GanhuoManager;

import com.example.xiangmm.utils.RxUtils;

/**
 * Created by 利用 on 2018/12/26.
 */

public class GanhuoModule {
    public  interface GanhuoCallback extends HttpFinishCallback {
        void setGankItemBean(GankItemBean data, String tech,int page);
        void setGankBean(GankItemBean data);

    }
    public void getTechList(final GanhuoCallback ganhuoCallback, final String tech, final int page ) {
        ganhuoCallback.setShowProgressbar();

        GanhuoManager.getGanhuoServer().getTechList(tech,10,page)
                .compose(RxUtils.<GankItemBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<GankItemBean>(ganhuoCallback) {


                    @Override
                    public void onNext(GankItemBean value) {
                        ganhuoCallback.setGankItemBean(value,tech,page);
                    }
                });

    }
    public void getRandomGirl(final GanhuoCallback ganhuoCallback ) {
        ganhuoCallback.setShowProgressbar();

        GanhuoManager.getGanhuoServer().getRandomGirl(10)
                .compose(RxUtils.<GankItemBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<GankItemBean>(ganhuoCallback) {


                    @Override
                    public void onNext(GankItemBean value) {
                        ganhuoCallback.setGankBean(value);
                    }
                });

    }

}
