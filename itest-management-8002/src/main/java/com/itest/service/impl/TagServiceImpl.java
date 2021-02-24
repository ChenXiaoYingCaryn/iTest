package com.itest.service.impl;

import com.itest.dao.TagDao;
import com.itest.pojo.Tag;
import com.itest.service.TagService;
import com.itest.utils.JWTUtils;
import com.itest.utils.MsgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ChanV
 * @create 2021-02-24-13:35
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDao tagDao;


    @Override
    public MsgUtils addTag(Tag tag, String token) {
        try {
            JWTUtils.verify(token);
            this.tagDao.addTag(tag);
            return MsgUtils.build(200, "标签添加成功");
        }catch (Exception e){
            return MsgUtils.build(100, e.getMessage());
        }
    }

    @Override
    public MsgUtils deleteTag(String tag_id, String token) {
        try {
            JWTUtils.verify(token);
            this.tagDao.deleteTag(tag_id);
            return MsgUtils.build(200, "标签删除成功");
        }catch (Exception e){
            return MsgUtils.build(100, e.getMessage());
        }
    }

    @Override
    public MsgUtils updateTag(Tag tag, String token) {
        try {
            JWTUtils.verify(token);
            this.tagDao.updateTag(tag);
            return MsgUtils.build(200, "标签更新成功");
        }catch (Exception e){
            return MsgUtils.build(100, e.getMessage());
        }
    }

    @Override
    public MsgUtils queryTag(Integer curPage, Integer pageSize, String token) {
        try {
            JWTUtils.verify(token);
            List<Tag> tags = this.tagDao.queryTag(curPage, pageSize);
            return MsgUtils.build(200, "标签查询成功", tags);
        }catch (Exception e){
            return MsgUtils.build(100, e.getMessage());
        }
    }
}
