package com.example.xiangmm.fragment.shuju;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.xiangmm.R;
import com.example.xiangmm.base.fragment.BaseFragment;
import com.example.xiangmm.beans.zhihu.shuju.News;
import com.example.xiangmm.beans.zhihu.shuju.XinWenInfon;
import com.example.xiangmm.presenter.zhihu.shuju.ShujuPresenter;
import com.example.xiangmm.view.zhihu.shuju.ShujuView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShujuFragment extends BaseFragment<ShujuView, ShujuPresenter<ShujuView>> implements ShujuView {


    @BindView(R.id.ttb)
    TabLayout mTtb;
    @BindView(R.id.vvp)
    ViewPager mVvp;



    private List<Fragment> list = new ArrayList<>();
    private List<String> title = new ArrayList<>();
    private MyAdapter adapter;

    public ShujuFragment() {
        // Required empty public constructor
    }


    @Override
    public int createLayoutId() {
        return R.layout.fragment_shuju;
    }

    @Override
    protected void initData() {
        adapter = new MyAdapter(getChildFragmentManager(), list, title);
        mVvp.setAdapter(adapter);
        mTtb.setupWithViewPager(mVvp);
        presenter.getNews();

    }


    @Override
    protected ShujuPresenter<ShujuView> createPresenter() {
        return new ShujuPresenter<>();
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
    public void show(News news) {
        List<String> result = news.getRESULT();
        title.addAll(result);
        for (int i = 0; i < title.size(); i++) {
            OneFragment oneFragment = new OneFragment();
            list.add(oneFragment);
            String category = title.get(i);
            oneFragment.setCategory(category);
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void show1(XinWenInfon xinWenInfon, String category, int page) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }
}
