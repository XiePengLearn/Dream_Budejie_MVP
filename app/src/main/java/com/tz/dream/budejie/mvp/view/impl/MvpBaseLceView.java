package com.tz.dream.budejie.mvp.view.impl;

/**
 * Created by Dream on 16/5/26.
 */
public abstract class MvpBaseLceView<M> implements MvpLceView<M>{

    @Override
    public void showLoading(boolean pullToRefresh) {

    }

    @Override
    public void showContent() {

    }

    @Override
    public void showError(Exception e, boolean pullToRefresh) {

    }

    @Override
    public void showData(M data) {

    }
}
