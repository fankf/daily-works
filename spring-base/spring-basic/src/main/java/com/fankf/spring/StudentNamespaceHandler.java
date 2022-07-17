package com.fankf.spring;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author fankunfeng
 * @date 2022-07-09 23:53
 */
public class StudentNamespaceHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        // 以stu 开始的标签交给 StudentBeanDefinationParser 进行解析
        registerBeanDefinitionParser("user", new StudentBeanDefinationParser());
    }
}
