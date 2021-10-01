package com.visen.homemoudle.net;


import com.visen.homemoudle.utils.LogHelper;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @作者 严益云
 * @创建日期 2020/11/19
 * 类名 OkhttpLoggerInterceptor.java
 */
public class OkhttpLoggerInterceptor {

    public static HttpLoggingInterceptor build() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new Logger());
        //这行必须加 不然默认不打印
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    public static class Logger implements HttpLoggingInterceptor.Logger {

        private static final String TAG = "okhttp";

        @Override
        public void log(String message) {
            if (message == null) {
            } else if (message.startsWith("{")) {
                LogHelper.printJson("okhttp", message, "body");
            } else {
                LogHelper.d("okhttp", message);
            }
        }
    }
}
