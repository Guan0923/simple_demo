package com.guan.simpledemo.handler;

import com.guan.simpledemo.pojo.Book;
import com.guan.simpledemo.pojo.ResultEntity;
import com.guan.simpledemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 管威宇
 * @version 1.0
 * @since 2021/4/28 9:04
 */
@RestController
public class BookHandler {

    @Autowired
    private BookService bookService;

    @RequestMapping("/main/book/info.json")
    private ResultEntity<List<Book>> getBooksInfo() {
        return bookService.getBooksInfo();
    }

    @RequestMapping("/save/book/info.json")
    public ResultEntity<String> saveBookInfo(@RequestBody Book book) {
        return bookService.saveBookInfo(book);
    }
}
