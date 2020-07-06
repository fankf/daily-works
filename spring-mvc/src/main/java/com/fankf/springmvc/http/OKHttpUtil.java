package com.fankf.springmvc.http;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
public class OKHttpUtil {
    static String urlss = "http://localhost:8080,http://localhost:11000/post,http://localhost:11000/put0";
    private static OkHttpClient okHttpClient(List<String> urls) {
        if (urls.isEmpty()) {
            log.error("请求地址为空，请检查配置文件");
            System.exit(0);
        }
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new OkHttpRetryInterceptor(3, urls))
                .retryOnConnectionFailure(true)
                .connectTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .build();
        return client;
    }

    private static Request getRequest(String url, RequestBody body, Headers headers) {
        Request request = new Request.Builder()
                .url(url)
                .post(body)
//                .headers(headers)
                .build();
        return request;
    }

}
