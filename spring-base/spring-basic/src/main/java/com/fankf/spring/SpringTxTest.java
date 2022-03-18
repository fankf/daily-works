package com.fankf.spring;

import com.fankf.config.TxConfig;
import com.fankf.tx.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * fankunfeng
 * 2020-09-12 23:59
 */
public class SpringTxTest {

    /**
       public XmlBeanFactory(Resource resource, BeanFactory parentBeanFactory) throws BeansException {
            // 加载父beanfactory
            // 其中 ignoreDependencyInterface(BeanNameAware.class); 为忽略自动装配
            // Spring会自动状态依赖或者传递依赖的类，但是Aware相关的类不会自动状态
            super(parentBeanFactory);
            // 初始化读取资源
            this.reader = new XmlBeanDefinitionReader(this);
            // 加载 Bean - 获取资源流，转换成Document,Document 转换成Bean加载
            this.reader.loadBeanDefinitions(resource);
        }
     */
    @Test
    public void account0(){
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("bean4.xml"));
        UserService userService = beanFactory.getBean("userService", UserService.class);
        userService.account();
    }

    @Test
    public void account(){
        ApplicationContext application = new ClassPathXmlApplicationContext("bean4.xml");
        UserService userService = application.getBean("userService", UserService.class);
        userService.account();
    }

    @Test
    public void account1(){
        ApplicationContext application = new ClassPathXmlApplicationContext("bean5.xml");
        UserService userService = application.getBean("userService", UserService.class);
        userService.account();
    }

    @Test
    public void account2(){
        ApplicationContext application = new AnnotationConfigApplicationContext(TxConfig.class);
        UserService userService = application.getBean("userService", UserService.class);
        userService.account();
    }

}
