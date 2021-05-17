package com.fankf.sign.iterator;

/**
 * @author fankunfeng
 * @datetime 2020-07-29 16:45
 * @package com.fankf.sign.iterator
 */
public interface Iterator<T> {

    boolean hasNext();

    T next();

    boolean remove(T t);
}
