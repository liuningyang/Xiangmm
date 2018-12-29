package com.example.xiangmm.model.zhihu.zhi;

import com.example.xiangmm.base.module.HttpFinishCallback;
import com.example.xiangmm.beans.zhihu.zhi.SectionListBean;
import com.example.xiangmm.http.BaseObserver;
import com.example.xiangmm.http.zhi.ZhihuManager;
import com.example.xiangmm.utils.RxUtils;

/**
 * Created by 利用 on 2018/12/24.
 */

public class ZhuanlanModule {
    public  interface ZhuanlanCallback extends HttpFinishCallback {
        void setSectionListBean(SectionListBean data);
    }
    public void getSectionListBean(final ZhuanlanModule.ZhuanlanCallback zhuanlanCallback) {
        zhuanlanCallback.setShowProgressbar();
        ZhihuManager.getMyServer().getSectionList()
                .compose(RxUtils.<SectionListBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<SectionListBean>(zhuanlanCallback) {
                    @Override
                    public void onNext(SectionListBean value) {
                        zhuanlanCallback.setSectionListBean(value);
                    }
                });

    }
}
