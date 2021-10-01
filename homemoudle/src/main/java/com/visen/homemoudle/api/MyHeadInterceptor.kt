package com.visen.homemoudle.api

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

/**
 * 自定义头部参数拦截器，传入heads
 */
class MyHeadInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder().apply {
            /*  addHeader("token", "token123456").build()
              addHeader("device", "Android").build()*/
            addHeader("accept", "*/*")
            addHeader("content-type", "application/json")
            addHeader("cache-control", "no-cache")
        }

        return chain.proceed(builder.build())
    }

}