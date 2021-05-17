package com.fankf.sign.interpreter;

/**
 * @author fankunfeng
 * @datetime 2020-08-04 11:13
 * @package com.fankf.sign.interpreter
 */
public class Context {

    public Context(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    public int getN1() {
        return n1;
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }

    public int getN2() {
        return n2;
    }

    public void setN2(int n2) {
        this.n2 = n2;
    }

    private int n1;
    private int n2;


}
