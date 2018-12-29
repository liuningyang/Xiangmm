package com.example.xiangmm.presenter.zhihu.weixin;

import android.util.Log;

import com.example.xiangmm.base.presenter.IBasePresenter;
import com.example.xiangmm.beans.zhihu.weixin.WXItemBean;
import com.example.xiangmm.model.zhihu.weixin.WeixinModule;

import com.example.xiangmm.view.zhihu.weixin.WeixinView;

/**
 * Created by 利用 on 2018/12/25.
 */

public class WeiXinPresenter <V extends WeixinView> extends IBasePresenter<V> implements WeixinModule.WeixinCallback {
    private WeixinModule mWeixinModule = new WeixinModule();

    public void getWXItemBean(final int page){
        if (mView!= null){
            mWeixinModule.getWXItemBean(this,page);
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
    public void setWXItemBean(WXItemBean data,int page) {
        Log.e("刘洋",data.getNewslist().toString());
        mView.show(data,page);
    }


}
