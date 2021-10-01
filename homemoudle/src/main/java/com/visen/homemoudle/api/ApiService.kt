package com.visen.homemoudle.api

import com.visen.homemoudle.bean.WZBean
import com.visen.homemoudle.bean.WZDetailBean
import com.visen.homemoudle.bean.WenZhanDataBean
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * 类名:  ApiService
 * 作者:  yanyiyun
 * 时间:  2021/9/17 15:21
 * 描述:网络API
 */
interface ApiService {
    companion object {
        const val SERVER_URL = "http://www.duwenz.com/"
        const val TYPES = "types"
    }

    // TODO: 推荐阅读文章
    @GET("txtjson/classgroup/cgmw_all_editortj_{page}.txt")
    suspend fun getAllWZ(@Path("page") page: Int): WenZhanDataBean


    // TODO: 散文阅读文章
    @GET("txtjson/classgroup/cgmw_sanwen_editortj_{page}.txt")
    suspend fun getSanWenWZ(@Path("page") page: Int): WenZhanDataBean


    // TODO: 感悟阅读文章
    @GET("txtjson/classgroup/cgmw_ganwu_editortj_{page}.txt")
    suspend fun getGanWuWZ(@Path("page") page: Int): WZBean


    // TODO: 全部类型阅读文章
    @GET("txtjson/classgroup/cgmw_{type}_editortj_{page}.txt")
    suspend fun getTypeWZ(@Path("type") type: String, @Path("page") page: Int): WZBean

    // TODO: 阅读文章详情
    @GET("txtjson/wzview/1/{id}.txt")
    suspend fun getWZDetail(@Path("id") key: String): WZDetailBean

}