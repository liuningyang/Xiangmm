package com.example.xiangmm.http.shuju;

import com.example.xiangmm.beans.zhihu.shuju.News;
import com.example.xiangmm.beans.zhihu.shuju.XinWenInfon;
import com.example.xiangmm.beans.zhihu.weixin.WXItemBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 利用 on 2018/12/27.
 */

public interface ShujuServer {
    //http://api.shujuzhihui.cn/api/news/categories?appKey=52047fa93a24422c868d6f27dace76ab
    //http://api.shujuzhihui.cn/api/news/list?appKey=52047fa93a24422c868d6f27dace76ab&category=%E8%A6%81%E9%97%BB&page=1
    String HOST = "http://api.shujuzhihui.cn/api/news/";
    /**
     * 微信精选列表
     */
    @GET("categories")
    Observable<News> getNews(@Query("appKey") String appKey);
    @GET("list")
    Observable<XinWenInfon> getXinWen(@Query("appKey") String appKey,@Query("category") String category,@Query("page") int page);

}
