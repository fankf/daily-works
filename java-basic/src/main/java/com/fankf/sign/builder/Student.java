package com.fankf.sign.builder;

public class Student {
    private String stuNo;
    private String name;
    private String age;
    private String phone;
    private String email;
    private String address;

    private Student(Student.Builder builder) {
        this.stuNo = builder.stuNo;
        this.name = builder.name;
        this.age = builder.age;
        this.phone = builder.phone;
        this.email = builder.email;
        this.address = builder.address;
    }

    // getXX
    public String getStuNo() {
        return stuNo;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    //获取内部类
    public static Student.Builder newBuild(){
        return new Builder();
    }

    //静态内部类
    public static class Builder{
        private String stuNo;
        private String name;
        private String age;
        private String phone;
        private String address;
        private String email;

        // 私有构造器
        private Builder(){}

        public Student build(){
            return new Student(this);
        }

        public Student.Builder setStuNo(String stuNo) {
            this.stuNo = stuNo;
            return this;
        }

        public Student.Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Student.Builder setAge(String age) {
            this.age = age;
            return this;
        }

        public Student.Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Student.Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Student.Builder setAddress(String address) {
            this.address = address;
            return this;
        }
    }
}
