package com.example.xiangmm.base.presenter;

/**
 * Created by 利用 on 2018/12/21.
 */

public interface BasePresenter<V> {
    //绑定View
    void attachView(V v);
    //解绑View
    void detachView();
}
