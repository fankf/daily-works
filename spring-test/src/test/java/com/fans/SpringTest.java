package com.fans;

import com.fans.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * @author fans
 * @date 2022/6/30 19:43
 * @description
 */

public class SpringTest {

    @Test
    void test(){
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("bean1.xml"));
        User user = (User) beanFactory.getBean("user");
        System.out.println(user.getName());
    }
}
