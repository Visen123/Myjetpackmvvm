package com.visen.homemoudle.utils

import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Build

/**
 * on 16/1/12.
 */
object VersionUtils {
    fun hasFroyo(): Boolean {
        return Build.VERSION.SDK_INT >= 8
    }

    fun hasGingerbread(): Boolean {
        return Build.VERSION.SDK_INT >= 9
    }

    fun hasHoneycomb(): Boolean {
        return Build.VERSION.SDK_INT >= 11
    }

    fun hasHoneycombMR1(): Boolean {
        return Build.VERSION.SDK_INT >= 12
    }

    fun hasJellyBean(): Boolean {
        return Build.VERSION.SDK_INT >= 16
    }

    fun getVersionName(context: Context): String {
        val packageManager = context.packageManager
        var packageInfo: PackageInfo? = null
        try {
            packageInfo = packageManager.getPackageInfo(context.packageName, 0)
        } catch (e: PackageManager.NameNotFoundException) {
        }

        //获取应用版本号
        return packageInfo!!.versionName
    }

    fun getVersionCode(context: Context): Int {
        val packageManager = context.packageManager
        var packageInfo: PackageInfo? = null
        try {
            packageInfo = packageManager.getPackageInfo(context.packageName, 0)
        } catch (e: PackageManager.NameNotFoundException) {
        }

        //获取应用版本号
        return packageInfo!!.versionCode
    }

    fun getChannel(context: Context): String {
        return try {
            val manager = context.packageManager
            val appInfo =
                manager.getApplicationInfo(context.packageName, PackageManager.GET_META_DATA)
            appInfo.metaData["UMENG_CHANNEL"].toString() + ""
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
            ""
        }
    }
}