package com.itest.controller;

import com.itest.pojo.Article;
import com.itest.service.ArticleService;
import com.itest.utils.MsgUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ChanV
 * @create 2021-02-22-12:40
 */
@Api(tags = {"后台管理 -> 文章管理"})
@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @ApiOperation("增加文章")
    @RequestMapping("/management/article/add")
    public MsgUtils addArticle(Article article, String token){
        return this.articleService.addArticle(article, token);
    }

    @ApiOperation("删除文章")
    @RequestMapping("/management/article/delete")
    public MsgUtils deleteArticle(String art_id, String token){
        return this.articleService.deleteArticle(art_id, token);
    }

    @ApiOperation("更新文章")
    @RequestMapping("/management/article/update")
    public MsgUtils updateArticle(Article article, String token){
        return this.articleService.updateArticle(article, token);
    }

    @ApiOperation("查询文章")
    @RequestMapping("/management/article/query")
    public MsgUtils queryArticle(Integer curPage, Integer pageSize, String token){
        return this.articleService.queryArticle(curPage, pageSize, token);
    }
}
