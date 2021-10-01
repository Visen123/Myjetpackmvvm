package com.visen.homemoudle.net;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RxSchedulers {

    private static final long RETRY_TIMES = 1;

    public static <T> ObservableTransformer<T, T> io_main() {

        return new ObservableTransformer<T, T>() {

            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.retry(RETRY_TIMES)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}
