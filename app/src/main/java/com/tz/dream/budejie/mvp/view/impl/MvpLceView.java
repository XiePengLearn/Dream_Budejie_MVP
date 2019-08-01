package com.tz.dream.budejie.mvp.view.impl;

import com.tz.dream.budejie.mvp.view.MvpView;

/**
 * 请求数据,刷新UI界面监听(标准)---说白了就是同学们经常看到的loading页
 * Created by Dream on 16/5/26.
 */
public interface MvpLceView<M> extends MvpView {
    //显示加载中的视图(说白了监听加载类型:下啦刷新或者上啦加载)
    public void showLoading(boolean pullToRefresh);

    //显示ContentView
    public void showContent();

    //加载错误
    public void showError(Exception e,boolean pullToRefresh);

    //绑定数据
    public void showData(M data);
}
