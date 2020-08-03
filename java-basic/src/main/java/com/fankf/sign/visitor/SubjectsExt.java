package com.fankf.sign.visitor;

/**
 * @author fankunfeng
 * @datetime 2020-08-03 20:04
 * @package com.fankf.sign.visitor
 */
public class SubjectsExt implements Subjects{

    @Override
    public void accept(Visit visitor) {
        visitor.visit(this);
    }

    @Override
    public String getValue() {
        return "null ...";
    }
}
