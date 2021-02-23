package com.itest.service;

import com.itest.pojo.Article;
import com.itest.utils.MsgUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author ChanV
 * @create 2021-02-22-12:32
 */
public interface ArticleService {

    /**
     * 增加文章
     * @param article
     * @param token
     * @return
     */
    MsgUtils addArticle(Article article, String token);


    /**
     * 删除文章
     * @param art_id
     * @param token
     * @return
     */
    MsgUtils deleteArticle(String art_id, String token);

    /**
     * 更新文章
     * @param article
     * @param token
     * @return
     */
    MsgUtils updateArticle(Article article, String token);

    /**
     * 查询文章
     * @param curPage
     * @param pageSize
     * @param token
     * @return
     */
    MsgUtils queryArticle(Integer curPage, Integer pageSize, String token);

    /**
     * 更新文章图片
     * @param image
     * @param art_id
     * @param token
     * @return
     */
    MsgUtils updateArticleImg(MultipartFile image, String art_id, String token);


}
