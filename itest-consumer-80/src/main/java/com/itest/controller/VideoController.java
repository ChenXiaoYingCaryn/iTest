package com.itest.controller;

import com.itest.pojo.Article;
import com.itest.pojo.Video;
import com.itest.service.VideoService;
import com.itest.utils.MsgUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ChanV
 * @create 2021-02-25-10:12
 */
@Api(tags = {"后台管理 -> 视频管理"})
@RestController
public class VideoController {

    @Autowired
    private VideoService videoService;

    @ApiOperation("增加视频")
    @RequestMapping("/management/video/add")
    public MsgUtils addVideo(Video video, String token){
        return this.videoService.addVideo(video, token);
    }

    @ApiOperation("删除视频")
    @RequestMapping("/management/video/delete")
    public MsgUtils deleteVideo(String video_id, String token){
        return this.videoService.deleteVideo(video_id, token);
    }

    @ApiOperation("更新视频")
    @RequestMapping("/management/video/update")
    public MsgUtils updateVideo(Video video, String token){
        return this.videoService.updateVideo(video, token);
    }

    @ApiOperation("查询视频")
    @RequestMapping("/management/video/query")
    public MsgUtils queryVideo(Integer curPage, Integer pageSize, String token){
        return this.videoService.queryVideo(curPage, pageSize, token);
    }

}
