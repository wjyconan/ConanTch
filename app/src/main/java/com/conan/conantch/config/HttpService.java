package com.conan.conantch.config;

import com.conan.conantch.model.entities.LoginEntity;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Retrofit 请求方法
 * Created by conan on 16/9/29.
 */
public interface HttpService {

    String[] headers = {"Source:"+Api.Source,"Version:"+Api.Version,"Token:"+Api.Token};

    @FormUrlEncoded
    @POST(Api.userLogin)
    Observable<LoginEntity> login(@Field("account") String account, @Field("password") String password,
                                  @Field("client_id") String clientId, @Field("client_secret") String clientSecret);
}
