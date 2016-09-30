package com.conan.conantch.config;

/**
 * 网络请求统一处理返回值
 * Created by conan on 16/9/29.
 */
public class HttpResult<T> {

    private int ret;
    private String msg;
    private T data;

    public int getRet() {
        return ret;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }
}
