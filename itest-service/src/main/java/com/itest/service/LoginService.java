package com.itest.service;

import com.itest.config.FeignMultipartSupportConfig;
import com.itest.pojo.User;
import com.itest.utils.MsgUtils;

import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;


/**
 * @author ChanV
 * @create 2021-02-21-20:59
 */
@Component
@FeignClient(value = "ITEST-LOGIN")
public interface LoginService {

    @PostMapping("/login/userLogin")
    public MsgUtils userLogin(@Param("user") User user);

    @PostMapping("/login/userRegister")
    public MsgUtils userRegister(@Param("user") User user);
}
