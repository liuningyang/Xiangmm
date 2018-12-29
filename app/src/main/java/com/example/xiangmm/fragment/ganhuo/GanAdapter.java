package com.example.xiangmm.fragment.ganhuo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.xiangmm.R;
import com.example.xiangmm.beans.zhihu.ganhuo.GankItemBean;
import com.example.xiangmm.beans.zhihu.weixin.WXItemBean;
import com.example.xiangmm.fragment.adapter.WeixinAdapter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

/**
 * Created by 利用 on 2018/12/26.
 */

public class GanAdapter extends XRecyclerView.Adapter<GanAdapter.ViewHolder> {
     private List<GankItemBean.ResultsBean> list;
         private Context context;

         public GanAdapter(List<GankItemBean.ResultsBean> list, Context context) {
             this.list = list;
             this.context = context;
         }

         @Override
         public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
             View view = LayoutInflater.from(context).inflate(R.layout.layout_gan,null);
             ViewHolder viewHolder = new ViewHolder(view);
             return viewHolder;
         }

         @Override
         public void onBindViewHolder(ViewHolder holder, int position) {
             GankItemBean.ResultsBean resultsBean = list.get(position);
             holder.tv_tite.setText(resultsBean.getDesc());
             holder.time.setText(resultsBean.getCreatedAt());
             holder.who.setText(resultsBean.getWho());


         }

         @Override
         public int getItemCount() {
             return list.size();
         }

         public class ViewHolder extends RecyclerView.ViewHolder {

             private TextView time;
             private TextView tv_tite;
             private TextView who;


             public ViewHolder(View itemView) {
                 super(itemView);
                 time = itemView.findViewById(R.id.time);
                 tv_tite = itemView.findViewById(R.id.tv_tite);
                 who = itemView.findViewById(R.id.who);
             }
         }
}
