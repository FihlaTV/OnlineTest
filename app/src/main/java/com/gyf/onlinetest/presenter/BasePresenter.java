package com.gyf.onlinetest.presenter;

/**
 * Created by geyifeng on 2017/10/25.
 */

public abstract class BasePresenter<T> {

    public T mView;

    public void attachView(T mView) {
        this.mView = mView;
    }

    public void dettachView() {
        mView = null;
    }
}
