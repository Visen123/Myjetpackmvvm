package com.visen.homemoudle.utils

import android.content.Context
import android.os.Environment
import android.util.Log
import android.widget.Toast
import java.io.File
import java.math.BigDecimal

/**
 * @作者 严益云
 * @创建日期 2020/12/31
 * 类名 DataCleanManager.java
 * 本应用数据清除管理器
 */
object DataCleanManager {
    private const val TAG = "DataCleanManager"

    @Throws(Exception::class)
    fun getTotalCacheSize(context: Context): String {
        var cacheSize = getFolderSize(context.cacheDir)
        Log.v(TAG, "cacheSize==$cacheSize")
        if (Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED) {
            cacheSize += getFolderSize(context.externalCacheDir)
            Log.v(TAG, "cacheSize2==" + getFolderSize(context.externalCacheDir))
        }
        return getFormatSize(cacheSize)
    }

    //删除内外缓存
    fun clearAllCache(context: Context) {
        deleteDir(context.cacheDir)
        if (Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED) {
            deleteDir(context.externalCacheDir)
        }
        Toast.makeText(context, "清除缓存", Toast.LENGTH_SHORT).show()
    }

    private fun deleteDir(dir: File?): Boolean {
        if (dir != null && dir.isDirectory) {
            val children = dir.list()
            for (i in children.indices) {
                val success = deleteDir(File(dir, children[i]))
                if (!success) {
                    return false
                }
            }
        }
        return dir!!.delete()
    }

    // 获取文件
    //Context.getExternalFilesDir() --> SDCard/Android/data/你的应用的包名/files/ 目录，一般放一些长时间保存的数据
    //Context.getExternalCacheDir() --> SDCard/Android/data/你的应用包名/cache/目录，一般存放临时缓存数据
    @Throws(Exception::class)
    fun getFolderSize(file: File?): Long {
        var size: Long = 0
        try {
            val fileList = file!!.listFiles()
            for (i in fileList.indices) {
                // 如果下面还有文件
                size = if (fileList[i].isDirectory) {
                    size + getFolderSize(fileList[i])
                } else {
                    size + fileList[i].length()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return size
    }

    /**
     * 格式化单位
     *
     * @param size
     * @return
     */
    fun getFormatSize(size: Long): String {
        Log.v(TAG, "size==$size")
        val kiloByte = (size / 1024).toDouble()
        if (kiloByte < 1) {
            return (size / 1024).toString() + "kB"
        }
        val megaByte = kiloByte / 1024
        if (megaByte < 1) {
            val result1 = BigDecimal(java.lang.Double.toString(kiloByte))
            return result1.setScale(1, BigDecimal.ROUND_HALF_UP)
                .toPlainString() + "KB"
        }
        val gigaByte = megaByte / 1024
        if (gigaByte < 1) {
            val result2 = BigDecimal(java.lang.Double.toString(megaByte))
            return result2.setScale(1, BigDecimal.ROUND_HALF_UP)
                .toPlainString() + "MB"
        }
        val teraBytes = gigaByte / 1024
        if (teraBytes < 1) {
            val result3 = BigDecimal(java.lang.Double.toString(gigaByte))
            return result3.setScale(2, BigDecimal.ROUND_HALF_UP)
                .toPlainString() + "GB"
        }
        val result4 = BigDecimal(teraBytes)
        return (result4.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString()
                + "TB")
    }
}