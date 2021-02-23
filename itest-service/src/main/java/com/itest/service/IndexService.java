package com.itest.service;

import com.itest.config.FeignMultipartSupportConfig;
import com.itest.utils.MsgUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ChanV
 * @create 2021-02-23-14:43
 */
@Component
@FeignClient(value = "ITEST-INDEX", configuration = FeignMultipartSupportConfig.class)
public interface IndexService {

    @GetMapping("/index/slideshow/query")
    public MsgUtils querySlideshow(@RequestParam(value = "curPage") Integer curPage, @RequestParam(value = "pageSize") Integer pageSize);

}
