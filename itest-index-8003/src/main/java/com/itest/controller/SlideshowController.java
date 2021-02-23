package com.itest.controller;

import com.itest.service.SlideshowService;
import com.itest.utils.MsgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ChanV
 * @create 2021-02-23-14:41
 */

@RestController
@RequestMapping("/index/slideshow")
public class SlideshowController {

    @Autowired
    private SlideshowService slideshowService;

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public MsgUtils querySlideshow(@RequestParam Integer curPage, @RequestParam Integer pageSize){
        return this.slideshowService.querySlideshow(curPage, pageSize);
    }
}
