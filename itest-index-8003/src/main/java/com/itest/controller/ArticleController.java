package com.itest.controller;

import com.itest.service.ArticleService;
import com.itest.utils.MsgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ChanV
 * @create 2021-02-24-14:53
 */
@RestController
@RequestMapping("/index/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public MsgUtils queryArticle(@RequestParam Integer curPage, @RequestParam Integer pageSize){
        return this.articleService.queryArticle(curPage, pageSize);
    }

}
