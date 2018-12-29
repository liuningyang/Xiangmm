package com.example.xiangmm.fragment.weixin;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xiangmm.R;
import com.example.xiangmm.base.fragment.BaseFragment;
import com.example.xiangmm.beans.zhihu.weixin.WXItemBean;
import com.example.xiangmm.fragment.adapter.WeixinAdapter;
import com.example.xiangmm.presenter.zhihu.weixin.WeiXinPresenter;
import com.example.xiangmm.view.zhihu.weixin.WeixinView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeiChatFragment extends BaseFragment<WeixinView,WeiXinPresenter<WeixinView>> implements WeixinView, XRecyclerView.LoadingListener {


    private XRecyclerView xrec;
    private SwipeRefreshLayout sw_refresh;
    List<WXItemBean.NewslistBean> mlist = new ArrayList<>();
    private WeixinAdapter mWeixinAdapter;
    private int page = 1;

    public WeiChatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wei_chat, container, false);
        initView(view);
        return view;
    }

    @Override
    public int createLayoutId() {
        return 0;
    }

    @Override
    protected void initData() {
        presenter.getWXItemBean(page);
    }

    private void initView(View view) {
        xrec = (XRecyclerView) view.findViewById(R.id.xrec);
        sw_refresh = (SwipeRefreshLayout) view.findViewById(R.id.sw_refresh);
        mWeixinAdapter = new WeixinAdapter(getContext(),mlist);
        xrec.setAdapter(mWeixinAdapter);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        xrec.setLayoutManager(manager);
        xrec.setLoadingListener(this);
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
    public void show(WXItemBean wxItemBean,int page) {
        List<WXItemBean.NewslistBean> newslistBeans = wxItemBean.getNewslist();
        mlist.addAll(newslistBeans);
        mWeixinAdapter.notifyDataSetChanged();
    }

    @Override
    protected WeiXinPresenter<WeixinView> createPresenter() {
        return new WeiXinPresenter<>();
    }

    @Override
    public void onRefresh() {
        page=1;
        presenter.getWXItemBean(page);
        xrec.refreshComplete();
    }

    @Override
    public void onLoadMore() {
        page++;
         presenter.getWXItemBean(page);
         xrec.loadMoreComplete();
    }
}
