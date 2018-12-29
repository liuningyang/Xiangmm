package com.example.xiangmm.view.zhihu.weixin;

import com.example.xiangmm.base.view.BaseView;

import com.example.xiangmm.beans.zhihu.shuju.XinWenInfon;
import com.example.xiangmm.beans.zhihu.weixin.WXItemBean;

/**
 * Created by 利用 on 2018/12/25.
 */

public interface WeixinView extends BaseView {
    void show(WXItemBean wxItemBean,int page);

}
