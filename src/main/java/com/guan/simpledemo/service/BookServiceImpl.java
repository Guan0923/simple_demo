package com.guan.simpledemo.service;

import com.guan.simpledemo.dao.BookMapper;
import com.guan.simpledemo.pojo.Book;
import com.guan.simpledemo.pojo.MyFunctionSupplier;
import com.guan.simpledemo.pojo.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sun.util.calendar.LocalGregorianCalendar;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;

/**
 * @author 管威宇
 * @version 1.0
 * @since 2021/4/28 9:08
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper mapper;

    @Override
    public ResultEntity<List<Book>> getBooksInfo() {

        MyFunctionSupplier<Integer, String, List<Book>, ResultEntity<List<Book>>> function = ResultEntity::new;
        BiFunction<Integer, String, ResultEntity<List<Book>>> error = ResultEntity::new;

        try {
            List<Book> books = mapper.selectList(null);
            return function.get(200, null, books);
        } catch (Exception e) {
            return error.apply(444, e.getMessage());
        }
    }

    @Override
    public ResultEntity<String> saveBookInfo(Book book) {
        BiFunction<Integer, String, ResultEntity<String>> error = ResultEntity::new;
        if (book == null || StringUtils.isEmpty(book.getBookName()) ||
                StringUtils.isEmpty(book.getAuthor()) || StringUtils.isEmpty(book.getDescription())) {
            return error.apply(444, "请填写完整的信息");
        }
        Supplier<String> dateSupplier = () -> new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        book.setSubmitTime(dateSupplier.get());
        try {
            int insert = mapper.insert(book);

            return error.apply(200, null);
        } catch (Exception e) {
            return error.apply(444, e.getMessage());
        }

    }
}
