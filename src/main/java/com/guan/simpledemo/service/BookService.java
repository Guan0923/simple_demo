package com.guan.simpledemo.service;

import com.guan.simpledemo.pojo.Book;
import com.guan.simpledemo.pojo.ResultEntity;

import java.util.List;

/**
 * @author 管威宇
 * @version 1.0
 * @since 2021/4/28 9:08
 */
public interface BookService {
    /**
     * 查询所有图书的信息然后返回json数据
     *
     * @return 含有json数据的对象
     */
    ResultEntity<List<Book>> getBooksInfo();

    /**
     * 保存图书信息
     * @param book Book
     * @return 含有json的对象
     */
    ResultEntity<String> saveBookInfo(Book book);
}
