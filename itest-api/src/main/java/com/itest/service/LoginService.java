package com.itest.service;

import com.itest.config.FeignMultipartSupportConfig;
import com.itest.pojo.User;
import com.itest.utils.MsgUtils;
import feign.Param;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author ChanV
 * @create 2021-02-21-15:17
 */
@Component
@FeignClient(value = "ITEST-LOGIN", configuration = FeignMultipartSupportConfig.class)
public interface LoginService {
    @PostMapping("/login/userLogin")
    public MsgUtils create(@Param("user") User user);

    @PostMapping("/login/userRegister")
    public MsgUtils login(@Param("user") User user);
}
