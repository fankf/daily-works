package com.fankf.bean;

import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@ToString
public class Student0 extends People {
    public int id;
    protected String name;
    Date createTime;

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

    public Student0() {
    }

    public Student0(int id) {
        this.id = id;
    }

    public Student0(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student0(int id, String name, Date createTime) {
        this.id = id;
        this.name = name;
        this.createTime = createTime;
    }


    public static Student0 demo() {
        return new Student0(1, "12", new Date());
    }

    public static List<Student0> list() {
        List<Student0> list = new ArrayList<>();
        list.add(new Student0(101, "AAA", new Date()));
        list.add(new Student0(102, "BBB", new Date()));
        list.add(new Student0(103, "CCC", new Date()));
        list.add(new Student0(104, "DDD", new Date()));
        list.add(new Student0(105, "EEE", new Date()));
        list.add(new Student0(106, "FFF", new Date()));
        return list;

    }

    @Override
    public String toString() {
        return "id => " + id + " name -> " + name + " createTime -> " + createTime;
    }
}
