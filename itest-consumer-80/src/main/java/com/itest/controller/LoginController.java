package com.itest.controller;

import com.itest.pojo.User;
import com.itest.service.LoginService;
import com.itest.utils.MsgUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ChanV
 * @create 2021-02-21-19:13
 */
@Api(tags = {"登陆注册"})
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @ApiOperation("注册")
    @RequestMapping(value = "/login/userRegister")
    public MsgUtils create(User user){
        return this.loginService.userRegister(user);
    }

    @ApiOperation("登陆")
    @RequestMapping(value = "/login/userLogin")
    public MsgUtils login(User user){
        return this.loginService.userLogin(user);
    }

}
