package com.dxhy.ofdfile.config;

import com.dxhy.ofdfile.utils.SSLClientHttpRequestFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author fan
 * @create 2020-06-26 21:21
 * @description
 * @see
 */
@Configuration
public class WebConfig {

    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory factory){
        return new RestTemplate(factory);
    }

    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
        SSLClientHttpRequestFactory factory = new SSLClientHttpRequestFactory();
        factory.setReadTimeout(50000);
        factory.setConnectTimeout(15000);
        return factory;
    }
}
