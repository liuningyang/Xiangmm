package com.example.xiangmm.http;




import com.example.xiangmm.base.module.HttpFinishCallback;

import java.util.logging.Logger;

import io.reactivex.disposables.CompositeDisposable;
import retrofit2.HttpException;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


/**
 * Created by 利用 on 2018/12/21.
 */

public abstract class BaseObserver<T> implements Observer<T> {
    //回调结果处理
    private HttpFinishCallback httpFinishCallback;

    public BaseObserver(HttpFinishCallback httpFinishCallback) {
        this.httpFinishCallback = httpFinishCallback;
    }
    //管理内存网络请求
    private CompositeDisposable comositeDisposable = new CompositeDisposable();

    @Override
    public void onSubscribe(Disposable d) {
        comositeDisposable.add(d);
    }
    @Override
    public void onError(Throwable e) {
        if(comositeDisposable!=null){
            comositeDisposable.clear();
        }
        if(httpFinishCallback!=null){
            if(e instanceof HttpException){
                httpFinishCallback.setError("网络请求错误");
            }else {
                httpFinishCallback.setError("其他请求错误");
            }
            Logger.getLogger(e.getMessage());
            httpFinishCallback.setHideProgressbar();
        }


    }

    @Override
    public void onComplete() {
        if(comositeDisposable!=null){
            comositeDisposable.clear();
        }
        if(httpFinishCallback!=null){
            httpFinishCallback.setHideProgressbar();
        }

    }

}
