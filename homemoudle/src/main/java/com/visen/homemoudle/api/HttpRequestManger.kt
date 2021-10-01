package com.visen.homemoudle.api

import com.visen.homemoudle.bean.WZBean
import com.visen.homemoudle.bean.WZDetailBean
import com.visen.homemoudle.bean.WenZhanDataBean

/**
 * 作者　: yanyy
 * 时间　: 2020/5/4
 * 描述　: 处理协程的请求类
 */

val HttpRequestCoroutine: HttpRequestManger by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
    HttpRequestManger()
}

class HttpRequestManger {

    suspend fun getWenZhanData(pageNo: Int): WenZhanDataBean {
        return apiService.getAllWZ(pageNo)
    }

    suspend fun getSanWenWZ(pageNo: Int): WenZhanDataBean {
        return apiService.getSanWenWZ(pageNo)
    }

    suspend fun getGanWuWZ(pageNo: Int): WZBean {
        return apiService.getGanWuWZ(pageNo)
    }

    suspend fun getDetail(id: String): WZDetailBean {
        return apiService.getWZDetail(id)
    }

    suspend fun getTypeWZ(num: Int, pageNo: Int): WZBean {
        var type = "all"
        when (num) {
            0 -> type = "all"
            1 -> type = "sanwen"
            2 -> type = "ganwu"
            3 -> type = "lizhi"
            4 -> type = "aiqing"
        }
        return apiService.getTypeWZ(type, pageNo)
    }


}