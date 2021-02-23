package com.itest.service.impl;

import com.auth0.jwt.JWT;
import com.itest.dao.ArticleDao;
import com.itest.pojo.Article;
import com.itest.service.ArticleService;
import com.itest.utils.JWTUtils;
import com.itest.utils.MsgUtils;
import com.itest.utils.OSSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author ChanV
 * @create 2021-02-22-12:33
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public MsgUtils addArticle(Article article, String token) {
        try{
            JWTUtils.verify(token);
            this.articleDao.addArticle(article);
            return MsgUtils.build(200, "文章增加成功");
        }catch (Exception e){
            return MsgUtils.build(100, e.getMessage());
        }
    }

    @Override
    public MsgUtils deleteArticle(String art_id, String token) {
        try {
            JWTUtils.verify(token);
            this.articleDao.deleteArticle(art_id);
            return MsgUtils.build(200, "文章删除成功");
        }catch (Exception e){
            return MsgUtils.build(100, e.getMessage());
        }
    }

    @Override
    public MsgUtils updateArticle(Article article, String token) {
        try {
            JWTUtils.verify(token);
            this.articleDao.updateArticle(article);
            return MsgUtils.build(200, "文章更新成功");
        }catch (Exception e){
            return MsgUtils.build(100, e.getMessage());
        }
    }

    @Override
    public MsgUtils queryArticle(Integer curPage, Integer pageSize, String token) {
        try {
            JWTUtils.verify(token);
            List<Article> articles = this.articleDao.queryArticle(curPage, pageSize);
            return MsgUtils.build(200, "文章查询成功", articles);
        }catch (Exception e){
            return MsgUtils.build(100, e.getMessage());
        }
    }

    @Override
    public MsgUtils updateArticleImg(MultipartFile image, String art_id, String token) {
        try {
            JWTUtils.verify(token);
            OSSUtil ossUtil = new OSSUtil();
            String image_url = ossUtil.uploadImgFile(image);
            this.articleDao.updateArticleImg(art_id, image_url);
            return MsgUtils.build(200, "文章图片更新成功");
        }catch (Exception e){
            return MsgUtils.build(100, e.getMessage());
        }
    }
}
