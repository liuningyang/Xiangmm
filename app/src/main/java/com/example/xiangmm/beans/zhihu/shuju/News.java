package com.example.xiangmm.beans.zhihu.shuju;

import java.util.List;

/**
 * Created by 利用 on 2018/12/27.
 */

public class News {
    /**
     * ERRORCODE : 0
     * RESULT : ["要闻","财经","娱乐","体育","房产","科技","汽车","数码","时尚","游戏","教育"]
     */

    private String ERRORCODE;
    private List<String> RESULT;

    public String getERRORCODE() {
        return ERRORCODE;
    }

    public void setERRORCODE(String ERRORCODE) {
        this.ERRORCODE = ERRORCODE;
    }

    public List<String> getRESULT() {
        return RESULT;
    }

    public void setRESULT(List<String> RESULT) {
        this.RESULT = RESULT;
    }
}
