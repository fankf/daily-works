package com.fankf.bean;

public class People {
    private int sex;
    private String username;
    private int age;

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
                "sex=" + sex +
                ", username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
