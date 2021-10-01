package com.visen.homemoudle.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * @作者 严益云
 * @创建日期 2020/12/18
 * 类名 KeyboardUtils.java
 * 显示和隐藏软键盘，
 */
public class KeyboardUtils {

    // TODO: 2020/12/18 显示系统键盘
    public static void showKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) view.getContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            view.requestFocus();
            imm.showSoftInput(view, 0);
        }
    }

    //todo 隐藏系统键盘
    public static void hideKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) view.getContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static void hideSoftInputFromWindow(Activity activity) {
        if (activity != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
            }
        }
    }

    // TODO: 2020/12/18 切换系统键盘 当前状态是显示则会隐藏，当前状态是隐藏则会显示
    public static void toggleSoftInput(View view) {
        InputMethodManager imm = (InputMethodManager) view.getContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.toggleSoftInput(0, 0);
        }
    }

}
