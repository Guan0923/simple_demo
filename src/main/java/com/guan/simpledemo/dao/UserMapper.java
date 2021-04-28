package com.guan.simpledemo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.guan.simpledemo.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 管威宇
 * @version 1.0
 * @since 2021/4/28 8:08
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
