package com.fankf.sign.state;

/**
 * @author fankunfeng
 * @datetime 2020-08-03 14:49
 * @package com.fankf.sign.state
 */
public class State {

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private String value;

    public void m1(){
        System.out.println(" 状态 m1 ....");
    }
    public void m2(){
        System.out.println(" 状态 m2 ....");
    }
}
