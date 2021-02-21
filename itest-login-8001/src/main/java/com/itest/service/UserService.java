package com.itest.service;

import com.itest.pojo.User;
import com.itest.utils.MsgUtils;

/**
 * @author ChanV
 * @create 2021-02-21-19:41
 */
public interface UserService {

    MsgUtils userLogin(String user_id, String user_pwd);

    MsgUtils userRegister(User user);
}
