package com.example.xiangmm.presenter.zhihu.shuju;

import android.util.Log;

import com.example.xiangmm.base.presenter.IBasePresenter;
import com.example.xiangmm.beans.zhihu.shuju.News;

import com.example.xiangmm.beans.zhihu.shuju.XinWenInfon;
import com.example.xiangmm.model.zhihu.shuju.ShujuModule;
import com.example.xiangmm.view.zhihu.shuju.ShujuView;

/**
 * Created by 利用 on 2018/12/27.
 */

public class ShujuPresenter<V extends ShujuView> extends IBasePresenter<V> implements ShujuModule.ShujuCallback {
    private static ShujuModule sShujuModule = new ShujuModule();
    public void getNews(){
        if (mView!= null){
            sShujuModule.getNews(this);
        }
    }
    public  void getXinWen(String category,int page){
        if (mView!= null){
            sShujuModule.getXinWen(this,category,page);
        }
    }
    @Override
    public void setShowProgressbar() {

    }

    @Override
    public void setHideProgressbar() {

    }

    @Override
    public void setError(String error) {

    }

    @Override
    public void setNewsBean(News data) {
        Log.e("刘洋",data.getRESULT().toString());
        mView.show(data);
    }

    @Override
    public void setXinWen(XinWenInfon data, String category, int page) {
        Log.e("刘洋",data.getRESULT().getNewsList().toString());
        mView.show1(data,category,page);
    }
}
