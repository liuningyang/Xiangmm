package com.example.xiangmm.model.zhihu.weixin;

import com.example.xiangmm.base.module.HttpFinishCallback;



import com.example.xiangmm.beans.zhihu.weixin.WXItemBean;
import com.example.xiangmm.http.BaseObserver;


import com.example.xiangmm.http.weixin.WeixinManager;

import com.example.xiangmm.utils.RxUtils;

/**
 * Created by 利用 on 2018/12/25.
 */

public class WeixinModule {
    public  interface WeixinCallback extends HttpFinishCallback {
        void setWXItemBean(WXItemBean data,int page);
    }
    public void getWXItemBean(final WeixinModule.WeixinCallback weixinCallback, final int page) {
        weixinCallback.setShowProgressbar();

        WeixinManager.getMyServer().getWXHot("52b7ec3471ac3bec6846577e79f20e4c",10,page)
                .compose(RxUtils.<WXItemBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<WXItemBean>(weixinCallback) {

                    @Override
                    public void onNext(WXItemBean value) {
                        weixinCallback.setWXItemBean(value,page);
                    }
                });

    }
}
