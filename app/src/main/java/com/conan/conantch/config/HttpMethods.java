package com.conan.conantch.config;

import com.conan.conantch.model.entities.LoginEntity;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * HttpMethods 网络请求封装
 * Created by conan on 16/9/29.
 */
public class HttpMethods {

    public static final String BASEURL = "http://api.12xuetest.com/";

    private static final int DEFAULT_TIMEOUT = 5;
    private static final String CLIENT_ID = "12xue_tch";
    private static final String CLIENT_SECRET = "7e4602f8a5df3da01c5110e24b42b78f";
    private Retrofit retrofit;
    private HttpService service;


    public HttpMethods() {

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request()
                                .newBuilder()
                                .addHeader("Source", Api.Source)
                                .addHeader("Version", Api.Version)
                                .addHeader("Token", Api.Token)
                                .build();
                        return chain.proceed(request);
                    }
                }).build();

        retrofit = new Retrofit.Builder()
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASEURL)
                .build();
        service = retrofit.create(HttpService.class);
    }

    private static class SingletonHolder {
        private static final HttpMethods INSTANCE = new HttpMethods();
    }

    public static HttpMethods getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void login(Subscriber<LoginEntity> subscriber, String account, String password) {
        service.login(account, password, CLIENT_ID, CLIENT_SECRET)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    private class HttpResultFunc<T> implements Func1<HttpResult<T>, T> {

        @Override
        public T call(HttpResult<T> httpResult) {
            if (httpResult.getRet() != 0) {
                throw new ApiException(httpResult.getMsg());
            }
            return null;
        }
    }
}
