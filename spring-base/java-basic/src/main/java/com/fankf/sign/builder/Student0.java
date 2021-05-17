package com.fankf.sign.builder;

public class Student0 {

    private String stuNo;
    private String name;
    private String age;
    private String phone;
    private String email;
    private String address;


    public String getStuNo() {
        return stuNo;
    }

    public Student0 setStuNo(String stuNo) {
        this.stuNo = stuNo;
        return this;
    }

    public String getName() {
        return name;
    }

    public Student0 setName(String name) {
        this.name = name;
        return this;
    }

    public String getAge() {
        return age;
    }

    public Student0 setAge(String age) {
        this.age = age;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Student0 setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Student0 setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Student0 setAddress(String address) {
        this.address = address;
        return this;
    }

    // 创建实例
    public static Student0 newInstance() {
        return new Student0();
    }
}
