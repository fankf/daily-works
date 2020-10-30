package com.fankf.springmvc;

/**
 * fankunfeng
 * 2020-10-23 16:04
 */

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias(value = "OUTPUT")
public class OUTPUT {
    private String ID;
    private String CODE;
    private String MESS;
    private SPLXXX DATA;

    public String getMESS() {
        return MESS;
    }

    public void setMESS(String MESS) {
        this.MESS = MESS;
    }

    public String getCODE() {
        return CODE;
    }

    public void setCODE(String CODE) {
        this.CODE = CODE;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public SPLXXX getDATA() {
        return DATA;
    }

    public void setDATA(SPLXXX DATA) {
        this.DATA = DATA;
    }
}
