package com.example.xiangmm.fragment.shuju;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import com.example.xiangmm.R;
import com.example.xiangmm.beans.zhihu.shuju.XinWenInfon;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

/**
 * Created by 利用 on 2018/12/27.
 */

public class ShujuAdapter extends XRecyclerView.Adapter<ShujuAdapter.ViewHolder> {
    private Context context;
    private List<XinWenInfon.RESULTBean.NewsListBean> list;

    public ShujuAdapter(Context context, List<XinWenInfon.RESULTBean.NewsListBean> list) {
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
        XinWenInfon.RESULTBean.NewsListBean newslistBean = list.get(position);
        holder.title.setText(newslistBean.getTitle());
        holder.from.setText(newslistBean.getSource());
        holder.time.setText(newslistBean.getPublishTime());
       // Glide.with(context).load(newslistBean.getNewsImg()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(imageView);
       /* RequestOptions requestOptions = new RequestOptions().bitmapTransform(new CircleCrop());
        Glide.with(context).load(newslistBean.getNewsImg()).apply(requestOptions).into(holder.image);*/
       Glide.with(context).load(newslistBean.getNewsImg()).into(holder.image);
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
