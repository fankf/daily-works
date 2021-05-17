package com.fankf.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * fankunfeng
 * 2020-11-18 19:22
 */
@XStreamAlias("phone")
public class Phone {
    private String name;
    private String desciption;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }
}
