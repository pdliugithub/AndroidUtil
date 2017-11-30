package com.rossia.life.utillibrary.util;

import android.text.TextUtils;

/**
 * @author pd_liu on 2017/10/31.
 *         <p>
 *         空处理工具
 *         </p>
 */

public class EmptyHandlerUtil {

    private static final String TAG = "EmptyHandlerUtil";

    private EmptyHandlerUtil() {
        throw new UnsupportedOperationException("Cannot be instantiated");
    }

    /**
     * 计算对象是否为空.
     *
     * @param object 判断的对象.
     * @return 是否为空.
     */
    public static boolean isEmpty(Object object) {
        //判断是否为空对象.
        if (object == null) {
            return true;
        }
        //判断String对象.
        if (object instanceof String) {
            if (TextUtils.isEmpty((String) object)) {
                return true;
            }
            return false;

        }
        //判断数组对象.
        if (object instanceof Object[]) {
            if (((Object[]) object).length == 0) {
                return true;
            }
        }
        //判断集合.
        // TODO: 2017/10/31 为空判断 .
        return false;
    }
}
