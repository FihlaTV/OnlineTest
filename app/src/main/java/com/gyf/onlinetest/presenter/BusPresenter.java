package com.gyf.onlinetest.presenter;

import com.gyf.onlinetest.model.bean.BusBean;
import com.gyf.onlinetest.model.BusModel;
import com.gyf.onlinetest.model.IBusModel;
import com.gyf.onlinetest.model.listener.OnLoadListener;
import com.gyf.onlinetest.ui.view.BusView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by geyifeng on 2017/10/25.
 */

public class BusPresenter extends BasePresenter<BusView>
        implements IBusPresenter, OnLoadListener<HashMap<String, ArrayList<BusBean>>> {

    private IBusModel busModel;

    public BusPresenter() {
        busModel = new BusModel();
    }

    @Override
    public void load() {
        busModel.onLoad(this);
    }

    @Override
    public void onSuccess(HashMap<String, ArrayList<BusBean>> data) {
        mView.onLoadSuccess(data);
    }

    @Override
    public void onFail(Throwable e) {
        mView.onLoadFail();
    }
}
