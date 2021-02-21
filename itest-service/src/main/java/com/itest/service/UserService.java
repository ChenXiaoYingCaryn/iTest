package com.itest.service;

import com.itest.pojo.User;
import com.itest.utils.MsgUtils;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ChanV
 * @create 2021-02-07-14:21
 */
@Component
@FeignClient(value = "ITEST-MANAGEMENT")
public interface UserService {

    @PostMapping("/management/user/add")
    public MsgUtils addUser(@Param(value = "user") User user, @RequestParam(value = "token") String token);

    @PutMapping("/management/user/delete")
    public MsgUtils deleteUser(@RequestParam(value = "user_id") String user_id, @RequestParam(value = "token") String token);

    @GetMapping("/management/user/query")
    public MsgUtils queryUser(@RequestParam(value = "curPage") Integer curPage, @RequestParam(value = "pageSize") Integer pageSize, @RequestParam("token") String token);

}
