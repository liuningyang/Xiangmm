package com.example.xiangmm.view.zhihu.shuju;

import com.example.xiangmm.base.view.BaseView;
import com.example.xiangmm.beans.zhihu.shuju.News;
import com.example.xiangmm.beans.zhihu.shuju.XinWenInfon;

/**
 * Created by 利用 on 2018/12/27.
 */

public interface ShujuView extends BaseView {
    void show(News news);
    void show1(XinWenInfon xinWenInfon , String category, int page);
}
