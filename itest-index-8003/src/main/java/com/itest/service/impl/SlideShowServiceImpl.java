package com.itest.service.impl;

import com.itest.dao.SlideshowDao;
import com.itest.pojo.Slideshow;
import com.itest.service.SlideshowService;
import com.itest.utils.MsgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ChanV
 * @create 2021-02-23-14:39
 */
@Service
@Repository
public class SlideshowServiceImpl implements SlideshowService {

    @Autowired
    private SlideshowDao slideshowDao;


    @Override
    public MsgUtils querySlideshow(Integer curPage, Integer pageSize) {
        try {
            List<Slideshow> slideshows = this.slideshowDao.querySlideshow(curPage, pageSize);
            return MsgUtils.build(200, "查询轮播图成功", slideshows);
        }catch (Exception e){
            return MsgUtils.build(100, e.getMessage());
        }
    }
}
