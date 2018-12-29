package com.example.xiangmm.model.zhihu.shuju;

import com.example.xiangmm.base.module.HttpFinishCallback;
import com.example.xiangmm.beans.zhihu.shuju.News;
import com.example.xiangmm.beans.zhihu.shuju.XinWenInfon;
import com.example.xiangmm.beans.zhihu.weixin.WXItemBean;
import com.example.xiangmm.http.BaseObserver;
import com.example.xiangmm.http.shuju.ShujuManager;
import com.example.xiangmm.http.weixin.WeixinManager;
import com.example.xiangmm.model.zhihu.weixin.WeixinModule;
import com.example.xiangmm.utils.RxUtils;

/**
 * Created by 利用 on 2018/12/27.
 */

public class ShujuModule {
    public  interface ShujuCallback extends HttpFinishCallback {
        void setNewsBean(News data);
        void setXinWen(XinWenInfon data,String category,int page);
    }
    public void getNews(final ShujuModule.ShujuCallback shujuCallback) {
        shujuCallback.setShowProgressbar();

        ShujuManager.getShujuServer().getNews("52047fa93a24422c868d6f27dace76ab")
                .compose(RxUtils.<News>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<News>(shujuCallback) {

                    @Override
                    public void onNext(News value) {
                        shujuCallback.setNewsBean(value);
                    }
                });

    }
    public void getXinWen(final ShujuModule.ShujuCallback shujuCallback,final String category,final  int page ) {
        shujuCallback.setShowProgressbar();

        ShujuManager.getShujuServer().getXinWen("52047fa93a24422c868d6f27dace76ab",category,page)
                .compose(RxUtils.<XinWenInfon>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<XinWenInfon>(shujuCallback) {

                    @Override
                    public void onNext(XinWenInfon value) {
                        shujuCallback.setXinWen(value,category,page);
                    }
                });

    }
}
