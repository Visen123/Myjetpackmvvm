package com.visen.homemoudle.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yanyy on 2017/11/10.
 */
public class SPUtil {

    private static final String SP_FILE_NAME = "Config";

    private static SharedPreferences mPreferences;
    private static SPUtil mInstance;

    public static void init(Context context) {
        if (mInstance == null) {
            mInstance = new SPUtil();
        }
        mPreferences = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE);
    }

    public static SharedPreferences getSharedPreferences() {
        return mPreferences;
    }

    public static SharedPreferences.Editor getEdit() {
        return mPreferences.edit();
    }

    //getValue
    public static String getString(String key, String defaultValue) {
        return mPreferences.getString(key, defaultValue);
    }

    public static String getString(String key) {
        return mPreferences.getString(key, "");
    }

    public static boolean getBoolean(String key, boolean defaultValue) {
        return mPreferences.getBoolean(key, defaultValue);
    }

    public static boolean getBoolean(String key) {
        return mPreferences.getBoolean(key, false);
    }

    public static int getInt(String key, int defaultValue) {
        return mPreferences.getInt(key, defaultValue);
    }

    public static int getInt(String key) {
        return mPreferences.getInt(key, 0);
    }

    public static float getFloat(String key, float defaultValue) {
        return mPreferences.getFloat(key, defaultValue);
    }

    public static float getFloat(String key) {
        return mPreferences.getFloat(key, 0);
    }

    public static long getLong(String key, long defaultValue) {
        return mPreferences.getLong(key, defaultValue);
    }

    public static long getLong(String key) {
        return mPreferences.getLong(key, 0);
    }

    public static Set<String> getStringSet(String key) {
        return mPreferences.getStringSet(key, new HashSet<String>());
    }

    //putValue
    public static SPUtil putString(String key, String value) {
        mPreferences.edit().putString(key, value).apply();
        return mInstance;
    }

    public static SPUtil putBoolean(String key, boolean value) {
        mPreferences.edit().putBoolean(key, value).apply();
        return mInstance;
    }

    public static SPUtil putInt(String key, int value) {
        mPreferences.edit().putInt(key, value).apply();
        return mInstance;
    }

    public static SPUtil putFloat(String key, float value) {
        mPreferences.edit().putFloat(key, value).apply();
        return mInstance;
    }

    public static SPUtil putLong(String key, long value) {
        mPreferences.edit().putLong(key, value).apply();
        return mInstance;
    }

    public static SPUtil putStringSet(String key, Set<String> value) {
        HashSet<String> newValue = new HashSet<>(value);
        mPreferences.edit().putStringSet(key, newValue).apply();
        return mInstance;
    }
}
