package com.fankf.springmvc.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertiesFiled implements InitializingBean {
    private static PropertiesFiled filed = null;

    public static PropertiesFiled filed() {
        return filed;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        filed = this;
    }

    @Value("${z-username}")
    private String username;
    @Value("${z-password}")
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
