package com.example.xiangmm.base.activity;

import android.app.Activity;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 利用 on 2018/12/21.
 */

public abstract class SimpleActivity extends AppCompatActivity {
    public Activity mActivity;
    private Unbinder bind;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewGroup viewGroup= (ViewGroup) LayoutInflater.from(this).inflate(createLayoutId(),null);
        setContentView(viewGroup);
        bind = ButterKnife.bind(this);
        mActivity = this;
        viewCreated(viewGroup);
        initData();
    }

    protected  void setToobar(Toolbar toobar,String title){
        toobar.setTitle(title);
        setSupportActionBar(toobar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        toobar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }


    public void viewCreated(View view) {
    }

    //初始化数据
    protected abstract void initData();
    //初始化布局
    protected abstract int createLayoutId();



    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bind!= null){
            bind.unbind();
        }
    }
}
