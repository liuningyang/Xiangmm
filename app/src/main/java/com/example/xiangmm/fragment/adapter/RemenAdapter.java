package com.example.xiangmm.fragment.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.xiangmm.R;
import com.example.xiangmm.beans.zhihu.zhi.HotListBean;

import java.util.List;

/**
 * Created by 利用 on 2018/12/24.
 */

public class RemenAdapter extends RecyclerView.Adapter<RemenAdapter.ViewHolder> {
    private List<HotListBean.RecentBean> list;
    private Context context;

    public RemenAdapter(List<HotListBean.RecentBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_remen,null);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        HotListBean.RecentBean recentBean = list.get(position);
        holder.tv_title.setText(recentBean.getTitle());
        Glide.with(context).load(recentBean.getThumbnail()).into(holder.img);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView tv_title;
        public ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            tv_title = itemView.findViewById(R.id.tv_title);
        }
    }
}
