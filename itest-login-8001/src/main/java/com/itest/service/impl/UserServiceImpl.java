package com.itest.service.impl;

import com.itest.dao.UserDao;
import com.itest.pojo.User;
import com.itest.service.UserService;
import com.itest.utils.JSONUtils;
import com.itest.utils.JWTUtils;
import com.itest.utils.MsgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ChanV
 * @create 2021-02-21-19:41
 */
@Service
@Repository
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public MsgUtils userLogin(String user_id, String user_pwd) {
        //根据用户id和密码获取用户信息
        User user = userDao.userLogin(user_id, user_pwd);
        if(user == null){
            return MsgUtils.build(405,"用户名或密码错误");
        }
        //生成token
        Map<String, String> map = new HashMap<String, String>();
        map.put("user_id", user.getUser_id());
        map.put("user_name", user.getUser_name());
        String token = JWTUtils.getToken(map);
        return MsgUtils.build(200,token, JSONUtils.objectToJson(user));
    }

    @Override
    public MsgUtils userRegister(User user) {
        try{
            //调用dao添加用户
            userDao.userRegister(user);
            return MsgUtils.build(200, user.getUser_name()+",您的账号已成功注册");
        }catch(Exception e){
            e.printStackTrace();
            return MsgUtils.build(100,e.getMessage());
        }
    }
}
