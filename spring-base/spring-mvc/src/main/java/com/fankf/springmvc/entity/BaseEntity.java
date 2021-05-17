package com.fankf.springmvc.entity;

/**
 * fankunfeng
 * 2020-09-03 11:01
 */
public class BaseEntity {
    public Integer getFdataversion() {
        return fdataversion;
    }

    public void setFdataversion(Integer fdataversion) {
        this.fdataversion = fdataversion;
    }

    public Integer getFmacversion() {
        return fmacversion;
    }

    public void setFmacversion(Integer fmacversion) {
        this.fmacversion = fmacversion;
    }

    public String getFmac() {
        return fmac;
    }

    public void setFmac(String fmac) {
        this.fmac = fmac;
    }

    private Integer fdataversion;
    private Integer fmacversion;

    private String fmac;
}
