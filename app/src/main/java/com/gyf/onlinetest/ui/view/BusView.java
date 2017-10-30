package com.gyf.onlinetest.ui.view;

import com.gyf.onlinetest.model.bean.BusBean;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by geyifeng on 2017/10/25.
 */

public interface BusView extends BaseView {
    void onLoadSuccess(HashMap<String, ArrayList<BusBean>> busMap);
    void onLoadFail();
}
