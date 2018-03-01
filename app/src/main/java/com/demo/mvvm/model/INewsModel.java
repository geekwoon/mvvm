package com.demo.mvvm.model;

import com.demo.mvvm.base.BaseLoadListener;
import com.demo.mvvm.bean.SimpleNewsBean;

public interface INewsModel {
    /**
     * 获取新闻数据
     *
     * @param page 页数
     * @param loadListener
     */
    void loadNewsData(int page, BaseLoadListener<SimpleNewsBean> loadListener);
}
