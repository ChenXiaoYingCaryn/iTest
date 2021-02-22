package com.itest.service.impl;

import com.auth0.jwt.JWT;
import com.itest.dao.SlideshowDao;
import com.itest.pojo.Slideshow;
import com.itest.service.SlideshowService;
import com.itest.utils.JWTUtils;
import com.itest.utils.MsgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ChanV
 * @create 2021-02-22-10:57
 */
@Service
public class SlideshowServiceImpl implements SlideshowService {

    @Autowired
    private SlideshowDao slideshowDao;


    @Override
    public MsgUtils addSlideshow(String image_id, String image_introduction, String token) {
        try {
            JWTUtils.verify(token);
            this.slideshowDao.addSlideshow(image_id, image_introduction);
            return MsgUtils.build(200, "轮播图添加成功");
        }catch (Exception e){
            return MsgUtils.build(100, e.getMessage());
        }
    }

    @Override
    public MsgUtils deleteSlideshow(String image_id, String token) {
        try {
            JWTUtils.verify(token);
            this.slideshowDao.deleteSlideshow(image_id);
            return MsgUtils.build(200, "轮播图删除成功");
        }catch (Exception e){
            return MsgUtils.build(100, e.getMessage());
        }
    }

    @Override
    public MsgUtils updateSlideshow(String image_id, String image_introduction, String token) {
        try {
            JWTUtils.verify(token);
            this.slideshowDao.updateSlideshowImage(image_id, image_introduction);
            return MsgUtils.build(200, "轮播图更新成功");
        }catch (Exception e){
            return MsgUtils.build(100, e.getMessage());
        }
    }

    @Override
    public MsgUtils querySlideshow(Integer curPage, Integer pageSize, String token) {
        try {
            JWTUtils.verify(token);
            List<Slideshow> slideshows = this.slideshowDao.querySlideshow(curPage, pageSize);
            return MsgUtils.build(200, "轮播图查询成功", slideshows);
        }catch (Exception e){
            return MsgUtils.build(100, e.getMessage());
        }
    }
}
