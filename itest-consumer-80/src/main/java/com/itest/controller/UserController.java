package com.itest.controller;


import com.itest.pojo.User;
import com.itest.service.UserService;
import com.itest.utils.MsgUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ChanV
 * @create 2021-02-07-14:20
 */
@Api(tags = {"后台管理 -> 用户管理"})
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("添加用户")
    @RequestMapping("/management/user/add")
    public MsgUtils addUser(User user, String token){
        return this.userService.addUser(user, token);
    }

    @ApiOperation("删除用户")
    @RequestMapping("/management/user/delete")
    public MsgUtils deleteUser(String user_id, String token){
        return this.userService.deleteUser(user_id, token);
    }


    @ApiOperation("查询用户")
    @RequestMapping("/management/user/query")
    public MsgUtils queryUser(int curPage, int pageSize, String token){
        return this.userService.queryUser(curPage, pageSize, token);
    }
}
