package com.fankf.sign.builder;

public class StudentTest {
    public static void main(String[] args) {

        Student0 student0 = Student0.newInstance().setAddress("北京市中关村南大街1号").setAge("123").setEmail("123@163.com");
        System.out.println(student0.getAddress());
        System.out.println(student0.getAge());
        System.out.println("************");
        Student build = Student.newBuild().setAddress("北京市中关村南大街2号").build();
        System.out.println(build.getAddress());



    }
}
