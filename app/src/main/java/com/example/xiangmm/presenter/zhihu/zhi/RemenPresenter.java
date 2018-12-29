package com.example.xiangmm.presenter.zhihu.zhi;

import android.util.Log;

import com.example.xiangmm.base.presenter.IBasePresenter;
import com.example.xiangmm.beans.zhihu.zhi.HotListBean;
import com.example.xiangmm.model.zhihu.zhi.RemenModule;
import com.example.xiangmm.view.zhihu.zhi.RemenView;


/**
 * Created by 利用 on 2018/12/24.
 */

public  class RemenPresenter<V extends RemenView> extends IBasePresenter<V> implements RemenModule.RemenCallback {
    private RemenModule mRemenModule = new RemenModule();
    public void  getHotListBean(){
        if (mView != null){
            mRemenModule.getHotListBean(this);
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
    public void setHotListBean(HotListBean host) {
        Log.e("刘洋",""+host.getRecent()
                .toString());

        mView.show(host);
    }
}
