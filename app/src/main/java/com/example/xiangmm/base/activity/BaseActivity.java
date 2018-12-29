package com.example.xiangmm.base.activity;


import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.xiangmm.R;
import com.example.xiangmm.base.presenter.BasePresenter;
import com.example.xiangmm.base.presenter.IBasePresenter;
import com.example.xiangmm.base.view.BaseView;

/**
 * Created by 利用 on 2018/12/21.
 */

public abstract class BaseActivity<V,P extends IBasePresenter<V>> extends SimpleActivity implements BaseView{
    private ProgressBar mProgressBar;
    public P presenter;


    @Override
    public void viewCreated(View view) {
        super.viewCreated(view);
        View view1 = View.inflate(this, R.layout.layout_progressbar,(ViewGroup) view);
         mProgressBar = view1.findViewById(R.id.progressBar);
        presenter = createPresenter();
        if (presenter != null) {
            presenter.attachView((V) this);
        }
    }

    @Override
    public void showProgressbar() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressbar() {
        mProgressBar.setVisibility(View.GONE);
    }

    //创建子类的P层对象
    protected abstract P createPresenter();



    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter!= null){
            presenter.detachView();
            presenter = null;
        }
    }
}
