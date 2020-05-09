package com.fankf.bean;

import lombok.ToString;

import java.util.List;

@ToString
public class People {
    private int sex;
    protected int age;
    public List<String> tag;
    String color;


    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }


}
