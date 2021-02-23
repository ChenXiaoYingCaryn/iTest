package com.itest.dao;

import com.itest.pojo.Slideshow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ChanV
 * @create 2021-02-23-14:36
 */
@Mapper
@Repository
public interface SlideshowDao {

    /**
     * 查询轮播图
     * @param curPage
     * @param pageSize
     * @return
     */
    @Select("SELECT * FROM tb_slideshow WHERE is_deleted = '0' LIMIT #{curPage}, #{pageSize}")
    List<Slideshow> querySlideshow(@Param("curPage") Integer curPage, @Param("pageSize") Integer pageSize);

}
