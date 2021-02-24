package com.itest.controller;

import com.itest.service.IndexService;
import com.itest.utils.MsgUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ChanV
 * @create 2021-02-23-14:44
 */
@Api(tags = {"首页相关方法"})
@RestController
public class IndexController {

    @Autowired
    private IndexService indexService;

    @ApiOperation("获取轮播图")
    @RequestMapping("/index/slideshow/query")
    public MsgUtils querySlideshow(int curPage, int pageSize ){
        return this.indexService.querySlideshow(curPage, pageSize);
    }

    @ApiOperation("获取文章")
    @RequestMapping("/index/article/query")
    public MsgUtils queryArticle(int curPage, int pageSize ){
        return this.indexService.queryArticle(curPage, pageSize);
    }

    @ApiOperation("获取手机")
    @RequestMapping("/index/type/phone")
    public MsgUtils queryPhone(int curPage, int pageSize ){
        return this.indexService.queryPhone(curPage, pageSize);
    }

    @ApiOperation("获取平板")
    @RequestMapping("/index/type/pad")
    public MsgUtils queryPad(int curPage, int pageSize ){
        return this.indexService.queryPad(curPage, pageSize);
    }

    @ApiOperation("获取电脑")
    @RequestMapping("/index/type/laptop")
    public MsgUtils queryLaptop(int curPage, int pageSize ){
        return this.indexService.queryLaptop(curPage, pageSize);
    }
}
