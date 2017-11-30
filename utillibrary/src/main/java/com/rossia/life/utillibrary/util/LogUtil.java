package com.rossia.life.utillibrary.util;

import android.util.Log;

/**
 * @author pd_liu on 2017/10/15.
 *         封装的日志打印功能。
 */

public final class LogUtil {

    private static final String TAG = "LogUtil";

    public static boolean sDebug = true;

    private static final String LEFT = "╠";
    private static final String TOP = "╦";
    private static final String RIGHT = "╣";
    private static final String BOTTOM = "╩";
    private static final String LINE = "═";

    private LogUtil() {
        throw new UnsupportedOperationException("Cannot be instantiated");
    }

    public static void e(String tag, String message) {
        if (sDebug) {
            Log.e(tag, message);
        }
    }

    public static void e(String tag, String message, Throwable throwable) {
        if (sDebug) {
            Log.e(tag, message, throwable);
        }
    }

    public static void i(String tag, String message) {
        if (sDebug) {
            Log.i(tag, message);
        }
    }

    public static void i(String tag, String message, Throwable throwable) {
        if (sDebug) {
            Log.i(tag, message, throwable);
        }
    }

}
