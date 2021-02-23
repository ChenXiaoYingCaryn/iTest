package com.itest.dao;

import com.itest.pojo.Article;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ChanV
 * @create 2021-02-22-12:30
 */
@Repository
@Mapper
public interface ArticleDao {


    /**
     * 添加文章
     * @param article
     */
    @Insert("INSERT INTO tb_article (art_id, art_title, art_text, tag_id, user_id, type_id)" +
            "VALUES (#{article.art_id}, #{article.art_title}, #{article.art_text}, #{article.tag_id}, #{article.user_id}, #{article.type_id})")
    void addArticle(@Param("article") Article article);

    /**
     * 删除文章
     * @param art_id
     */
    @Update("UPDATE tb_article SET is_deleted = 1 WHERE art_id = #{art_id}")
    void deleteArticle(@Param("art_id") String art_id);

    /**
     * 更新文章
     * @param article
     */
    @Update("UPDATE tb_article SET art_title = #{article.art_title}, art_text = #{article.art_text}," +
            " tag_id = #{article.tag_id}, user_id = #{article.user_id}, type_id = #{article.type_id}" +
            "WHERE art_id = #{article.art_id}")
    void updateArticle(@Param("article") Article article);

    /**
     * 查询文章
     * @param curPage
     * @param pageSize
     * @return
     */
    @Select("SELECT * FROM tb_article WHERE is_deleted = '0' LIMIT #{curPage}, #{pageSize}")
    List<Article> queryArticle(@Param("curPage") Integer curPage, @Param("pageSize") Integer pageSize);


    /**
     * 更新文章图片
     * @param art_id
     * @param art_image
     */
    @Update("UPDATE tb_article SET art_image = #{art_image} WHERE art_id = #{art_id}")
    void updateArticleImg(@Param("art_id") String art_id, @Param("art_image") String art_image);
}
