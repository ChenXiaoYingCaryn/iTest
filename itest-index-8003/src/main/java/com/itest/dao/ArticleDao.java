package com.itest.dao;

import com.itest.pojo.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ChanV
 * @create 2021-02-24-14:49
 */
@Mapper
@Repository
public interface ArticleDao {

    /**
     * 查询文章
     * @param curPage
     * @param pageSize
     * @return
     */
    @Select("SELECT * FROM tb_article WHERE is_deleted = '0' LIMIT #{curPage}, #{pageSize}")
    List<Article> queryArticle(@Param("curPage") Integer curPage, @Param("pageSize") Integer pageSize);

}
