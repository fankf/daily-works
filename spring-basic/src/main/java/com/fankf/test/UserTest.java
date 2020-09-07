package com.fankf.test;

import com.fankf.ioc.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * fankunfeng
 * 2020-09-03 10:43
 */
public class UserTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        User user = context.getBean("user", User.class);
        user.add();
    }
}
