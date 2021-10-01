package com.visen.homemoudle.utils;

import android.text.TextUtils;
import android.util.Log;


import com.visen.homemoudle.BuildConfig;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * on 2015/10/9.
 */
public class LogHelper {

    private static final String LINE_SEPARATOR = System.getProperty("line.separator");
    private static String TAG = "cyhlog";
    private static boolean isShow = true;

    public static void e(String content) {
        if (TextUtils.isEmpty(content)) {
            return;
        }
        if (isShow()) {
            Log.e(TAG, content);
        }
    }

    public static void e(String tag, String content) {
        if (TextUtils.isEmpty(content)) {
            return;
        }
        if (isShow()) {
            Log.e(tag, content);
        }
    }

    public static void d(String content) {
        if (TextUtils.isEmpty(content)) {
            return;
        }
        if (isShow()) {
            Log.d(TAG, content);
        }
    }

    public static void d(String tag, String content) {
        if (TextUtils.isEmpty(content)) {
            return;
        }
        if (isShow()) {
            Log.d(tag, content);
        }
    }

    private static void printLine(String tag, boolean isTop) {
        if (isTop) {
            Log.d(tag, "╔═══════════════════════════════════════════════════════════════════════════════════════");
        } else {
            Log.d(tag, "╚═══════════════════════════════════════════════════════════════════════════════════════");
        }
    }

    public static void printJson(String tag, String msg, String headString) {

        String message;

        try {
            if (msg.startsWith("{")) {
                JSONObject jsonObject = new JSONObject(msg);
                message = jsonObject.toString(4);//最重要的方法，就一行，返回格式化的json字符串，其中的数字4是缩进字符数
            } else if (msg.startsWith("[")) {
                JSONArray jsonArray = new JSONArray(msg);
                message = jsonArray.toString(4);
            } else {
                message = msg;
            }
        } catch (JSONException e) {
            message = msg;
        }

        printLine(tag, true);
        message = headString + LINE_SEPARATOR + message;
        String[] lines = message.split(LINE_SEPARATOR);
        for (String line : lines) {
            Log.d(tag, "║ " + line);
        }
        printLine(tag, false);
    }

    private static boolean isShow() {
        return isShow || BuildConfig.DEBUG;
    }
}
