package com.fankf.spring;

import com.fankf.bean.People;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.ResolvableType;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.Base64Utils;

import java.io.Serializable;

/**
 * @author fankf
 * @date 2021/7/19 16:49
 * @description
 */
public class BeanFactoryTest extends Base64Utils implements Serializable {
    public static void main(String[] args) {
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("bean1.xml"));
        People people = (People) beanFactory.getBean("people");
        people.setAge(1);
        System.out.println(people.toString());
        System.out.println(beanFactory.containsBean("people"));
        System.out.println(beanFactory.getBean(People.class).getClass());
        System.out.println(beanFactory.getAliases("people"));
        /**
         * 可以获取带泛型的参数
         * ResolvableType type = ResolvableType.forClassWithGenerics(MyType.class, TheType.class);
         * ObjectProvider<MyType<TheType>> op = applicationContext.getBeanProvider(type);
         * MyType<TheType> bean = op.getIfAvailable()
         */
        ObjectProvider<Object> beanProvider = beanFactory.getBeanProvider(ResolvableType.forClass(People.class));
        People ifAvailable = (People) beanProvider.getIfAvailable();
        System.out.println(ifAvailable);


    }
}
