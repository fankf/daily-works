package com.fankf.sign.visitor;

/**
 *
 * 访问者模式适用于数据结构相对稳定算法又易变化的系统
 * @author fankunfeng
 * @datetime 2020-08-03 19:13
 * @package com.fankf.sign.visitor
 */
public interface Visit {
    void visit(Subjects subjects);
}
