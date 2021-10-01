package com.visen.homemoudle.net;

import io.reactivex.Observable;
import io.reactivex.Observer;

public class HttpConnect<T> {

    /**
     * 基础网络请求
     *
     * @param observable
     * @param observer
     * @param <T>
     */
    public static <T> void networkRequest(Observable<T> observable, Observer<T> observer) {
        observable.compose(RxSchedulers.<T>io_main())
                .subscribe(observer);
    }


}
