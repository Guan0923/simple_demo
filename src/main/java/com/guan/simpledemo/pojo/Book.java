package com.guan.simpledemo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 管威宇
 * @version 1.0
 * @since 2021/4/28 9:05
 */
@TableName("t_book")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    private String bookName;
    private String submitTime;
    private String author;
    private String description;

    public Book(String bookName, String submitTime, String author, String description) {
        this.bookName = bookName;
        this.submitTime = submitTime;
        this.author = author;
        this.description = description;
    }
}
