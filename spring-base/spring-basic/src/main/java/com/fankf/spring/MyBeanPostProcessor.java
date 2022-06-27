package com.fankf.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author fans
 * @date 2022/6/23 15:40
 * @description
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Person) {
            System.out.println("【BeanPostProcessor】MyBeanPostProcessor.postProcessBeforeInitialization");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Person) {
            System.out.println("【BeanPostProcessor】MyBeanPostProcessor.postProcessAfterInitialization");
        }
        return bean;
    }
}
