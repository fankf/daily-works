package com.fankf.sign.interpreter;

/**
 * @author fankunfeng
 * @datetime 2020-08-04 11:12
 * @package com.fankf.sign.interpreter
 */
public class Plus implements Express{
    @Override
    public int expression(Context context) {
       return context.getN1()+context.getN2();
    }
}
