package com.itest.controller;


import com.itest.service.SlideshowService;
import com.itest.utils.MsgUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author ChanV
 * @create 2021-02-22-11:24
 */
@Api(tags = {"后台管理 -> 轮播图管理"})
@RestController
public class SlideshowController {

    @Autowired
    private SlideshowService slideshowService;

    @ApiOperation("添加轮播图")
    @RequestMapping("/management/slideshow/add")
    public MsgUtils addSlideshow(String image_id, String image_introduction, String token){
        return this.slideshowService.addSlideshow(image_id, image_introduction, token);
    }

    @ApiOperation("删除轮播图")
    @RequestMapping("/management/slideshow/delete")
    public MsgUtils deleteSlideshow(String image_id, String token){
        return this.slideshowService.deleteSlideshow(image_id, token);
    }

    @ApiOperation("更新轮播图")
    @RequestMapping("/management/slideshow/update")
    public MsgUtils updateSlideshow(String image_id, String image_introduction, String token){
        return this.slideshowService.updateSlideshow(image_id, image_introduction, token);
    }

    @ApiOperation("查询轮播图")
    @RequestMapping("/management/slideshow/query")
    public MsgUtils querySlideshow(int curPage, int pageSize, String token){
        return this.slideshowService.querySlideshow(curPage, pageSize, token);
    }

    @ApiOperation("更新轮播图图片")
    @RequestMapping("/management/slideshow/updateImg")
    public MsgUtils updateSlideshowImg(MultipartFile image, String image_id, String token){
        return this.slideshowService.updateSlideshowImg(image, image_id, token);
    }

}
