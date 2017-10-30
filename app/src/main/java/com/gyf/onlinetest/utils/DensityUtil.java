package com.gyf.onlinetest.utils;

import android.content.Context;
import android.util.TypedValue;

/**
 *
 * @author geyifeng
 * @date 2017/10/25
 */

public class DensityUtil {

    /**
     * dp转像素
     *
     * @param c       the c
     * @param dpValue the dp value
     * @return the int
     */
    public static int dip2px(Context c, float dpValue) {
        final float scale = c.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * dip转sp
     *
     * @param c       the c
     * @param dpValue the dp value
     * @return the int
     */
    public static int dip2sp(Context c, float dpValue) {
        return (int) (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, c.getResources().getDisplayMetrics()));
    }

    /**
     * 像素转dp
     *
     * @param c       the c
     * @param pxValue the px value
     * @return the int
     */
    public static int px2dip(Context c, float pxValue) {
        final float scale = c.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }


    /**
     * 像素转sp
     *
     * @param c       the c
     * @param pxValue the px value
     * @return the int
     */
    public static int px2sp(Context c, float pxValue) {
        float fontScale = c.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }


    /**
     * sp转像素
     *
     * @param c       the c
     * @param spValue the sp value
     * @return the int
     */
    public static int sp2px(Context c, float spValue) {
        float fontScale = c.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    /**
     * sp转dip
     *
     * @param c       the c
     * @param spValue the sp value
     * @return the int
     */
    public static int sp2dip(Context c, float spValue) {
        return (int) (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, spValue, c.getResources().getDisplayMetrics()));
    }

    /**
     * 获取屏幕宽度
     *
     * @param c the c
     * @return the screen w
     */
    public static int getScreenW(Context c) {
        return c.getResources().getDisplayMetrics().widthPixels;
    }

    /**
     * 获取屏幕高度
     *
     * @param c the c
     * @return the screen h
     */
    public static int getScreenH(Context c) {
        return c.getResources().getDisplayMetrics().heightPixels;
    }
}
