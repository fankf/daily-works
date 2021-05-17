package com.fankf.springmvc.http;

import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@Configuration
public class WebConfig {

    @Value("${okHttp.retryCount}")
    private int count;
    @Value("#{'${okHttp.urls}'.split(',')}")
    private List<String> urls;

    @Bean("rest")
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean("okhttp3")
//    @Primary
    public RestTemplate okHttpRestTemplate() {
        return new RestTemplate(new OkHttp3ClientHttpRequestFactory(okHttpClient(urls)));
    }

    private OkHttpClient okHttpClient(List<String> urls) {
        if (urls.isEmpty()) {
            log.error("请求 地址为空，请检查配置文件");
            System.exit(0);
        }
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new OkHttpRetryInterceptor(1, urls))
                .retryOnConnectionFailure(true)
                .connectTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .build();
        return client;
    }
}
