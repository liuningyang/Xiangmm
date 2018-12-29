package com.example.xiangmm.base.presenter;



import java.lang.ref.WeakReference;

/**
 * Created by 利用 on 2018/12/21.
 */

public class IBasePresenter<V> implements BasePresenter<V> {
    //弱引用
    private WeakReference<V> weakReference;
    public V mView;
    @Override
    public void attachView(V v) {
        weakReference = new WeakReference<V>(v);
        mView = weakReference.get();
    }

    @Override
    public void detachView() {
         if (weakReference != null && weakReference.get()!= null){
             weakReference.clear();
             weakReference = null;
         }
    }
}
