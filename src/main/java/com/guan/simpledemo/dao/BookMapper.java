package com.guan.simpledemo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guan.simpledemo.pojo.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 管威宇
 * @version 1.0
 * @since 2021/4/28 9:11
 */
@Mapper
public interface BookMapper extends BaseMapper<Book> {
}
