package com.visen.homemoudle.utils

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import com.visen.homemoudle.BuildConfig

/**
 * on 2015/12/29.
 */
object UriHelper {
    const val APP_MARKET_DETAIL_URI =
        "market://details?id=" + BuildConfig.APPLICATION_ID //应用市场详情页（通用，可选择哪个应用市场打开）

    //在外部浏览器中打开网页
    fun openUrlByBrowser(activity: Activity, url: String?) {
        val content_url = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, content_url)
        activity.startActivity(intent)
    }

    /**
     * 解析新闻地址里面的id
     */
    fun parseNewsId(newsUrl: String): String {
        val newsIdStart = newsUrl.lastIndexOf("/") + 1
        val newsIdEnd = newsUrl.lastIndexOf(".html")
        return newsUrl.substring(newsIdStart, newsIdEnd)
    }

    /**
     * 打开应用市场界面
     */
    fun openMarket(context: Context) {
        try {
            val content_url = Uri.parse(APP_MARKET_DETAIL_URI)
            val intent = Intent(Intent.ACTION_VIEW, content_url)
            context.startActivity(intent)
        } catch (e: ActivityNotFoundException) {
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}