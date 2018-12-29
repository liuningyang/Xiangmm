package com.example.xiangmm.fragment.ganhuo;


import android.annotation.SuppressLint;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.xiangmm.R;
import com.example.xiangmm.base.fragment.BaseFragment;
import com.example.xiangmm.beans.zhihu.ganhuo.GankItemBean;
import com.example.xiangmm.presenter.zhihu.ganhuo.GanHuoPresenter;
import com.example.xiangmm.view.zhihu.ganhuo.GanhuoView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * A simple {@link Fragment} subclass.
 */
@SuppressLint("ValidFragment")
public class AFragment extends BaseFragment<GanhuoView, GanHuoPresenter<GanhuoView>> implements GanhuoView, XRecyclerView.LoadingListener {


    @BindView(R.id.xrec)
    XRecyclerView mXrec;
    public String tech;
    @BindView(R.id.img)
    ImageView mImg;
    @BindView(R.id.tv_tech_copyright)
    TextView mTvTechCopyright;

    private List<GankItemBean.ResultsBean> list = new ArrayList<>();
    private GanAdapter mGanAdapter;
    private int page = 1;


    @SuppressLint("ValidFragment")
    public AFragment(String s) {
        this.tech = s;

        // Required empty public constructor
    }


    @Override
    public int createLayoutId() {
        return R.layout.fragment_a;
    }

    @Override
    protected void initData() {
        mGanAdapter = new GanAdapter(list, getContext());
        mXrec.setAdapter(mGanAdapter);
        LinearLayoutManager manager = new LinearLayoutManager(mActivity);
        mXrec.setLayoutManager(manager);
        mXrec.setLoadingListener(this);

        presenter.getTechList(tech, page);
        presenter.getRandomGirl();

    }

    @Override
    protected GanHuoPresenter<GanhuoView> createPresenter() {
        return new GanHuoPresenter<>();
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
    public void show(GankItemBean gankItemBean, String tech, int page) {
        List<GankItemBean.ResultsBean> results = gankItemBean.getResults();
        list.addAll(results);
        mGanAdapter.notifyDataSetChanged();


    }

    @Override
    public void show1(GankItemBean gankItemBean) {
        List<GankItemBean.ResultsBean> results = gankItemBean.getResults();
        //Glide.with(mActivity).load(gankItemBean.getResults().get(0).getUrl()).into(mImg);
        Glide.with(mActivity).load(gankItemBean.getResults().get(0).getUrl()).into(mImg);
        Log.e("Ly",mImg.toString());
        list.addAll(results);
        mGanAdapter.notifyDataSetChanged();


    }



    @Override
    public void onRefresh() {
        page = 1;
        presenter.getTechList(tech, page);
        mXrec.refreshComplete();
    }

    @Override
    public void onLoadMore() {
        page++;
        presenter.getTechList(tech, page);
        mXrec.loadMoreComplete();

    }


}
