package com.example.xiangmm.http.ganhuo;

import com.example.xiangmm.beans.zhihu.ganhuo.GankItemBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by 利用 on 2018/12/26.
 */

public interface GanhuoServer {
    String HOST = "http://gank.io/api/";

    /**
     * 技术文章列表
     */
    @GET("data/{tech}/{num}/{page}")
    Observable<GankItemBean> getTechList(@Path("tech") String tech, @Path("num") int num, @Path("page") int page);

    /**
     * 妹纸列表
     */
    @GET("data/福利/{num}/{page}")
    Observable<GankItemBean> getGirlList(@Path("num") int num, @Path("page") int page);

    /**
     * 随机妹纸图
     */
    @GET("random/data/福利/{num}")
    Observable<GankItemBean> getRandomGirl(@Path("num") int num);

    /**
     * 搜索
     */
    @GET("search/query/{query}/category/{type}/count/{count}/page/{page}")
    Observable<GankItemBean> getSearchList(@Path("query") String query,@Path("type") String type,@Path("count") int num,@Path("page") int page);



}
