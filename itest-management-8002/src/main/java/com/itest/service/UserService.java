package com.itest.service;


import com.itest.pojo.User;
import com.itest.utils.MsgUtils;

/**
 * @author ChanV
 * @create 2021-02-07-11:09
 */
public interface UserService {


    /**
     * 增加用户
     *
     * @param user
     * @return
     */
    MsgUtils addUser(User user, String token);

    /**
     * 删除用户
     *
     * @param user_id
     * @return
     */
    MsgUtils deleteUser(String user_id, String token);

    /**
     * 分页查询用户
     *
     * @param curPage
     * @param pageSize
     * @return
     */
    MsgUtils queryUser(Integer curPage, Integer pageSize, String token);
}
