package com.itest.service.Impl;

import com.itest.dao.ArticleDao;
import com.itest.pojo.Article;
import com.itest.service.ArticleService;
import com.itest.utils.MsgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ChanV
 * @create 2021-02-24-14:50
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;


    @Override
    public MsgUtils queryArticle(Integer curPage, Integer pageSize) {
        try {
            List<Article> articles = this.articleDao.queryArticle(curPage, pageSize);
            return MsgUtils.build(200, "查询文章成功", articles);
        }catch (Exception e){
            return MsgUtils.build(100, e.getMessage());
        }
    }
}
