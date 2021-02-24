package com.itest.service;

import com.itest.pojo.Tag;
import com.itest.utils.MsgUtils;

/**
 * @author ChanV
 * @create 2021-02-24-13:33
 */
public interface TagService {
    /**
     * 增加标签
     * @param tag
     * @param token
     * @return
     */
    MsgUtils addTag(Tag tag, String token);

    /**
     * 删除标签
     * @param tag_id
     * @param token
     * @return
     */
    MsgUtils deleteTag(String tag_id, String token);

    /**
     * 更新标签
     * @param tag
     * @param token
     * @return
     */
    MsgUtils updateTag(Tag tag, String token);

    /**
     * 查询标签
     * @param curPage
     * @param pageSize
     * @param token
     * @return
     */
    MsgUtils queryTag(Integer curPage, Integer pageSize, String token);
}
