package com.itest.dao;

import com.itest.pojo.Video;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ChanV
 * @create 2021-02-25-9:35
 */
@Mapper
@Repository
public interface VideoDao {

    /**
     * 添加视频
     * @param video
     */
    @Insert("INSERT INTO tb_video (video_id, video_title, video_introduction, user_id, type_id)" +
            "VALUES (#{video.video_id}, #{video.video_title}, #{video.video_introduction}, #{video.user_id}, #{video.type_id})")
    void addVideo(@Param("video") Video video);

    /**
     * 删除视频
     * @param video_id
     */
    @Update("UPDATE tb_video SET is_deleted = 1 WHERE video_id = #{video_id}")
    void deleteVideo(@Param("video_id") String video_id);

    /**
     * 更新视频
     * @param video
     */
    @Update("UPDATE tb_video SET video_title = #{video.video_title}, video_introduction = #{video.video_introduction}, " +
            "user_id = #{video.user_id}, type_id = #{video.type_id} " +
            "WHERE video_id = #{video.video_id}")
    void updateVideo(@Param("video") Video video);

    /**
     * 查询视频
     * @param curPage
     * @param pageSize
     * @return
     */
    @Select("SELECT * FROM tb_video WHERE is_deleted = '0' LIMIT #{curPage}, #{pageSize}")
    List<Video> queryVideo(@Param("curPage") Integer curPage, @Param("pageSize") Integer pageSize);

    /**
     * 上传视频
     * @param video_id
     * @param video_url
     */
    @Update("UPDATE tb_video SET video_url = #{video_url} WHERE video_id = #{video_id}")
    void uploadVideo(@Param("video_id") String video_id, @Param("video_url") String video_url);
}
