package com.itest.service;

import com.itest.utils.MsgUtils;

/**
 * @author ChanV
 * @create 2021-02-24-14:50
 */
public interface ArticleService {

    /**
     * 查询文章
     * @param curPage
     * @param pageSize
     * @return
     */
    MsgUtils queryArticle(Integer curPage, Integer pageSize);
}
