package com.fankf.sign.adapter;

import java.util.List;

/**
 * fankunfeng
 * 2020-08-22 12:36
 */
public interface BookService {

    void insertBook(List<Book> books);

    void remove(String name);

    Book selectOne(String name);
}
