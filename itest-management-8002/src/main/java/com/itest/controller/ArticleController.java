package com.itest.controller;

import com.itest.pojo.Article;
import com.itest.service.ArticleService;
import com.itest.utils.MsgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author ChanV
 * @create 2021-02-22-12:35
 */
@RestController
@RequestMapping("/management/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public MsgUtils addArticle(@RequestBody Article article, @RequestParam String token){
        return this.articleService.addArticle(article, token);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.PUT)
    public MsgUtils deleteArticle(@RequestParam String art_id, @RequestParam String token){
        return this.articleService.deleteArticle(art_id, token);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public MsgUtils updateArticle(@RequestBody Article article, @RequestParam String token){
        return this.articleService.updateArticle(article, token);
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public MsgUtils queryArticle(@RequestParam Integer curPage, @RequestParam Integer pageSize, @RequestParam String token){
        return this.articleService.queryArticle(curPage, pageSize, token);
    }

    @RequestMapping(value = "/updateImg", method = RequestMethod.POST)
    public MsgUtils updateSlideshowImg(@RequestBody MultipartFile image, @RequestParam String art_id, @RequestParam String token){
        return this.articleService.updateArticleImg(image, art_id, token);
    }
}
