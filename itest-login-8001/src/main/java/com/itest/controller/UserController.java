package com.itest.controller;

import com.itest.pojo.User;

import com.itest.service.UserService;
import com.itest.utils.MsgUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ChanV
 * @create 2021-02-21-15:08
 */
@RestController
@RequestMapping("/login")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    @ResponseBody
    public MsgUtils userLogin(@RequestBody User user){
        //登录前初步校验
        if(StringUtils.isBlank(user.getUser_id()) || StringUtils.isBlank(user.getUser_id())) {
            return MsgUtils.build(400, "账号或密码不能为空");
        }
        return userService.userLogin(user.getUser_id(), user.getUser_pwd());
    }

    @RequestMapping(value = "/userRegister", method = RequestMethod.POST)
    @ResponseBody
    public MsgUtils userRegister(@RequestBody User user) {
        return userService.userRegister(user);
    }

}
