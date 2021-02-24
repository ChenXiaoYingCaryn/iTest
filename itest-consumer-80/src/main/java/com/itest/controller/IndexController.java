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
}
