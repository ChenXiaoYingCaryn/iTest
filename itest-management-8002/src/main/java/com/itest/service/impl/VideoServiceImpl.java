package com.itest.service.impl;

import com.auth0.jwt.JWT;
import com.itest.dao.VideoDao;
import com.itest.pojo.Video;
import com.itest.service.VideoService;
import com.itest.utils.JWTUtils;
import com.itest.utils.MsgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author ChanV
 * @create 2021-02-25-9:48
 */
@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoDao videoDao;


    @Override
    public MsgUtils addVideo(Video video, String token) {
        try {
            JWTUtils.verify(token);
            this.videoDao.addVideo(video);
            return MsgUtils.build(200, "视频增加成功");
        }catch (Exception e){
            return MsgUtils.build(100, e.getMessage());
        }
    }

    @Override
    public MsgUtils deleteVideo(String video_id, String token) {
        try {
            JWTUtils.verify(token);
            this.videoDao.deleteVideo(video_id);
            return MsgUtils.build(200, "视频删除成功");
        }catch (Exception e){
            return MsgUtils.build(100, e.getMessage());
        }
    }

    @Override
    public MsgUtils updateVideo(Video video, String token) {
        try {
            JWTUtils.verify(token);
            this.videoDao.updateVideo(video);
            return MsgUtils.build(200, "更新视频成功");
        }catch (Exception e){
            return MsgUtils.build(100, e.getMessage());
        }
    }

    @Override
    public MsgUtils queryVideo(Integer curPage, Integer pageSize, String token) {
        try {
            JWTUtils.verify(token);
            List<Video> videos = this.videoDao.queryVideo(curPage, pageSize);
            return MsgUtils.build(200, "查询视频成功", videos);
        }catch (Exception e){
            return MsgUtils.build(100, e.getMessage());
        }
    }
}
