package com.example.sf.demo1105a.utls;

import android.util.Log;


/**
 * Created by sf on 2017/11/5 0005.
 */

public class LogUtils {
    public static boolean isDebug = true;
    public static final String TAG = "LogUtils";

    private LogUtils() {
        throw new UnsupportedOperationException("logutls 构造错误");
    }

    public static boolean isDebug() {
        return isDebug;
    }

    public static void setDebug(boolean isDebug) {
        LogUtils.isDebug = isDebug;
    }

    public static void e(String msg) {
        if (isDebug) {
            Log.e(TAG, msg);
        }
    }

    public static void d(String msg) {
        if (isDebug) {
            Log.d(TAG, msg);
        }
    }

    public static void w(String msg) {
        if (isDebug) {
            Log.w(TAG, msg);
        }
    }
}
