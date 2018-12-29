package com.example.xiangmm.presenter.zhihu.ganhuo;


import android.util.Log;

import com.example.xiangmm.base.presenter.IBasePresenter;
import com.example.xiangmm.beans.zhihu.ganhuo.GankItemBean;

import com.example.xiangmm.model.zhihu.ganhuo.FuliModule;

import com.example.xiangmm.view.zhihu.ganhuo.FuliView;

/**
 * Created by 利用 on 2018/12/26.
 */

public class FuliPresenter<V extends FuliView> extends IBasePresenter<V> implements FuliModule.FuliCallback {
    private FuliModule mFuliModule = new FuliModule();

    public void getGirlList(int page){
        if (mView != null){
            mFuliModule.getGirlList(this,page);
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
        if (mView != null){
            mView.showError(error);
        }
    }

    @Override
    public void setFuLi(GankItemBean data, int page) {
        Log.e("刘洋",data.getResults().toString());
        mView.show(data,page);
    }
}
