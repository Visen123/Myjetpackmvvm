package com.visen.homemoudle.utils

import android.annotation.SuppressLint
import android.text.TextUtils
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * 日期格式化类
 */
@SuppressLint("SimpleDateFormat")
object DateFormatUtils {
    private const val TAG = "DateFormatUtils"

    /**
     * 獲取當前時間
     *
     * @return
     */
    val currentTime: String
        get() {
            val sDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            return sDateFormat.format(Date())
        }

    /**
     * 獲取當前時間
     *
     * @return
     */
    val currentTimeNots: String
        get() {
            val sDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm")
            return sDateFormat.format(Date())
        }

    /**
     * 獲取當前時間
     *
     * @return
     */
    val currentTime2: String
        get() {
            val sDateFormat = SimpleDateFormat("hh:mm:ss")
            return sDateFormat.format(Date())
        }

    /**
     * 獲取當前日期
     *
     * @return
     */
    val currentDate: String
        get() {
            val sDateFormat = SimpleDateFormat("yyyy-MM-dd")
            return sDateFormat.format(Date())
        }

    /**
     * 转为yyyy-MM-dd
     *
     * @param date
     * @return
     */
    fun formatWithYMD(date: Long): String {
        if (date == 0L) {
            return ""
        }
        val sdf = SimpleDateFormat("yyyy-MM-dd")
        return sdf.format(Date(date))
    }

    /**
     * 转为yyyy-MM-dd
     *
     * @param date
     * @return
     */
    fun formatWithYMD2(date: Long): String {
        if (date == 0L) {
            return ""
        }
        val sdf = SimpleDateFormat("yyyy.MM.dd")
        return sdf.format(Date(date))
    }

    /**
     * 返回时间差
     *
     * @param date
     * @return
     */
    fun deltaT(date: Long): String {
        val time = (System.currentTimeMillis() - date) / 1000
        return if (time < 60) {
            "刚刚"
        } else if (time < 3600) {
            (time / 60).toString() + "分钟前"
        } else if (time < 24 * 3600) {
            (time / 3600).toString() + "小时前"
        } else {
            (time / 24 / 3600).toString() + "天前"
        }
    }

    /**
     * 转为yyyy-MM-dd
     *
     * @param date
     * @return
     */
    fun formatWithYM(date: Long): String {
        if (date == 0L) {
            return ""
        }
        val sdf = SimpleDateFormat("yyyy-MM")
        return sdf.format(Date(date))
    }

    /**
     * 转为HH:mm
     *
     * @param date
     * @return
     */
    fun formatWithHm(date: Long): String {
        if (date == 0L) {
            return ""
        }
        val sdf = SimpleDateFormat("HH:mm")
        return sdf.format(Date(date))
    }

    /**
     * 转为dd
     *
     * @param date
     * @return
     */
    fun formatWithd(date: Long): String {
        if (date == 0L) {
            return ""
        }
        val sdf = SimpleDateFormat("dd")
        return sdf.format(Date(date))
    }

    /**
     * 转为HH:mm:ss
     *
     * @param date
     * @return
     */
    fun formatWithHms(date: Long): String {
        if (date == 0L) {
            return ""
        }
        val sdf = SimpleDateFormat("HH:mm:ss")
        return sdf.format(Date(date))
    }

    /**
     * 转为mm:ss
     *
     * @param date
     * @return
     */
    fun formatWithms(date: Long): String {
        if (date == 0L) {
            return ""
        }
        val sdf = SimpleDateFormat("mm:ss")
        return sdf.format(Date(date))
    }

    /**
     * 转为 yyyy-MM-dd HH:mm
     *
     * @param date
     * @return
     */
    fun formatWithYMDHm(date: Long): String {
        if (date == 0L) {
            return ""
        }
        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm")
        return sdf.format(Date(date))
    }

    /**
     * 转为MM-dd HH:mm
     *
     * @param date
     * @return
     */
    fun formatWithMDHm(date: Long): String {
        if (date == 0L) {
            return ""
        }
        val sdf = SimpleDateFormat("MM-dd HH:mm")
        return sdf.format(Date(date))
    }

    /**
     * 转为 yyyy-MM-dd HH:mm:ss
     *
     * @param date
     * @return
     */
    fun formatWithYMDHms(date: Long): String {
        if (date == 0L) {
            return ""
        }
        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        return sdf.format(Date(date))
    }

    /**
     * 由yyyy-MM-dd'T'HH:mm:ssZ -> 时间戳
     *
     * @param datetime
     * @return
     */
    fun parse(datetime: String?): Long {
        try {
            if (TextUtils.isEmpty(datetime)) {
                return System.currentTimeMillis()
            }
            val sdf = SimpleDateFormat(
                "yyyy-MM-dd'T'HH:mm:ssZ"
            )
            return sdf.parse(datetime).time
        } catch (e: ParseException) {
        }
        return System.currentTimeMillis()
    }

    /**
     * 由yyyy-MM-dd'T'HH:mm\ -> 时间戳
     *
     * @param datetime
     * @return
     */
    fun parseToLong(datetime: String?): Long {
        try {
            if (TextUtils.isEmpty(datetime)) {
                return System.currentTimeMillis()
            }
            // SimpleDateFormat sdf = new
            // SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
            val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm")
            return sdf.parse(datetime).time
        } catch (e: ParseException) {
        }
        return System.currentTimeMillis()
    }

    fun parseToDate(datetime: String?): Date? {
        try {
            if (TextUtils.isEmpty(datetime)) {
                return null
            }
            val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            return sdf.parse(datetime)
        } catch (e: ParseException) {
        }
        return null
    }

    /**
     * 将日期转化为年月日时分秒
     *
     * @param date
     * @return
     */
    fun parseDateToString(date: Date?): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        return sdf.format(date)
    }

    /**
     * 由yyyy-MM-dd -> 时间戳
     *
     * @param datetime
     * @return
     */
    fun parseToYMD(datetime: String?): Long {
        try {
            if (TextUtils.isEmpty(datetime)) {
                return System.currentTimeMillis()
            }
            // SimpleDateFormat sdf = new
            // SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
            val sdf = SimpleDateFormat("yyyy-MM-dd")
            return sdf.parse(datetime).time
        } catch (e: ParseException) {
        }
        return System.currentTimeMillis()
    }

    /**
     * 时间转换成毫秒
     *
     * @param expireDate
     * @return
     */
    fun getSecondsFromDate(expireDate: String?): Long {
        if (expireDate == null || expireDate.trim { it <= ' ' } == "") return 0
        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        var date: Date? = null
        return try {
            date = sdf.parse(expireDate)
            date.time
        } catch (e: ParseException) {
            e.printStackTrace()
            0
        }
    }

    /**
     * 转换成时间格式(类似音乐、视频计算时间)
     *
     * @param time
     * @return
     */
    fun secToTime(time: Int): String {
        var timeStr: String? = null
        var hour = 0
        var minute = 0
        var second = 0
        if (time <= 0) return "00:00" else {
            minute = time / 60
            if (minute < 60) {
                second = time % 60
                timeStr = unitFormat(minute) + ":" + unitFormat(second)
            } else {
                hour = minute / 60
                if (hour > 99) return "99:59:59"
                minute = minute % 60
                second = time - hour * 3600 - minute * 60
                timeStr = (unitFormat(hour) + ":" + unitFormat(minute) + ":"
                        + unitFormat(second))
            }
        }
        return timeStr
    }

    /**
     * 之上的附属方法
     *
     * @param i
     * @return
     */
    fun unitFormat(i: Int): String {
        var retStr: String? = null
        retStr = if (i >= 0 && i < 10) "0" + Integer.toString(i) else "" + i
        return retStr
    }

    /**
     * 時間差
     *
     * @param nowTime 當前時間
     * @param oldTime 開獎時間
     * @return 返回毫秒
     */
    fun getTimeDifference(nowTime: String?, oldTime: String?): Long {
        val df: DateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        try {
            val d1 = df.parse(nowTime)
            val d2 = df.parse(oldTime)
            return d2.time - d1.time
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return -1
    }

    /**
     * 時間差
     *
     * @param nowTime 當前時間
     * @param oldTime 開獎時間
     * @return 返回毫秒
     */
    fun getTimeDifferenceNots(nowTime: String?, oldTime: String?): Long {
        val df: DateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm")
        try {
            val d1 = df.parse(nowTime)
            val d2 = df.parse(oldTime)
            return d2.time - d1.time
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return -1
    }

    /**
     * 時間差
     *
     * @param nowTime 當前時間
     * @param oldTime 開獎時間
     * @return 返回毫秒
     */
    fun getTimeDifference2(nowTime: String?, oldTime: String?): Long {
        val df: DateFormat = SimpleDateFormat("HH:mm:ss")
        try {
            val d1 = df.parse(nowTime)
            val d2 = df.parse(oldTime)
            return d2.time - d1.time
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return -1
    }

    fun getTotalTime(time: Long): Array<String?> {
        val h = time / 3600000
        val d = h / 24
        val hour = h % 24
        val m = (time - h * 3600000) / 60000
        val s = (time - h * 3600000 - m * 60000) / 1000
        val times = arrayOfNulls<String>(4)
        times[0] = if (d > 9) d.toString() + "" else "0$d"
        times[1] = if (hour > 9) hour.toString() + "" else "0$hour"
        times[2] = if (m > 9) m.toString() + "" else "0$m"
        times[3] = if (s > 9) s.toString() + "" else "0$s"
        return times
    }
}