package com.visen.homemoudle.net.Interceptor;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


/**
 * @作者 严益云
 * @创建日期 2020/11/24
 * 类名 HeaderInterceptor.java
 */
public class HeaderInterceptor implements Interceptor {
    private boolean token = true;

    public HeaderInterceptor(boolean token) {
        this.token = token;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        // String str = "app4android:secret";
        //String base64Str = "Basic " + Base64.encodeToString(str.getBytes(), Base64.DEFAULT).replaceAll("\r|\n", "");
        Request request = chain.request();
        Request.Builder builder = request.newBuilder()
                .addHeader("accept", "*/*")
                // .addHeader("authorization", "Basic YXBwNGFuZHJvaWQ6c2VjcmV0")
                .addHeader("content-type", "application/json")
                .addHeader("cache-control", "no-cache");

        Request newRequest = builder.build();
        return chain.proceed(newRequest);
    }

}
