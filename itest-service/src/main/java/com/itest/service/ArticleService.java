package com.itest.service;

import com.itest.config.FeignMultipartSupportConfig;
import com.itest.pojo.Article;
import com.itest.utils.MsgUtils;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ChanV
 * @create 2021-02-22-12:37
 */
@Component
@FeignClient(value = "ITEST-MANAGEMENT", configuration = FeignMultipartSupportConfig.class)
public interface ArticleService {

    @PostMapping("/management/article/add")
    public MsgUtils addArticle(@Param(value = "article") Article article, @RequestParam(value = "token")String token);

    @PutMapping("/management/article/delete")
    public MsgUtils deleteArticle(@RequestParam(value = "art_id") String art_id, @RequestParam(value = "token") String token);

    @PutMapping("/management/article/update")
    public MsgUtils updateArticle(@Param(value = "article") Article article, @RequestParam(value = "token")String token);

    @GetMapping("/management/article/query")
    public MsgUtils queryArticle(@RequestParam(value = "curPage") Integer curPage, @RequestParam(value = "pageSize") Integer pageSize, @RequestParam(value = "token") String token);

}
