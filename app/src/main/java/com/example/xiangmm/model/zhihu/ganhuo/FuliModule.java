package com.example.xiangmm.model.zhihu.ganhuo;

import com.example.xiangmm.base.module.HttpFinishCallback;
import com.example.xiangmm.beans.zhihu.ganhuo.GankItemBean;
import com.example.xiangmm.http.BaseObserver;
import com.example.xiangmm.http.ganhuo.FuliManager;
import com.example.xiangmm.http.ganhuo.GanhuoManager;
import com.example.xiangmm.utils.RxUtils;

/**
 * Created by 利用 on 2018/12/26.
 */

public class FuliModule {
    public  interface FuliCallback extends HttpFinishCallback {

        void setFuLi(GankItemBean data,int page);

    }
    public void getGirlList(final FuliCallback fuliCallback,final int page ) {
        fuliCallback.setShowProgressbar();

        FuliManager.getGanhuoServer().getGirlList(10,page)
                .compose(RxUtils.<GankItemBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<GankItemBean>(fuliCallback) {


                    @Override
                    public void onNext(GankItemBean value) {
                        fuliCallback.setFuLi(value,page);
                    }
                });

    }
}
