package com.itest.service;

import com.itest.pojo.User;
import com.itest.utils.MsgUtils;

/**
 * @author ChanV
 * @create 2021-02-21-15:03
 */
public interface UserService {

    /**
     * 用户登陆
     * @param user_id
     * @param user_pwd
     * @return
     */
    MsgUtils userLogin(String user_id, String user_pwd);

    /**
     * 用户注册
     * @param user
     * @return
     */
    MsgUtils userRegister(User user);
}
