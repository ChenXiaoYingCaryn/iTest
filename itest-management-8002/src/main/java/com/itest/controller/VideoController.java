package com.itest.controller;

import com.itest.pojo.Article;
import com.itest.pojo.Video;
import com.itest.service.VideoService;
import com.itest.utils.MsgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ChanV
 * @create 2021-02-25-10:02
 */
@RestController
@RequestMapping("/management/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public MsgUtils addVideo(@RequestBody Video video, @RequestParam String token){
        return this.videoService.addVideo(video, token);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.PUT)
    public MsgUtils deleteVideo(@RequestParam String video_id, @RequestParam String token){
       return this.videoService.deleteVideo(video_id, token);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public MsgUtils updateVideo(@RequestBody Video video, @RequestParam String token){
        return this.videoService.updateVideo(video, token);
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public MsgUtils queryVideo(@RequestParam Integer curPage, @RequestParam Integer pageSize, @RequestParam String token){
        return this.videoService.queryVideo(curPage, pageSize, token);
    }

}
