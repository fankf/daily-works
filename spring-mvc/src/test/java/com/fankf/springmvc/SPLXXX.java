package com.fankf.springmvc;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * fankunfeng
 * 2020-10-23 15:11
 */
@XStreamAlias("DATA")
public class SPLXXX {
    private Integer LXSC;
    private String ZZLFSJ;
    private String JSPSJ;

    public String getZZLFSJ() {
        return ZZLFSJ;
    }

    public void setZZLFSJ(String ZZLFSJ) {
        this.ZZLFSJ = ZZLFSJ;
    }

    public String getJSPSJ() {
        return JSPSJ;
    }

    public void setJSPSJ(String JSPSJ) {
        this.JSPSJ = JSPSJ;
    }

    public Integer getLXSC() {
        return LXSC;
    }

    public void setLXSC(Integer LXSC) {
        this.LXSC = LXSC;
    }
}
