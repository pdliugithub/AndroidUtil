package com.rossia.life.utillibrary.util;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.PowerManager;
import android.provider.Settings;
import android.support.annotation.FloatRange;
import android.support.annotation.IntRange;
import android.view.Window;
import android.view.WindowManager;

/**
 * @author pd_liu on 2017/11/9.
 *         <p>
 *         屏幕亮度调节工具类。
 *         </p>
 *         <p>
 *         使用介绍说明：
 *         </p>
 *         <p>
 *         调节当前页面亮度{@link #adjustScreenBright(Window, float)}}.
 *         调节系统的亮度{@link #adjustSystemBright(Context, int)}.
 *         调节系统的亮度模式为自动调节模式{@link #adjustSystemBrightAutoMode(Context)}.
 *         调节系统的亮度模式为手动调节模式{@link #adjustSystemBrightManual(Context)}}.
 *         唤醒屏幕、熄灭屏幕{@link #adjustKeepScreenOn(Context, boolean)}.
 *         </p>
 */

public final class ScreenBrightnessUtil{

    private static final String TAG = "ScreenBrightnessUtil";

    private ScreenBrightnessUtil(){
        throw new UnsupportedOperationException("Cannot be instantiated");
    }
    /**
     * 调节屏幕的亮度.
     *
     * @param window window.
     * @param bright 0 to 1 adjusts the brightness from dark to full bright.
     */
    public static void adjustScreenBright(Window window, @FloatRange(from = 0f, to = 1f) float bright) {
        if (EmptyHandlerUtil.isEmpty(window)) return;
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = bright;
        window.setAttributes(attributes);
    }

    /**
     * 调节系统的亮度.
     *
     * @param context context.
     * @param value   The screen backlight brightness between 0 and 255.
     */
    public static void adjustSystemBright(Context context, @IntRange(from = 0, to = 255) int value) {
        if (EmptyHandlerUtil.isEmpty(context)) return;

        ContentResolver contentResolver = context.getContentResolver();
        //获取亮度的url.
        Uri uri = Settings.System.getUriFor(Settings.System.SCREEN_BRIGHTNESS);
        //设置最新亮度
        Settings.System.putInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS, value);
        //notify change.
        contentResolver.notifyChange(uri, null);
    }

    /**
     * 更改系统屏幕亮度调节模式为自动调节模式
     *
     * @param context context
     * @see #adjustSystemBrightManual(Context) .
     */
    public static void adjustSystemBrightAutoMode(Context context) {
        adjustSystemBrightMode(context, Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC);
    }

    /**
     * 更改系统屏幕亮度调节模式为手动调节模式
     *
     * @param context context
     * @see #adjustSystemBrightAutoMode(Context) .
     */
    public static void adjustSystemBrightManual(Context context) {
        adjustSystemBrightMode(context, Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL);
    }

    /**
     * 更改系统亮度调节的模式.
     *
     * @param context context.
     * @param value   调节模式
     */
    private static void adjustSystemBrightMode(Context context, int value) {
        if (EmptyHandlerUtil.isEmpty(context)) return;

        ContentResolver contentResolver = context.getContentResolver();
        //获取屏幕亮度模式的uri
        Uri uri = Settings.System.getUriFor(Settings.System.SCREEN_BRIGHTNESS_MODE);
        //设置屏幕亮度
        Settings.System.putInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS_MODE, value);
        //notify change.
        contentResolver.notifyChange(uri, null);
    }

    /**
     * 唤醒屏幕、熄灭屏幕。
     * 切记：acquire、release是成对出现使用的.
     *
     * @param context        context.
     * @param isKeepScreenOn 是否KeepScreenOn
     */
    public static void adjustKeepScreenOn(Context context, boolean isKeepScreenOn) {
        if (EmptyHandlerUtil.isEmpty(context)) return;
        PowerManager powerManager = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        PowerManager.WakeLock wakeLock = powerManager.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK, TAG);
        if (isKeepScreenOn) {
            wakeLock.acquire();
        } else {
            wakeLock.release();
        }
    }

}
