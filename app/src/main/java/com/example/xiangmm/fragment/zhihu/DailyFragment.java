package com.example.xiangmm.fragment.zhihu;


import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.xiangmm.R;
import com.example.xiangmm.base.fragment.BaseFragment;
import com.example.xiangmm.beans.zhihu.zhi.DailyListBean;
import com.example.xiangmm.fragment.activitys.CalendarActivity;
import com.example.xiangmm.presenter.zhihu.zhi.DailyPresenter;
import com.example.xiangmm.view.zhihu.zhi.DailyView;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class DailyFragment extends BaseFragment<DailyView, DailyPresenter<DailyView>> implements DailyView, MyAdapter.OnClickListener {


    @BindView(R.id.view_main)
    RecyclerView mViewMain;
    @BindView(R.id.fab_calender)
    FloatingActionButton mFabCalender;

    @BindView(R.id.banner)
    Banner mBanner;


    private List<DailyListBean.TopStoriesBean> list = new ArrayList<>();
    private MyAdapter mMyAdapter;

    public DailyFragment() {
        // Required empty public constructor
    }


    @Override
    public int createLayoutId() {
        return R.layout.fragment_daily;
    }

    @Override
    protected void initData() {
        mMyAdapter = new MyAdapter(list, mActivity);
        mViewMain.setAdapter(mMyAdapter);
        LinearLayoutManager manager = new LinearLayoutManager(mActivity);
        mViewMain.setLayoutManager(manager);
        presenter.getHotListBean();
        mFabCalender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mActivity,CalendarActivity.class);
                startActivity(intent);
            }
        });
        mMyAdapter.setOnClickListener(this);


    }

    @Override
    protected DailyPresenter<DailyView> createPresenter() {
        return new DailyPresenter<>();
    }


    @Override
    public void showProgressbar() {

    }

    @Override
    public void hideProgressbar() {

    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void show(DailyListBean dailyListBean) {
        List<DailyListBean.TopStoriesBean> top_stories = dailyListBean.getTop_stories();

                  List<String> imgs = new ArrayList<>();
                  for (int i = 0; i <top_stories.size() ; i++) {
                      String url = top_stories.get(i).getImage();
                      imgs.add(url);
                  }
                  list.addAll(top_stories);
                  mMyAdapter.notifyDataSetChanged();
                  mBanner.setImages(imgs);
                   mBanner.setImageLoader(new ImageLoader() {
                      @Override
                      public void displayImage(Context context, Object path, ImageView imageView) {
                              String url = (String) path;
                          Glide.with(context).load(url)
                                  .into(imageView);
                      }
                  });
                  mBanner.setDelayTime(3000);
                   mBanner.start();

    }


    @Override
    public void onClick(int position) {
       /* Intent intent1 = new Intent(mActivity,DailyActivity.class);
        startActivity(intent1);*/
    }
}
