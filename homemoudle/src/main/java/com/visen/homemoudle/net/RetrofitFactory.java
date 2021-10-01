package com.visen.homemoudle.net;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.visen.homemoudle.api.HomeApi;
import com.visen.homemoudle.api.Urls;
import com.visen.homemoudle.net.Interceptor.HeaderInterceptor;

import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @作者 严益云
 * @创建日期 2020/11/19
 * 类名 RetrofitFactory.java
 */
public class RetrofitFactory {

    private static Retrofit retrofit;
    private static RetrofitFactory instance = new RetrofitFactory(true);
    private final static int TIME = 20000;
    private static OkHttpClient oc;
    private static Gson gson;

    private RetrofitFactory(boolean isToken) {

        TrustManagerFactory trustManagerFactory = null;
        try {
            trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }

        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        }
        X509TrustManager trustManager = (X509TrustManager) trustManagers[0];
        SSLContext sslContext = null;
        try {
            sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[]{trustManager}, null);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
        SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

        oc = new OkHttpClient.Builder()
                .retryOnConnectionFailure(false)
                .connectTimeout(TIME, TimeUnit.MILLISECONDS)
                .readTimeout(TIME, TimeUnit.MILLISECONDS)
                .writeTimeout(TIME, TimeUnit.MILLISECONDS)
                .sslSocketFactory(sslSocketFactory, trustManager)
                .addNetworkInterceptor(OkhttpLoggerInterceptor.build())
                .addInterceptor(new HeaderInterceptor(isToken))
                .build();
        gson = new GsonBuilder()
                .setLenient()
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl(Urls.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(oc)
                .build();

    }


    private static RetrofitFactory getSever() {
        instance = new RetrofitFactory(false);
        return instance;
    }

    public static <V> V getServices(Class<V> service) {
        return getSever().retrofit.create(service);
    }
}
