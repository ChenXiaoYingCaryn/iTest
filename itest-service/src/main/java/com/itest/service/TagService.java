package com.itest.service;

import com.itest.config.FeignMultipartSupportConfig;
import com.itest.pojo.Tag;
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
 * @create 2021-02-24-13:44
 */
@Component
@FeignClient(value = "ITEST-MANAGEMENT", configuration = FeignMultipartSupportConfig.class)
public interface TagService {

    @PostMapping("/management/tag/add")
    public MsgUtils addTag(@Param("tag") Tag tag, @RequestParam("token") String token);

    @PutMapping("/management/tag/delete")
    public MsgUtils deleteTag(@RequestParam("tag_id") String tag_id, @RequestParam("token") String token);

    @PutMapping("/management/tag/update")
    public MsgUtils updateTag(@Param("tag") Tag tag, @RequestParam("token") String token);

    @GetMapping("/management/tag/query")
    public MsgUtils queryTag(@RequestParam(value = "curPage") Integer curPage, @RequestParam(value = "pageSize") Integer pageSize, @RequestParam(value = "token") String token);

}
