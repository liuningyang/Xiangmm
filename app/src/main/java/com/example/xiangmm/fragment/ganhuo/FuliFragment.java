package com.example.xiangmm.fragment.ganhuo;



import android.support.v4.app.Fragment;
import android.support.v7.widget.StaggeredGridLayoutManager;


import com.example.xiangmm.R;
import com.example.xiangmm.base.fragment.BaseFragment;
import com.example.xiangmm.beans.zhihu.ganhuo.GankItemBean;
import com.example.xiangmm.presenter.zhihu.ganhuo.FuliPresenter;
import com.example.xiangmm.view.zhihu.ganhuo.FuliView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class FuliFragment extends BaseFragment<FuliView,FuliPresenter<FuliView>> implements FuliView, XRecyclerView.LoadingListener {


    @BindView(R.id.xrec)
    XRecyclerView mXrec;

    private List<GankItemBean.ResultsBean> list = new ArrayList<>();
    private FuliAdapter mFuliAdapter;
    StaggeredGridLayoutManager mStaggeredGridLayoutManager;
    private  int page = 1;

    public FuliFragment() {
        // Required empty public constructor
    }




    @Override
    public int createLayoutId() {
        return R.layout.fragment_fuli;
    }

    @Override
    protected void initData() {
        mFuliAdapter = new FuliAdapter(list,mActivity);
        mXrec.setAdapter(mFuliAdapter);
        mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);

        mXrec.setLayoutManager(mStaggeredGridLayoutManager);
        mXrec.setLoadingListener(this);
        presenter.getGirlList(page);


    }

    @Override
    protected FuliPresenter<FuliView> createPresenter() {
        return new FuliPresenter<>();
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
    public void show(GankItemBean gankItemBean, int page) {
        List<GankItemBean.ResultsBean> results = gankItemBean.getResults();
        list.addAll(results);
        mFuliAdapter.notifyDataSetChanged();
    }

    @Override
    public void onRefresh() {
        page = 1;
        presenter.getGirlList(page);
        mXrec.refreshComplete();
    }

    @Override
    public void onLoadMore() {
       page++;
       presenter.getGirlList(page);
       mXrec.loadMoreComplete();
    }
}
