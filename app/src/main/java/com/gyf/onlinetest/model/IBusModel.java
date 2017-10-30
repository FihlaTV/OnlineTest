package com.gyf.onlinetest.model;

import com.gyf.onlinetest.model.bean.BusBean;
import com.gyf.onlinetest.model.listener.OnLoadListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by geyifeng on 2017/10/25.
 */

public interface IBusModel {
    void onLoad(OnLoadListener<HashMap<String, ArrayList<BusBean>>> listener);
}
