package com.guan.simpledemo;

import com.guan.simpledemo.pojo.Book;
import com.guan.simpledemo.pojo.ResultEntity;
import com.guan.simpledemo.pojo.User;
import com.guan.simpledemo.service.BookService;
import com.guan.simpledemo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootTest
class SimpleDemoApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @Test
    void contextLoads() {
        User guan = new User("123456", "guan", "123456");
        System.out.println(userService.loginCheck(guan));
//        System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }

    @Test
    public void test1() {
        ResultEntity<List<Book>> booksInfo = bookService.getBooksInfo();
        System.out.println(booksInfo);
    }

}
