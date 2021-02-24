package com.itest.dao;

import com.itest.pojo.Tag;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ChanV
 * @create 2021-02-24-13:24
 */
@Repository
@Mapper
public interface TagDao {

    /**
     * 增加标签
     * @param tag
     */
    @Insert("INSERT INTO tb_tag (tag_id, tag_name) " +
            "VALUE (#{tag.tag_id}, #{tag.tag_name})")
    void addTag(@Param("tag") Tag tag);

    /**
     * 删除标签
     * @param tag_id
     */
    @Update("UPDATE tb_tag SET is_deleted = 1 WHERE tag_id = #{tag_id}")
    void deleteTag(@Param("tag_id") String tag_id);

    /**
     * 更新标签
     * @param tag
     */
    @Update("UPDATE tb_tag SET tag_name = #{tag.tag_name} WHERE tag_id = #{tag.tag_id}")
    void updateTag(@Param("tag") Tag tag);

    /**
     * 查询标签
     * @param curPage
     * @param pageSize
     */
    @Select("SELECT * FROM tb_tag WHERE is_deleted = '0' LIMIT #{curPage}, #{pageSize}")
    List<Tag> queryTag(@Param("curPage") Integer curPage, @Param("pageSize") Integer pageSize);
}
