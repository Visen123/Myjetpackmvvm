package com.visen.homemoudle.utils

import android.graphics.Bitmap
import android.util.Log
import java.io.FileOutputStream
import java.io.IOException

/**
 * ImageUtils
 *
 * @author yanyy
 * @date 2017/4/19 下午2:35
 * @mainFunction :
 */
object ImageUtils {
    /**
     * 把图片村保存在相应的文件当中
     *
     * @param pBitmap
     * @param fileName
     */
    fun saveFile(pBitmap: Bitmap, fileName: String?) {
        var fos: FileOutputStream? = null
        try {
            fos = FileOutputStream(fileName)
            pBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos)
            fos.flush()
            Log.i("jiangqq", "保存图片到sdcard卡成功.")
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            if (fos != null) {
                try {
                    fos.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
    }
}