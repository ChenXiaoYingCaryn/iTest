package com.itest.dao;

import com.itest.pojo.Type;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ChanV
 * @create 2021-02-24-10:01
 */
@Repository
@Mapper
public interface TypeDao {

    /**
     * 增加手机型号
     * @param type
     */
    @Insert("INSERT INTO tb_type (type_id, type_name, type_price, tag_id)" +
            "VALUES (#{type.type_id}, #{type.type_name}, #{type.type_price}, #{type.tag_id})")
    void addType(@Param("type") Type type);

    /**
     * 删除手机型号
     * @param type_id
     */
    @Update("UPDATE tb_type SET is_deleted = 1 WHERE type_id = #{type_id}")
    void deleteType(@Param("type_id") String type_id);

    /**
     * 更新手机型号
     * @param type
     */
    @Update("UPDATE tb_type SET type_name = #{type.type_name}, type_price = #{type.type_price}, " +
            "tag_id  = #{type.tag_id} WHERE type_id = #{type.type_id}")
    void updateType(@Param("type") Type type);

    /**
     * 查询手机型号
     * @param curPage
     * @param pageSize
     * @return
     */
    @Select("SELECT * FROM tb_type WHERE is_deleted = '0' LIMIT #{curPage}, #{pageSize}")
    List<Type> queryType(@Param("curPage") Integer curPage, @Param("pageSize") Integer pageSize);

}
