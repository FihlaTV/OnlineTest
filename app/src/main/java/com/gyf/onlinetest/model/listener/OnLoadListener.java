package com.gyf.onlinetest.model.listener;

/**
 * Created by geyifeng on 2017/10/25.
 */

public interface OnLoadListener<T> {
    void onSuccess(T data);

    void onFail(Throwable e);
}
