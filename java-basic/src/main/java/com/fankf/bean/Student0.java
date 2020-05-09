package com.fankf.bean;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student0 extends People {
    public int id;
    protected String name;
    Date createTime;

    public static Student0 demo() {
        return new Student0(1, "12", new Date());
    }
}
