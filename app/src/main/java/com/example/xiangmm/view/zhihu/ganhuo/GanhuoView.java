package com.example.xiangmm.view.zhihu.ganhuo;

import com.example.xiangmm.base.view.BaseView;
import com.example.xiangmm.beans.zhihu.ganhuo.GankItemBean;


/**
 * Created by 利用 on 2018/12/26.
 */

public interface GanhuoView extends BaseView {
    void show(GankItemBean gankItemBean,String tech, int page);
    void show1(GankItemBean gankItemBean);

}
