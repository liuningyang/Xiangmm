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
import com.example.xiangmm.beans.zhihu.zhi.SectionListBean;

import java.util.List;

/**
 * Created by 利用 on 2018/12/24.
 */

public class ZhuanlanAdapter extends RecyclerView.Adapter<ZhuanlanAdapter.ViewHolder> {
    private List<SectionListBean.DataBean> list;
    private Context context;

    public ZhuanlanAdapter(List<SectionListBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_zhuanlan,null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SectionListBean.DataBean dataBean = list.get(position);
        holder.tvDes.setText(dataBean.getDescription());
        holder.tvKind.setText(dataBean.getName());
        Glide.with(context).load(dataBean.getThumbnail()).into(holder.section_bg);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public   class ViewHolder extends RecyclerView.ViewHolder {
          private ImageView section_bg;
          private TextView tvKind;
          private TextView tvDes;
           public ViewHolder(View itemView) {
            super(itemView);
            section_bg = itemView.findViewById(R.id.section_bg);
               tvKind = itemView.findViewById(R.id.section_kind);
               tvDes = itemView.findViewById(R.id.section_des);
        }
    }
}
