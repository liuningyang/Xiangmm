package com.example.xiangmm.model.zhihu.zhi;

import com.example.xiangmm.base.module.HttpFinishCallback;
import com.example.xiangmm.beans.zhihu.zhi.HotListBean;

import com.example.xiangmm.http.BaseObserver;
import com.example.xiangmm.http.zhi.ZhihuManager;
import com.example.xiangmm.utils.RxUtils;

/**
 * Created by 利用 on 2018/12/24.
 */

public class RemenModule {
    public  interface RemenCallback extends HttpFinishCallback {
        void setHotListBean(HotListBean host);
    }
    public void getHotListBean(final RemenModule.RemenCallback remenCallback) {
        remenCallback.setShowProgressbar();
        ZhihuManager.getMyServer().getHotList()
                .compose(RxUtils.<HotListBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<HotListBean>(remenCallback) {
                    @Override
                    public void onNext(HotListBean value) {
                        remenCallback.setHotListBean(value);
                    }
                });

    }
}
