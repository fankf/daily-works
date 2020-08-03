package com.fankf.sign.visitor;

/**
 * @author fankunfeng
 * @datetime 2020-08-03 20:01
 * @package com.fankf.sign.visitor
 */
public interface Subjects {

    void accept(Visit visitor);

    String getValue();
}
