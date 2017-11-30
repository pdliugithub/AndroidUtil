package com.rossia.life.utillibrary.util;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author pd_liu 2017年10月14日.
 *         closeQuietly方法可以运用到各类可关闭的对象中，保证了代码的可重用性。
 */

public final class CloseUtil {

    private static final String TAG = "CloseUtil";

    private CloseUtil() {
        throw new UnsupportedOperationException("Cannot be instantiated");
    }

    /**
     * Close closeable object quietly.
     * 用于关闭所有实现了Closeable的资源对象：IO等等。
     *
     * @param closeable object.
     * @throws IOException .
     */
    public static void closeQuietly(Closeable closeable) {

        if (!EmptyHandlerUtil.isEmpty(closeable)) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
