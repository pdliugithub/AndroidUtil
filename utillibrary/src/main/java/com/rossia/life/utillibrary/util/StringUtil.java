package com.rossia.life.utillibrary.util;

import android.content.Context;
import android.support.annotation.StringRes;

/**
 * @author pd_liu on 2017/11/16.
 */

public final class StringUtil {

    private StringUtil() {
        throw new UnsupportedOperationException("Cannot be instantiated");
    }

    public static String getStringByID(Context context, @StringRes int stringResID) {
        return context.getString(stringResID);
    }

}
