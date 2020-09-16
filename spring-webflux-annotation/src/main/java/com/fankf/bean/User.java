package com.fankf.bean;

/**
 * fankunfeng
 * 2020-09-16 22:00
 */
public class User {

    private String username;
    private String gender;
    private Integer age;

    public User() {
    }

    public User(String username, String gender, Integer age) {
        this.username = username;
        this.gender = gender;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
