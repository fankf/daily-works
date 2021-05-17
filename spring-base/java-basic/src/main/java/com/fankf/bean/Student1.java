package com.fankf.bean;

import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@ToString
public class Student1 {
    private int id;
    private String name;
    private Date createTime;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Student1() {
    }

    public Student1(int id) {
        this.id = id;
    }

    public Student1(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student1(int id, String name, Date createTime) {
        this.id = id;
        this.name = name;
        this.createTime = createTime;
    }


    public static Student1 demo() {
        return new Student1(1, "12", new Date());
    }

    public static List<Student1> list() {
        List<Student1> list = new ArrayList<>();
        list.add(new Student1(101, "AAA", new Date()));
        list.add(new Student1(102, "BBB", new Date()));
        list.add(new Student1(103, "CCC", new Date()));
        list.add(new Student1(104, "DDD", new Date()));
        list.add(new Student1(105, "EEE", new Date()));
        list.add(new Student1(106, "FFF", new Date()));
        return list;

    }

    public static void main(String[] args) {
        String s = demo().toString();
        System.out.println(s);
    }
}
