package com.gyf.onlinetest;

import android.app.Application;
import android.content.Context;

/**
 * Created by geyifeng on 2017/10/25.
 */

public class MyApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }
}
