package com.example.xiangmm.presenter.zhihu.ganhuo;

import android.util.Log;

import com.example.xiangmm.base.presenter.IBasePresenter;
import com.example.xiangmm.beans.zhihu.ganhuo.GankItemBean;
import com.example.xiangmm.model.zhihu.ganhuo.GanhuoModule;
import com.example.xiangmm.view.zhihu.ganhuo.GanhuoView;

/**
 * Created by 利用 on 2018/12/26.
 */

public class GanHuoPresenter<V extends GanhuoView> extends IBasePresenter<V> implements GanhuoModule.GanhuoCallback {
    private GanhuoModule mGanhuoModule = new GanhuoModule();
    public void getTechList(String tech,int page){
        if (mView != null){
            mGanhuoModule.getTechList(this,tech,page);
        }
    }
    public void getRandomGirl(){
        if (mView != null){
            mGanhuoModule.getRandomGirl(this);
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
    public void setGankItemBean(GankItemBean data,String tech, int page) {
        Log.e("刘洋",data.getResults().toString());
        mView.show(data,tech,page);
    }

    @Override
    public void setGankBean(GankItemBean data) {
        Log.e("刘洋",data.getResults().toString());
        mView.show1(data);
    }


}
