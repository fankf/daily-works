package com.fankf.springmvc.http;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

@Slf4j
public class OkHttpRetryInterceptor implements Interceptor {

    public static final String encoding = "UTF-8";

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
        //移除头部参数
        request = request.newBuilder()
                .removeHeader("User-Agent")
                .removeHeader("Accept-Encoding")
                .build();
        // try the request
        Response response = this.doRequest(chain, request);
        int tryCount = 0;
        String url = request.url().toString();
        //总次数
        int count = retryCount * address.size();
        while (response == null && tryCount < count) {
            String old = url;
            if((tryCount + 1) / retryCount < address.size() ){
                url = this.switchServer(url, tryCount / retryCount, (tryCount + 1) / retryCount);
            }
//            url = this.switchServer(url, tryCount / retryCount, (tryCount + 1) / retryCount);
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
            setHeaderContentType(request);
            response = chain.proceed(request);
        } catch (Exception e) {
        }
        return response;
    }

    /**
     * set contentType in headers
     * @param response
     * @throws IOException
     */
    private void setHeaderContentType(Request request) throws IOException {
        String contentType = request.header("Content-Type");
        RequestBody body = request.body();
        if (StringUtils.isNotBlank(contentType) && contentType.contains("charset")) {
            return;
        }
        // build new headers
        Headers headers = request.headers();
        Headers.Builder builder = headers.newBuilder();
        builder.removeAll("Content-Type");
        builder.add("Content-Type", (StringUtils.isNotBlank(contentType) ? contentType + "; ":"" ) + "charset=" + encoding);
        headers = builder.build();
        // setting headers using reflect
        Class  _response = Response.class;
        try {
            Field field = _response.getDeclaredField("headers");
            field.setAccessible(true);
            field.set(request, headers);
        } catch (NoSuchFieldException e) {
            throw new IOException("use reflect to setting header occurred an error", e);
        } catch (IllegalAccessException e) {
            throw new IOException("use reflect to setting header occurred an error", e);
        }
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
