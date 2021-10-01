package com.visen.homemoudle.utils

import android.content.ContentResolver
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Bitmap.CompressFormat
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.media.ExifInterface
import android.net.Uri
import android.os.Environment
import android.provider.MediaStore
import android.text.TextUtils
import android.util.Log
import java.io.*
import java.nio.channels.FileChannel
import java.util.*

object FileUtils {
    fun mImageFileCachePath(): String {
        val s = (Environment.getExternalStorageDirectory()
            .toString() + File.separator + "Android" + File.separator
                + "_test" + File.separator)
        val file = File(s)
        if (!file.exists()) {
            file.mkdirs()
        }
        return s
    }
    /**
     * 把图片压缩到200K
     *
     * @param oldpath
     * 压缩前的图片路径
     * @param newPath
     * 压缩后的图片路径
     * @return
     */
    /**
     * 把图片压缩到200K
     *
     * @param oldpath 压缩前的图片路径
     * @param newPath 压缩后的图片路径
     * @return
     */
    fun compressFile(oldpath: String?, newPath: String?): File? {
        var compressBitmap: Bitmap? = decodeFile(oldpath)
        var newBitmap: Bitmap? = ratingImage(oldpath, compressBitmap)
        val os = ByteArrayOutputStream()
        newBitmap!!.compress(CompressFormat.PNG, 100, os)
        val bytes = os.toByteArray()
        var file: File? = null
        try {
            file = getFileFromBytes(bytes, newPath)
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            if (newBitmap != null) {
                if (!newBitmap.isRecycled) {
                    newBitmap.recycle()
                }
                newBitmap = null
            }
            if (compressBitmap != null) {
                if (!compressBitmap.isRecycled) {
                    compressBitmap.recycle()
                }
                compressBitmap = null
            }
        }
        return file
    }

    fun ratingImage(filePath: String?, bitmap: Bitmap?): Bitmap {
        val degree = readPictureDegree(filePath)
        return rotaingImageView(degree, bitmap)
    }

    /**
     * 旋转图片
     *
     * @param angle
     * @param bitmap
     * @return Bitmap
     */
    fun rotaingImageView(angle: Int, bitmap: Bitmap?): Bitmap {
        // 旋转图片 动作
        val matrix = Matrix()
        matrix.postRotate(angle.toFloat())
        println("angle2=$angle")
        // 创建新的图片
        return Bitmap.createBitmap(
            bitmap!!, 0, 0,
            bitmap.width, bitmap.height, matrix, true
        )
    }

    /**
     * 读取图片属性：旋转的角度
     *
     * @param path 图片绝对路径
     * @return degree旋转的角度
     */
    fun readPictureDegree(path: String?): Int {
        var degree = 0
        try {
            val exifInterface = ExifInterface(path!!)
            val orientation = exifInterface.getAttributeInt(
                ExifInterface.TAG_ORIENTATION,
                ExifInterface.ORIENTATION_NORMAL
            )
            when (orientation) {
                ExifInterface.ORIENTATION_ROTATE_90 -> degree = 90
                ExifInterface.ORIENTATION_ROTATE_180 -> degree = 180
                ExifInterface.ORIENTATION_ROTATE_270 -> degree = 270
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return degree
    }

    /**
     * 把字节数组保存为一个文件
     *
     * @param b
     * @param outputFile
     * @return
     */
    fun getFileFromBytes(b: ByteArray?, outputFile: String?): File? {
        var ret: File? = null
        var stream: BufferedOutputStream? = null
        try {
            ret = File(outputFile)
            val fstream = FileOutputStream(ret)
            stream = BufferedOutputStream(fstream)
            stream.write(b)
        } catch (e: Exception) {
            // log.error("helper:get file from byte process error!");
            e.printStackTrace()
        } finally {
            if (stream != null) {
                try {
                    stream.close()
                } catch (e: IOException) {
                    // log.error("helper:get file from byte process error!");
                    e.printStackTrace()
                }
            }
        }
        return ret
    }

    /**
     * 图片压缩
     *
     * @param fPath
     * @return
     */
    fun decodeFile(fPath: String?): Bitmap {
        val opts = BitmapFactory.Options()
        opts.inJustDecodeBounds = true
        opts.inDither = false // Disable Dithering mode
        opts.inPurgeable = true // Tell to gc that whether it needs free
        opts.inInputShareable = true // Which kind of reference will be used to
        BitmapFactory.decodeFile(fPath, opts)
        val REQUIRED_SIZE = 800
        var scale = 1
        if (opts.outHeight > REQUIRED_SIZE || opts.outWidth > REQUIRED_SIZE) {
            val heightRatio = Math.round(
                opts.outHeight.toFloat()
                        / REQUIRED_SIZE.toFloat()
            )
            val widthRatio = Math.round(
                opts.outWidth.toFloat()
                        / REQUIRED_SIZE.toFloat()
            )
            scale = if (heightRatio < widthRatio) heightRatio else widthRatio //
        }
        opts.inJustDecodeBounds = false
        opts.inSampleSize = scale
        return BitmapFactory.decodeFile(fPath, opts).copy(
            Bitmap.Config.ARGB_8888, false
        )
    }

    /**
     * 创建目录
     *
     * @param path
     */
    fun setMkdir(path: String?) {
        val file = File(path)
        if (!file.exists()) {
            file.mkdirs()
            Log.e("file", "目录不存在  创建目录    ")
        } else {
            Log.e("file", "目录存在")
        }
    }

    /**
     * 获取目录名称
     *
     * @param url
     * @return FileName
     */
    fun getFileName(url: String): String? {
        val lastIndexStart = url.lastIndexOf("/")
        return if (lastIndexStart != -1) {
            url.substring(lastIndexStart + 1, url.length)
        } else {
            null
        }
    }

    /**
     * 删除该目录下的文件
     *
     * @param path
     */
    fun delFile(path: String?) {
        if (!TextUtils.isEmpty(path)) {
            val file = File(path)
            if (file.exists()) {
                if (file.isDirectory) {
                    if (file.listFiles() == null || file.listFiles().size <= 0) {
                        file.delete()
                        return
                    }
                    for (f in file.listFiles()) {
                        delFile(f.absolutePath)
                    }
                }
                file.delete()
            }
        }
    }

    /**
     * 图像压缩(质量，大小)，
     *
     * @param fileUri
     * @return
     */
    fun scal(fileUri: Uri): File {
        val path = fileUri.path
        var outputFile = File(path)
        val fileSize = outputFile.length()
        val fileMaxSize = (200 * 1024).toLong()
        if (fileSize >= fileMaxSize) {
            val options = BitmapFactory.Options()
            options.inJustDecodeBounds = true
            BitmapFactory.decodeFile(path, options)
            val height = options.outHeight
            val width = options.outWidth
            val scale = Math.sqrt((fileSize.toFloat() / fileMaxSize).toDouble())
            options.outHeight = (height / scale).toInt()
            options.outWidth = (width / scale).toInt()
            options.inSampleSize = (scale + 0.8).toInt()
            options.inJustDecodeBounds = false
            val bitmap = BitmapFactory.decodeFile(path, options)
            val myPahth = createImageFile().path
            outputFile = File(myPahth)
            var fos: FileOutputStream? = null
            try {
                fos = FileOutputStream(outputFile)
                bitmap.compress(CompressFormat.JPEG, 100, fos)
                fos.close()
            } catch (e: IOException) {
                // TODO Auto-generated catch block
                e.printStackTrace()
            }
            if (!bitmap.isRecycled) {
                bitmap.recycle()
            } else {
                val tempFile = outputFile
                outputFile = File(createImageFile().path)
                copyFileUsingFileChannels(tempFile, outputFile)
            }
        }
        return outputFile
    }

    private val outputImageUri: String
        private get() = Date().time.toString() + ".png"

    fun createImageFile(): Uri {
        return Uri.parse(mImageFileCachePath() + outputImageUri)
        // Create an image file name
//        String imageFileName = System.currentTimeMillis() + "";
//        File storageDir = Environment.getExternalStoragePublicDirectory(
//                Environment.DIRECTORY_PICTURES);
//        File image = null;
//        try {
//            image = File.createTempFile(imageFileName, ".jpg", storageDir);
////            image = File.createTempFile(
////                    imageFileName,  /* prefix */
////                    .jpg,         /* suffix */
////                    storageDir      /* directory */
////            );
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//        // Save a file: path for use with ACTION_VIEW intents
//        return Uri.fromFile(image);
    }

    fun copyFileUsingFileChannels(source: File?, dest: File?) {
        var inputChannel: FileChannel? = null
        var outputChannel: FileChannel? = null
        try {
            try {
                inputChannel = FileInputStream(source).channel
                outputChannel = FileOutputStream(dest).channel
                outputChannel.transferFrom(inputChannel, 0, inputChannel.size())
            } catch (e: IOException) {
                // TODO Auto-generated catch block
                e.printStackTrace()
            }
        } finally {
            try {
                inputChannel!!.close()
                outputChannel!!.close()
            } catch (e: IOException) {
                // TODO Auto-generated catch block
                e.printStackTrace()
            }
        }
    }

    /**
     * 绝对路径转成相对路径
     *
     * @param context
     * @param uri
     * @return
     */
    fun getRealFilePath(context: Context, uri: Uri?): String? {
        if (null == uri) return null
        val scheme = uri.scheme
        var data: String? = null
        if (scheme == null) data = uri.path else if (ContentResolver.SCHEME_FILE == scheme) {
            data = uri.path
        } else if (ContentResolver.SCHEME_CONTENT == scheme) {
            val cursor = context.contentResolver.query(
                uri,
                arrayOf(MediaStore.Images.ImageColumns.DATA),
                null,
                null,
                null
            )
            if (null != cursor) {
                if (cursor.moveToFirst()) {
                    val index = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA)
                    if (index > -1) {
                        data = cursor.getString(index)
                    }
                }
                cursor.close()
            }
        }
        return data
    }
}