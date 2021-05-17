package com.fankf.sign.visitor;

/**
 * @author fankunfeng
 * @datetime 2020-08-03 20:06
 * @package com.fankf.sign.visitor
 */
public class Visitors implements Visit {
    @Override
    public void visit(Subjects subjects) {
        System.out.println(" i am visit ... " + subjects.getValue());
    }
}
