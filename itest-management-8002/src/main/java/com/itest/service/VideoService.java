package com.itest.service;

import com.itest.pojo.Video;
import com.itest.utils.MsgUtils;

/**
 * @author ChanV
 * @create 2021-02-25-9:45
 */
public interface VideoService {

    /**
     * 增加视频
     * @param video
     * @param token
     * @return
     */
    MsgUtils addVideo(Video video, String token);

    /**
     * 删除视频
     * @param video_id
     * @param token
     * @return
     */
    MsgUtils deleteVideo(String video_id, String token);

    /**
     * 更新视频
     * @param video
     * @param token
     * @return
     */
    MsgUtils updateVideo(Video video, String token);

    /**
     * 查询视频
     * @param curPage
     * @param pageSize
     * @param token
     * @return
     */
    MsgUtils queryVideo(Integer curPage, Integer pageSize, String token);

}
