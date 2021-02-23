package com.itest.service;

import com.itest.utils.MsgUtils;

/**
 * @author ChanV
 * @create 2021-02-23-14:37
 */
public interface SlideshowService {

    /**
     * 查询轮播图
     * @param curPage
     * @param pageSize
     * @return
     */
    MsgUtils querySlideshow(Integer curPage, Integer pageSize);
}
