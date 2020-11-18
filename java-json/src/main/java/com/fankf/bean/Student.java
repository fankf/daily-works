package com.fankf.bean;

import com.thoughtworks.xstream.annotations.*;
import com.thoughtworks.xstream.converters.basic.BooleanConverter;
import lombok.*;

import java.util.List;

@Setter
@Getter
@ToString
@XStreamAlias("student") // 类别名
public class Student {
//    @XStreamOmitField
    @XStreamAsAttribute // 隐藏节点
    private String studentNo;
    @XStreamAlias("name") // 属性别名
    private String studentName;
    private int studentAge;
    @XStreamImplicit // 省略集合根节点
    private List<Phone> phoneList;
    @XStreamConverter(value = BooleanConverter.class,booleans = {true,false},strings = {"男","女"})
    private boolean sex;

    public Student() {
    }

    public Student(String studentNo, String studentName, int studentAge) {
        this.studentNo = studentNo;
        this.studentName = studentName;
        this.studentAge = studentAge;
    }
}
