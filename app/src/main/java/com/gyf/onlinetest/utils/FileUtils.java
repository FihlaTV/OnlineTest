package com.gyf.onlinetest.utils;

import android.content.Context;
import android.os.Environment;

import java.io.File;

/**
 * Created by geyifeng on 2017/10/25.
 */

public class FileUtils {

    public static File getDiskCacheDir(Context context) {
        File file;
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
                || !Environment.isExternalStorageRemovable()) {
            file = context.getExternalCacheDir();
        } else {
            file = context.getCacheDir();
        }
        return file;
    }
}
