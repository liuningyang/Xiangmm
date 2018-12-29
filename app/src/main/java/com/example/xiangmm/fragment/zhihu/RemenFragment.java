package com.example.xiangmm.fragment.zhihu;


import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.xiangmm.R;
import com.example.xiangmm.base.fragment.BaseFragment;
import com.example.xiangmm.beans.zhihu.zhi.HotListBean;
import com.example.xiangmm.fragment.adapter.RemenAdapter;
import com.example.xiangmm.presenter.zhihu.zhi.RemenPresenter;
import com.example.xiangmm.view.zhihu.zhi.RemenView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class RemenFragment extends BaseFragment<RemenView, RemenPresenter<RemenView>> implements RemenView {


    @BindView(R.id.rec)
    RecyclerView rec;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipe_refresh;

    private List<HotListBean.RecentBean> list = new ArrayList<>();
    private RemenAdapter mRemenAdapter;

    public RemenFragment() {
        // Required empty public constructor
    }


    @Override
    public int createLayoutId() {
        return R.layout.fragment_remen;
    }

    @Override
    protected void initData() {
        mRemenAdapter = new RemenAdapter(list, getContext());
        rec.setAdapter(mRemenAdapter);
        LinearLayoutManager manager = new LinearLayoutManager(mActivity);
        rec.setLayoutManager(manager);
        presenter.getHotListBean();
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
    public void show(HotListBean hotListBean) {
        List<HotListBean.RecentBean> recentBeans = hotListBean.getRecent();
        list.addAll(recentBeans);
        mRemenAdapter.notifyDataSetChanged();
    }

    @Override
    protected RemenPresenter<RemenView> createPresenter() {
        return new RemenPresenter<>();
    }


}
