package com.example.xiangmm.model.zhihu.zhi;

import com.example.xiangmm.base.module.HttpFinishCallback;
import com.example.xiangmm.beans.zhihu.zhi.DailyListBean;

import com.example.xiangmm.http.BaseObserver;
import com.example.xiangmm.http.zhi.ZhihuManager;
import com.example.xiangmm.utils.RxUtils;

/**
 * Created by 利用 on 2018/12/27.
 */

public class DailyMoudle  {
    public  interface DailyCallback extends HttpFinishCallback {
        void setDailyListBean(DailyListBean host);
    }
    public void getHotListBean(final DailyMoudle.DailyCallback dailyCallback) {
        dailyCallback.setShowProgressbar();
        ZhihuManager.getMyServer().getDailyList()
                .compose(RxUtils.<DailyListBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<DailyListBean>(dailyCallback) {
                    @Override
                    public void onNext(DailyListBean value) {
                        dailyCallback.setDailyListBean(value);
                    }
                });

    }
}
