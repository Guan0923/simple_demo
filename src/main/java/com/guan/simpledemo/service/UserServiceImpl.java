package com.guan.simpledemo.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.guan.simpledemo.dao.UserMapper;
import com.guan.simpledemo.pojo.ResultEntity;
import com.guan.simpledemo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.function.BiFunction;
import java.util.function.Supplier;

/**
 * @author 管威宇
 * @version 1.0
 * @since 2021/4/28 8:11
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;


    @Override
    public boolean loginCheck(User user) {
        Supplier<BCryptPasswordEncoder> bcryptSupplier = BCryptPasswordEncoder::new;

        LambdaQueryWrapper<User> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(User::getUserName, user.getUserName());
        User user1 = mapper.selectOne(wrapper);

        if (user1 != null) {
            BCryptPasswordEncoder bCryptPasswordEncoder = bcryptSupplier.get();
            return bCryptPasswordEncoder.matches(user.getPassword(), user1.getPassword());
        }

        return false;
    }

    @Override
    public ResultEntity<String> saveUserInfo(User user) {

        BiFunction<Integer, String, ResultEntity<String>> function = ResultEntity::new;

        if (user == null || StringUtils.isEmpty(user.getUserName())
                || StringUtils.isEmpty(user.getPassword())) {
            return function.apply(444, "请不要填写空的信息");
        }

        try {
            int insert = mapper.insert(user);
            if (insert != 0) {
                return function.apply(200, "注册成功");
            }
            return function.apply(444, "注册失败");
        } catch (Exception e) {
            return function.apply(444, e.getMessage());
        }

    }
}
