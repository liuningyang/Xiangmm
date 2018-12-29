package com.example.xiangmm.fragment.shuju;



import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;


import com.example.xiangmm.R;
import com.example.xiangmm.base.fragment.BaseFragment;
import com.example.xiangmm.beans.zhihu.shuju.News;
import com.example.xiangmm.beans.zhihu.shuju.XinWenInfon;

import com.example.xiangmm.presenter.zhihu.shuju.ShujuPresenter;
import com.example.xiangmm.view.zhihu.shuju.ShujuView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class OneFragment extends BaseFragment<ShujuView, ShujuPresenter<ShujuView>> implements ShujuView, XRecyclerView.LoadingListener {
    @BindView(R.id.xrec)
    XRecyclerView mXrec;

    private String category;
    private ShujuAdapter mShujuAdapter;
    private int page =1;
    private List<XinWenInfon.RESULTBean.NewsListBean> list = new ArrayList<>();


    public OneFragment() {
        // Required empty public constructor
    }



    @Override
    public int createLayoutId() {
        return R.layout.fragment_one;
    }

    @Override
    protected void initData() {
        mShujuAdapter = new ShujuAdapter(mActivity,list);
        mXrec.setAdapter(mShujuAdapter);
        LinearLayoutManager manager = new LinearLayoutManager(mActivity);
        mXrec.setLayoutManager(manager);
        mXrec.setLoadingListener(this);
        presenter.getXinWen(category,page);

    }

    public void setCategory(String category) {
        this.category = category;
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

    }

    @Override
    public void show1(XinWenInfon xinWenInfon, String category, int page) {
        List<XinWenInfon.RESULTBean.NewsListBean> newsListBeans = xinWenInfon.getRESULT().getNewsList();
        list.addAll(newsListBeans);
        mShujuAdapter.notifyDataSetChanged();
    }

    @Override
    public void onRefresh() {
        page = 1;
        presenter.getXinWen(category,page);
        mXrec.refreshComplete();
    }

    @Override
    public void onLoadMore() {
     page++;
     presenter.getXinWen(category,page);
     mXrec.loadMoreComplete();
    }
}
