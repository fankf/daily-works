package com.fankf.spring;

import com.fankf.config.TxConfig;
import com.fankf.tx.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * fankunfeng
 * 2020-09-12 23:59
 */
public class SpringTxTest {

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
