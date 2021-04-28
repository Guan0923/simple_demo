package com.guan.simpledemo.service;

import com.guan.simpledemo.pojo.ResultEntity;
import com.guan.simpledemo.pojo.User;

/**
 * @author 管威宇
 * @version 1.0
 * @since 2021/4/28 8:11
 */
public interface UserService {
    /**
     * 根据账号密码进行登陆验证
     *
     * @param user User用户信息
     * @return 是否符合
     */
    boolean loginCheck(User user);

    /**
     * 保存用户（注册）
     *
     * @param user 注册信息
     * @return 返回是否成功和详细内容
     */
    ResultEntity<String> saveUserInfo(User user);
}
