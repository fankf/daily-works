package com.fankf.spring;

import com.fankf.bean.Student;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractBeanDefinitionParser;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * @author fankunfeng
 * @date 2022-07-09 23:46
 */
public class StudentBeanDefinationParser extends AbstractSingleBeanDefinitionParser {
    @Override
    protected Class<?> getBeanClass(Element element) {
        return Student.class;
    }
    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        String name = element.getAttribute("name");
        String email = element.getAttribute("email");
        // 将所有的数据放入ParserContext 中，等到所有bean解析完成统一放入BeanFactory中
        if (StringUtils.hasText(name))
            builder.addPropertyValue("name", name);
        if (StringUtils.hasText(email))
            builder.addPropertyValue("email", email);
    }

}
