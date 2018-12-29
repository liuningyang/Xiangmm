package com.example.xiangmm.presenter.zhihu.zhi;

import android.util.Log;

import com.example.xiangmm.base.presenter.IBasePresenter;
import com.example.xiangmm.beans.zhihu.zhi.DailyListBean;
import com.example.xiangmm.beans.zhihu.zhi.HotListBean;
import com.example.xiangmm.model.zhihu.zhi.DailyMoudle;
import com.example.xiangmm.model.zhihu.zhi.RemenModule;
import com.example.xiangmm.view.zhihu.zhi.DailyView;

/**
 * Created by 利用 on 2018/12/27.
 */

public class DailyPresenter <V extends DailyView> extends IBasePresenter<V> implements DailyMoudle.DailyCallback{
    private DailyMoudle mDailyMoudle = new DailyMoudle();
    public void  getHotListBean(){
        if ( mView!= null){
            mDailyMoudle.getHotListBean(this);
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
    public void setDailyListBean(DailyListBean host) {
        mView.show(host);
    }
}
