package com.rossia.life.utillibrary.util;

import android.content.Context;
import android.widget.Toast;

import com.rossia.life.utillibrary.R;

/**
 * @author pd_liu on 2017/11/1.
 *         统一Toast的工具管理.
 */

public final class ToastUtil {
    /**
     * Application context.
     */
    private static Context mAppContext;
    /**
     * Toast object.
     */
    private static Toast mToast;

    /**
     * Debug flag.
     */
    public static boolean sDebug;

    private ToastUtil() {
        throw new UnsupportedOperationException("Cannot be instantiated");
    }

    /**
     * 需要在Application中进行初始化。
     *
     * @param appContext context.
     */
    public static void initToast(Context appContext) {
        if (EmptyHandlerUtil.isEmpty(appContext)) {
            return;
        }
        mAppContext = appContext;
        mToast = Toast.makeText(mAppContext, R.string.empty, Toast.LENGTH_SHORT);
    }

    /**
     * Show toast.
     *
     * @param msg message.
     * @see #showDebug(String) .
     */
    public static void show(String msg) {

        if (!EmptyHandlerUtil.isEmpty(mToast) && !EmptyHandlerUtil.isEmpty(msg)) {
            mToast.setText(msg);
            mToast.show();
        }

    }

    /**
     * 调用此方法进行显示，如果在Release版本上，信息将不会被显示。
     * 可用于调试阶段的展示信息的展示。
     *
     * @param msg message.
     * @see #show(String) .
     */
    public static void showDebug(String msg) {
        if (!EmptyHandlerUtil.isEmpty(mToast) && !EmptyHandlerUtil.isEmpty(msg) && sDebug) {
            mToast.setDuration(Toast.LENGTH_LONG);
            mToast.setText(msg);
            mToast.show();

        }
    }

}
