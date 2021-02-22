package com.itest.service;

import com.itest.config.FeignMultipartSupportConfig;
import com.itest.utils.MsgUtils;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author ChanV
 * @create 2021-02-22-11:16
 */
@Component
@FeignClient(value = "ITEST-MANAGEMENT", configuration = FeignMultipartSupportConfig.class)
public interface SlideshowService {

    @PostMapping("/management/slideshow/add")
    public MsgUtils addSlideshow(@RequestParam(value = "image_id") String image_id, @RequestParam(value = "image_introduction") String image_introduction, @RequestParam(value = "token") String token);

    @PutMapping("/management/slideshow/delete")
    public MsgUtils deleteSlideshow(@RequestParam(value = "image_id") String image_id, @RequestParam(value = "token") String token);

    @PutMapping("/management/slideshow/update")
    public MsgUtils updateSlideshow(@RequestParam(value = "image_id") String image_id, @RequestParam(value = "image_introduction") String image_introduction, @RequestParam(value = "token") String token);

    @GetMapping("/management/slideshow/query")
    public MsgUtils querySlideshow(@RequestParam(value = "curPage") Integer curPage, @RequestParam(value = "pageSize") Integer pageSize, @RequestParam("token") String token);

    @PostMapping(value = "/management/slideshow/updateImg", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public MsgUtils updateSlideshowImg(@RequestPart(value = "image") MultipartFile image, @RequestParam("image_id") String image_id, @RequestParam("token") String token);

}
