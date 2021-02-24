package com.itest.service;

import com.itest.utils.MsgUtils;

/**
 * @author ChanV
 * @create 2021-02-24-15:42
 */
public interface TypeService {

    /**
     * 查询手机
     * @param curPage
     * @param pageSize
     * @return
     */
    MsgUtils queryPhone(Integer curPage, Integer pageSize);

    /**
     * 查询平板
     * @param curPage
     * @param pageSize
     * @return
     */
    MsgUtils queryPad(Integer curPage, Integer pageSize);

    /**
     * 查询电脑
     * @param curPage
     * @param pageSize
     * @return
     */
    MsgUtils queryLaptop(Integer curPage, Integer pageSize);

}
