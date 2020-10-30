package com.fankf.springmvc;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * fankunfeng
 * 2020-10-23 15:11
 */
@XStreamAlias("FPXT")
public class FPXT {
    private String INPUT;
    private OUTPUT OUTPUT;

    public String getINPUT() {
        return INPUT;
    }

    public void setINPUT(String INPUT) {
        this.INPUT = INPUT;
    }


    public OUTPUT getOUTPUT() {
        return OUTPUT;
    }

    public void setOUTPUT(OUTPUT OUTPUT) {
        this.OUTPUT = OUTPUT;
    }
}
