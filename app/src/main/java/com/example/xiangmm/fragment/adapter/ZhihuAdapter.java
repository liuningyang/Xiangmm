package com.example.xiangmm.fragment.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import java.util.List;



/**
 * Created by 利用 on 2018/12/24.
 */

public class ZhihuAdapter  extends FragmentPagerAdapter{
    private List<Fragment> fragments;
    private List<String> title;
    public ZhihuAdapter(FragmentManager fm,List<Fragment> fragments,List<String> title) {
        super(fm);
        this.fragments = fragments;
        this.title = title;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }
}
