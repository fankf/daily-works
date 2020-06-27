package com.dxhy.ofdfile.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
