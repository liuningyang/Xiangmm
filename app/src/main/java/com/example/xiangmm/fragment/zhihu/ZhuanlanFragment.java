package com.example.xiangmm.fragment.zhihu;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xiangmm.R;
import com.example.xiangmm.base.fragment.BaseFragment;
import com.example.xiangmm.beans.zhihu.zhi.SectionListBean;
import com.example.xiangmm.fragment.adapter.ZhuanlanAdapter;
import com.example.xiangmm.presenter.zhihu.zhi.ZhuanlanPresenter;
import com.example.xiangmm.view.zhihu.zhi.ZhuanlanView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhuanlanFragment extends BaseFragment<ZhuanlanView,ZhuanlanPresenter<ZhuanlanView>> implements ZhuanlanView{


    private RecyclerView rec;
    private List<SectionListBean.DataBean> list = new ArrayList<>();
    private ZhuanlanAdapter mZhuanlanAdapter;
    private SwipeRefreshLayout sw_refresh;

    public ZhuanlanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_zhuanlan, container, false);
        initView(view);
        return view;
    }

    @Override
    public int createLayoutId() {
        return 0;
    }

    @Override
    protected void initData() {
        presenter.getSectionListBean();
    }

    private void initView(View view) {
        rec = (RecyclerView) view.findViewById(R.id.rec);
        mZhuanlanAdapter = new ZhuanlanAdapter(list, getContext());
        rec.setAdapter(mZhuanlanAdapter);
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 2);
        rec.setLayoutManager(manager);
        sw_refresh = (SwipeRefreshLayout) view.findViewById(R.id.sw_refresh);
        sw_refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                 presenter.getSectionListBean();
            }
        });


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
    public void show(SectionListBean sectionListBean) {
        List<SectionListBean.DataBean> dataBeans = sectionListBean.getData();
        list.addAll(dataBeans);
        mZhuanlanAdapter.notifyDataSetChanged();

    }

    @Override
    protected ZhuanlanPresenter<ZhuanlanView> createPresenter() {
        return new ZhuanlanPresenter<>();
    }
}
