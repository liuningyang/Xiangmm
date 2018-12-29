package com.example.xiangmm.fragment.zhihu;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xiangmm.R;
import com.example.xiangmm.fragment.adapter.ZhihuAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhihuFragment extends Fragment {


    private TabLayout tab;
    private ViewPager vp;
    private ZhihuAdapter mAdapter;

    List<Fragment> fragments = new ArrayList<>();
    List<String> title = new ArrayList<>();

    public ZhihuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_zhihu, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        tab = (TabLayout) view.findViewById(R.id.tab);
        vp = (ViewPager) view.findViewById(R.id.vp);
        fragments.add(new DailyFragment());
        fragments.add(new ZhutiFragment());
        fragments.add(new ZhuanlanFragment());
        fragments.add(new RemenFragment());
        title.add("日报");
        title.add("主题");
        title.add("专栏");
        title.add("热门");
        mAdapter = new ZhihuAdapter(getChildFragmentManager(),fragments,title);
        vp.setAdapter(mAdapter);
        tab.setupWithViewPager(vp);

    }
}
