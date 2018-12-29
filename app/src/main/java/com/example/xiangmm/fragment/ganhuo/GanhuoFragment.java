package com.example.xiangmm.fragment.ganhuo;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xiangmm.R;
import com.example.xiangmm.base.fragment.SimpleFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class GanhuoFragment extends SimpleFragment {


    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;

    private List<Fragment> list = new ArrayList<>();
    private List<String> title = new ArrayList<>();
    private GanhuoAdapter mGanhuoAdapter;

    public GanhuoFragment() {
        // Required empty public constructor
    }
    @Override
    public int createLayoutId() {
        return R.layout.fragment_ganhuo2;
    }

    @Override
    protected void initData() {
        title.add("Android");
        title.add("IOS");
        title.add("前端");

        for (int i = 0; i < title.size(); i++) {
            list.add(new AFragment(title.get(i)));
        }
        title.add("福利");
        list.add(new FuliFragment());
        mGanhuoAdapter = new GanhuoAdapter(getChildFragmentManager(), list, title);
        vp.setAdapter(mGanhuoAdapter);
        tab.setupWithViewPager(vp);

    }

}
