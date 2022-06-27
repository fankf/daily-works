package com.fankf.spring;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.context.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.StringValueResolver;

/**
 * @author fans
 * @date 2022/6/23 16:16
 * @description
 */
public class PersonExt extends Person implements BeanClassLoaderAware,
        EnvironmentAware, EmbeddedValueResolverAware, ResourceLoaderAware,
        ApplicationEventPublisherAware, MessageSourceAware {
    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("【BeanClassLoaderAware】 类加载器 BeanClassLoaderAware.setBeanClassLoader");
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        System.out.println("【ApplicationEventPublisherAware】 事件发布 ApplicationEventPublisherAware.setApplicationEventPublisher");
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        System.out.println("【EmbeddedValueResolverAware】 基于Spring解析获取 properties 文件 EmbeddedValueResolverAware.setEmbeddedValueResolver");
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        System.out.println("【MessageSourceAware】解析消息 MessageSourceAware.setMessageSource");
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        System.out.println("【ResourceLoaderAware】 资源加载器 ResourceLoaderAware.setResourceLoader");
    }

    @Override
    public void setEnvironment(Environment environment) {
        System.out.println("【EnvironmentAware】 环境加载 Environment.setEnvironment");
    }
}
