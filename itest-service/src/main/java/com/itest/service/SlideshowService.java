package com.itest.service;

import com.itest.utils.MsgUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ChanV
 * @create 2021-02-22-11:16
 */
@Component
@FeignClient(value = "ITEST-MANAGEMENT")
public interface SlideshowService {

    @PostMapping("/management/slideshow/add")
    public MsgUtils addSlideshow(@RequestParam(value = "image_id") String image_id, @RequestParam(value = "image_introduction") String image_introduction, @RequestParam(value = "token") String token);

    @PutMapping("/management/slideshow/delete")
    public MsgUtils deleteSlideshow(@RequestParam(value = "image_id") String image_id, @RequestParam(value = "token") String token);

    @PutMapping("/management/slideshow/update")
    public MsgUtils updateSlideshow(@RequestParam(value = "image_id") String image_id, @RequestParam(value = "image_introduction") String image_introduction, @RequestParam(value = "token") String token);

    @GetMapping("/management/slideshow/query")
    public MsgUtils querySlideshow(@RequestParam(value = "curPage") Integer curPage, @RequestParam(value = "pageSize") Integer pageSize, @RequestParam("token") String token);


}
