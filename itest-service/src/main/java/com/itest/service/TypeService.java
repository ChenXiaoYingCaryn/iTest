package com.itest.service;

import com.itest.config.FeignMultipartSupportConfig;
import com.itest.pojo.Article;
import com.itest.pojo.Type;
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
 * @create 2021-02-24-10:29
 */
@Component
@FeignClient(value = "ITEST-MANAGEMENT", configuration = FeignMultipartSupportConfig.class)
public interface TypeService {

    @PostMapping("/management/type/add")
    public MsgUtils addType(@Param(value = "type") Type type, @RequestParam(value = "token")String token);

    @PutMapping("/management/type/delete")
    public MsgUtils deleteType(@RequestParam(value = "type_id") String type_id, @RequestParam(value = "token") String token);

    @PutMapping("/management/type/update")
    public MsgUtils updateType(@Param(value = "type") Type type, @RequestParam(value = "token") String token);

    @GetMapping("/management/type/query")
    public MsgUtils queryType(@RequestParam(value = "curPage") Integer curPage, @RequestParam(value = "pageSize") Integer pageSize, @RequestParam(value = "token") String token);


}
