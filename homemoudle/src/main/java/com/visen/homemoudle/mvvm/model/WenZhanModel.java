package com.visen.homemoudle.mvvm.model;

import android.content.Context;

import com.visen.homemoudle.base.log.LoadingDialogExtKt;
import com.visen.homemoudle.bean.WenZhanBean;
import com.visen.homemoudle.net.HttpConnect;
import com.visen.homemoudle.mvvm.view.SuccessView;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * @作者 严益云
 * @创建日期 2021/01/6
 * 类名 WenZhanModel.java
 * 文章网络数据请求
 */
public class WenZhanModel extends BaseModel {

    public WenZhanModel() {
        super();
    }

    public void loadDataFromNet(int page, SuccessView baselinsetener) {
        baselinsetener.showLoading();
        HttpConnect.networkRequest(getHomeApiService().getStudyURL(page), new DisposableObserver<WenZhanBean>() {
            @Override
            public void onNext(@NonNull WenZhanBean wenZhanBean) {
                baselinsetener.hideLoading();
                baselinsetener.onSuccess(wenZhanBean);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                baselinsetener.hideLoading();
            }

            @Override
            public void onComplete() {
                baselinsetener.hideLoading();
            }
        });

    }

}
