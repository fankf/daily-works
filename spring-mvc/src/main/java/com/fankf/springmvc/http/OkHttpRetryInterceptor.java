package com.fankf.springmvc.http;

import lombok.extern.slf4j.Slf4j;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;

@Slf4j
public class OkHttpRetryInterceptor implements Interceptor {

    private int retryCount;
    private List<String> address;

    public OkHttpRetryInterceptor(int retryCount, List<String> address) {
        this.retryCount = retryCount;
        this.address = address;
    }

    @NotNull
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        // try the request
        Response response = this.doRequest(chain, request);
        int tryCount = 0;
        String url = request.url().toString();
        //总次数
        int count = retryCount * (address.size() + 1);
        while (response == null && tryCount < count) {
            String old = url;
            url = this.switchServer(url, tryCount / retryCount, (tryCount + 1) / retryCount);
            Request newRequest = request.newBuilder().url(url).get().build();
            log.warn("Http Request is failed , Request index - {} , Old url - {} , New url = {}", tryCount, old, url);
            // retry the request
            tryCount++;
            response = this.doRequest(chain, newRequest);
        }
        if (response == null) {
            throw new IOException();
        }
        return response;
    }

    private Response doRequest(Chain chain, Request request) {
        Response response = null;
        try {
            response = chain.proceed(request);
        } catch (Exception e) {
        }
        return response;
    }


    /**
     * 循环取址
     *
     * @param url
     * @param oldIndex
     * @param newIndex
     * @return
     */
    private String switchServer(String url, int oldIndex, int newIndex) {
        String newUrlString = url;
        if (oldIndex == newIndex) {
            return newUrlString;
        } else {
            return address.get(newIndex);
        }
    }
}
