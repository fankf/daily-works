package com.fankf.xml.xstream;

import com.fankf.bean.Phone;
import com.fankf.bean.Student;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * fankunfeng
 * 2020-11-17 23:19
 */
public class XtreamTest {

    public static void main(String[] args) {
        Student student = new Student();
        student.setStudentAge(12);
        student.setStudentName("小花");
        student.setStudentNo("001");
        Phone phone = new Phone();
        phone.setName("Honor20");
        phone.setDesciption("20");

        Phone phon2e = new Phone();
        phon2e.setName("Honor30");
        phon2e.setDesciption("30");
        List<Phone> list = new ArrayList<>();
        list.add(phon2e);
        list.add(phone);
        student.setPhoneList(list);
        XStream stream = new XStream();//需要XPP3库
        //XStream xStream = new XStream(new DomDriver());//不需要XPP3库
        //XStream xStream = new XStream(new StaxDriver());//不需要XPP3库开始使用Java 6
        stream.registerConverter(new StudentConvert());
//        mixed(student,stream);
//        classMixed(student,stream);
//        propertiesMixed(student,stream);
        collectionsMixed(student,stream);

    }



    // 隐式集合混叠，也就是使用别名替代类 @XStreamAlias
    private static void collectionsMixed(Student student, XStream stream) {
        stream.addImplicitCollection(Student.class,"phoneList");
        propertiesMixed(student,stream);
    }

    // 类混叠，也就是使用别名替代类 @XStreamAlias
    private static void classMixed(Student student, XStream stream) {
        stream.alias("student",Student.class);
        stream.alias("phone",Phone.class);
        simpleConvert(student,stream);
    }
    // 混叠 同属性注解@XStreamFiled
    private static void propertiesMixed(Student student, XStream stream) {
        stream.aliasField("name",Student.class,"studentName");
        classMixed(student,stream);
    }
    // 混叠
    private static void mixed(Student student, XStream stream) {
        simpleConvert(student,stream);
    }
    // 1. 简单转换xxml ,java bean
    private static void simpleConvert(Student student, XStream stream) {
        // xml to json
//        stream = new XStream(new JettisonMappedXmlDriver());
        // java Bean to XML
        String toXML = stream.toXML(student);
        System.out.println(toXML);
        // xml to javaBean
        Student stu = (Student) stream.fromXML(toXML);
        System.out.println(stu);
    }
}
