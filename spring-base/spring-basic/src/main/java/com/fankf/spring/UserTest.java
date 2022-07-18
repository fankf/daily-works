package com.fankf.spring;

import com.alibaba.druid.support.json.JSONUtils;
import com.fankf.UserDemo;
import com.fankf.aop.bean.User;
import com.fankf.aop.xmlaop.Book;
import com.fankf.bean.Student;
import com.fankf.jdbc.bean.User1;
import com.fankf.jdbc.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * fankunfeng
 * 2020-09-03 10:43
 */
public class UserTest {

    @Test
    public void userTest() {
        BeanFactory context = new XmlBeanFactory(new ClassPathResource("bean6.xml"));
        UserDemo user = context.getBean("user", UserDemo.class);
        System.out.println("【返回结果】" + user);
    }

    @Test
    public void test() {
        BeanFactory context = new XmlBeanFactory(new ClassPathResource("bean6.xml"));
//        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
//        User1 user = context.getBean("user1", User1.class);
        Person person = context.getBean(PersonExt.class);
//        Student student = (Student) context.getBean("zs");
//        System.out.println(user);
//        System.out.println("【实例使用】"+user);
        System.out.println("【实例使用】"+person);
//        System.out.println("【实例使用】" + student.getEmail() + "-" + student.getName());
//        context.close();
    }


    @Test
    public void testIoc() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        User user = context.getBean("user", User.class);
        user.add();
    }

    @Test
    public void testAop() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        Book user = context.getBean("book", Book.class);
        user.buy();


    }

    @Test
    public void testJdbcTemplateInsert() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        UserService userService = context.getBean("userService", UserService.class);
        User1 user = new User1();
        user.setUsername("nannan");
        user.setAge(18);
        int i = userService.insertUser(user);
        System.out.println(i);
    }

    @Test
    public void testJdbcTemplateUpdate() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        UserService userService = context.getBean("userService", UserService.class);
        User1 user = new User1();
        user.setId(1);
        user.setUsername("nannan");
        user.setAge(19);
        int i = userService.updateUserById(user);
        System.out.println(i);
    }

    @Test
    public void testJdbcTemplateDelete() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        UserService userService = context.getBean("userService", UserService.class);
        int i = userService.deleteUserById(1);
        System.out.println(i);
    }

    @Test
    public void testJdbcTemplateCount() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        UserService userService = context.getBean("userService", UserService.class);
        int i = userService.countUser();
        System.out.println(i);
    }

    @Test
    public void testJdbcTemplateSelectOne() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        UserService userService = context.getBean("userService", UserService.class);
        User1 user = userService.selectUserById(2);
        System.out.println(user);
    }

    @Test
    public void testJdbcTemplateSelect() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        UserService userService = context.getBean("userService", UserService.class);
        List<User1> user = userService.selectUser();
        System.out.println(user);
    }


    @Test
    public void testJdbcTemplateInsertBatch() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        UserService userService = context.getBean("userService", UserService.class);
        Object[] o1 = {null, "Z1", 11};
        Object[] o2 = {null, "z2", 12};
        Object[] o3 = {null, "z3", 33};
        List<Object[]> objects = Arrays.asList(o1, o2, o3);
        int t = userService.insertBatch(objects);
        System.out.println(t);
    }

    @Test
    public void testJdbcTemplateUpdateBatch() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        UserService userService = context.getBean("userService", UserService.class);
        Object[] o1 = {"aa", 12, 3};
        Object[] o2 = {"bb", 12, 4};
        Object[] o3 = {"vv", 12, 5};
        List<Object[]> objects = Arrays.asList(o1, o2, o3);
        int t = userService.updateBatch(objects);
        System.out.println(t);
    }

    @Test
    public void testJdbcTemplateDeleteBatch() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        UserService userService = context.getBean("userService", UserService.class);
        Object[] o1 = {3};
        Object[] o2 = {4};
        List<Object[]> objects = Arrays.asList(o1, o2);
        int t = userService.deleteBatch(objects);
        System.out.println(t);
    }
}
