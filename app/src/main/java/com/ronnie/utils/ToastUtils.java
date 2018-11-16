package com.ronnie.utils;

import android.support.annotation.StringRes;
import android.widget.Toast;

import com.ronnie.RonnieApp;

/**
 * Created by Ronnie on 17/12/8.
 */

public class ToastUtils {
    private static Toast TOAST;

    public static void showToast(String msg) {
        if (TOAST == null) {
            TOAST = Toast.makeText(RonnieApp.CONTEXT, msg, Toast.LENGTH_SHORT);
        } else {
            TOAST.setText(msg);
        }
        TOAST.show();
    }

    public static void showToast(@StringRes int resId) {
        showToast(RonnieApp.CONTEXT.getString(resId));
    }
}
