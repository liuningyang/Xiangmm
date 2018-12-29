package com.example.xiangmm.presenter.zhihu.zhi;

import android.util.Log;

import com.example.xiangmm.base.presenter.IBasePresenter;
import com.example.xiangmm.beans.zhihu.zhi.SectionListBean;
import com.example.xiangmm.model.zhihu.zhi.ZhuanlanModule;

import com.example.xiangmm.view.zhihu.zhi.ZhuanlanView;

/**
 * Created by 利用 on 2018/12/24.
 */

public  class ZhuanlanPresenter <V extends ZhuanlanView> extends IBasePresenter<V> implements ZhuanlanModule.ZhuanlanCallback{
    private ZhuanlanModule mZhuanlanModule = new ZhuanlanModule();

    public  void getSectionListBean(){
        if (mView != null){
            mZhuanlanModule.getSectionListBean(this);
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
    public void setSectionListBean(SectionListBean data) {
        Log.e("刘洋",""+data.getData().toString());
        mView.show(data);
    }
}
