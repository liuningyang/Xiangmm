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
import com.example.xiangmm.beans.zhihu.weixin.WXItemBean;
import com.example.xiangmm.widget.SquareImageView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.youth.banner.loader.ImageLoader;

import java.util.List;

/**
 * Created by 利用 on 2018/12/25.
 */

public class WeixinAdapter extends XRecyclerView.Adapter<WeixinAdapter.ViewHolder> {
    private Context context;
    private List<WXItemBean.NewslistBean> list;



    public WeixinAdapter(Context context, List<WXItemBean.NewslistBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_weixin,null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        WXItemBean.NewslistBean newslistBean = list.get(position);
        holder.title.setText(newslistBean.getTitle());
        holder.from.setText(newslistBean.getDescription());
        holder.time.setText(newslistBean.getCtime());
        Glide.with(context).load(newslistBean.getPicUrl()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView title;
        private TextView from;
        private TextView time;
        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.title);
            from = itemView.findViewById(R.id.from);
            time = itemView.findViewById(R.id.time);

        }
    }
}
