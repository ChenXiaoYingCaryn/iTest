package com.itest.dao;

import com.itest.pojo.Type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ChanV
 * @create 2021-02-24-14:44
 */
@Mapper
@Repository
public interface TypeDao {

    /**
     * 查询手机
     * @param curPage
     * @param pageSize
     * @return
     */
    @Select("SELECT * FROM tb_type WHERE type_classify = '0' AND is_deleted = '0' LIMIT #{curPage}, #{pageSize}")
    List<Type> queryPhone(@Param("curPage") Integer curPage, @Param("pageSize") Integer pageSize);

    /**
     * 查询平板
     * @param curPage
     * @param pageSize
     * @return
     */
    @Select("SELECT * FROM tb_type WHERE type_classify = '1' AND is_deleted = '0' LIMIT #{curPage}, #{pageSize}")
    List<Type> queryPad(@Param("curPage") Integer curPage, @Param("pageSize") Integer pageSize);

    /**
     * 查询电脑
     * @param curPage
     * @param pageSize
     * @return
     */
    @Select("SELECT * FROM tb_type WHERE type_classify = '2' AND is_deleted = '0' LIMIT #{curPage}, #{pageSize}")
    List<Type> queryLaptop(@Param("curPage") Integer curPage, @Param("pageSize") Integer pageSize);


}
