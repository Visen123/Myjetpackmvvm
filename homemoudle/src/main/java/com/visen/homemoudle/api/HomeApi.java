package com.visen.homemoudle.api;

import com.visen.homemoudle.bean.WenZhanBean;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * @作者 严益云
 * @创建日期 2020/12/11
 * 类名 HomeApi.java
 * 首页接口数据请求方式
 */
public interface HomeApi {

    // TODO: 阅读文章
    @GET(Urls.SWURL + "{page}.txt")
    Observable<ResponseBody> getSWURL(@Path("page") int page);


    // TODO: 阅读文章
    @GET(Urls.CGMW_ALL_EDITORTJ + "{page}.txt")
    Observable<WenZhanBean> getStudyURL(@Path("page") int page);


}
