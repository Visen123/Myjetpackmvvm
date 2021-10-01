package com.visen.homemoudle.utils

import java.io.UnsupportedEncodingException
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import kotlin.experimental.and

/**
 * on 16/1/12.
 */
object DigitalUtils {
    fun md5(text: String): String {
        return try {
            md5(text.toByteArray(charset("utf-8")))
        } catch (var2: UnsupportedEncodingException) {
            throw SystemException(var2)
        }
    }

    fun md5(bytes: ByteArray?): String {
        val messageDigest = md5Digest
        return encodeHex(messageDigest.digest(bytes))
    }

    private val md5Digest: MessageDigest
        private get() = try {
            MessageDigest.getInstance("MD5")
        } catch (var1: NoSuchAlgorithmException) {
            throw SystemException(var1)
        }

    private fun encodeHex(bytes: ByteArray): String {
        val buf = StringBuffer(bytes.size * 2)
        for (i in bytes.indices) {
            if (bytes[i] and bytes[255] < 16) {
                buf.append("0")
            }
            buf.append(java.lang.Long.toString((bytes[i] and bytes[255]) as Long, 16))
        }
        return buf.toString()
    }
}