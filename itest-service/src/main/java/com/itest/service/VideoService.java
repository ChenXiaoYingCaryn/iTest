package com.itest.service;

import com.itest.config.FeignMultipartSupportConfig;
import com.itest.pojo.Video;
import com.itest.utils.MsgUtils;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * @author ChanV
 * @create 2021-02-25-10:07
 */
@Component
@FeignClient(value = "ITEST-MANAGEMENT", configuration = FeignMultipartSupportConfig.class)
public interface VideoService {

    @PostMapping("/management/video/add")
    public MsgUtils addVideo(@Param(value = "video") Video video, @RequestParam(value = "token") String token);

    @PutMapping("/management/video/delete")
    public MsgUtils deleteVideo(@RequestParam(value = "video_id") String video_id, @RequestParam(value = "token") String token);

    @PutMapping("/management/video/update")
    public MsgUtils updateVideo(@Param(value = "video") Video video, @RequestParam(value = "token") String token);

    @GetMapping("/management/video/query")
    public MsgUtils queryVideo(@RequestParam(value = "curPage") Integer curPage, @RequestParam(value = "pageSize") Integer pageSize, @RequestParam(value = "token") String token);
}
