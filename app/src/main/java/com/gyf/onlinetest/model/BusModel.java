package com.gyf.onlinetest.model;

import com.gyf.onlinetest.model.bean.BusBean;
import com.gyf.onlinetest.model.listener.OnLoadListener;
import com.gyf.onlinetest.net.RetrofitHttp;

import java.util.ArrayList;
import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * @author geyifeng
 * @date 2017/10/25
 */

public class BusModel implements IBusModel {
    @Override
    public void onLoad(final OnLoadListener<HashMap<String, ArrayList<BusBean>>> listener) {
        RetrofitHttp.getInstance()
                .getBus(new Observer<HashMap<String, ArrayList<BusBean>>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull HashMap<String, ArrayList<BusBean>> busMap) {
                        listener.onSuccess(busMap);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        listener.onFail(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
