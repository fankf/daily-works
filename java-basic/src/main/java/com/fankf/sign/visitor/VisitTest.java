package com.fankf.sign.visitor;

/**
 * @author fankunfeng
 * @datetime 2020-08-03 20:07
 * @package com.fankf.sign.visitor
 */
public class VisitTest {

    public static void main(String[] args) {
        Subjects subjects = new SubjectsExt() ;
        Visit visit = new Visitors();
        visit.visit(subjects);
    }
}
