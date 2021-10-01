package com.visen.homemoudle.mvvm.model;

import com.visen.homemoudle.api.HomeApi;
import com.visen.homemoudle.net.MyRetrofit;

import retrofit2.Retrofit;

/**
 * @作者 严益云
 * @创建日期 2020/12/1
 * 类名 BaseModel.java
 */
public abstract class BaseModel {

    private Retrofit retrofit;

    public BaseModel() {
        if (retrofit == null) {
            retrofit = MyRetrofit.getRetrofits();
        }

    }

    public <V> V getServices(Class<V> service) {
        return retrofit.create(service);
    }


    public HomeApi getHomeApiService() {
        return retrofit.create(HomeApi.class);
    }


}
