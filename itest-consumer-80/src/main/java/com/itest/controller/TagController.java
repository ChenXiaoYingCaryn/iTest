package com.itest.controller;

import com.itest.pojo.Tag;
import com.itest.service.TagService;
import com.itest.utils.MsgUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ChanV
 * @create 2021-02-24-13:51
 */
@Api(tags = {"后台管理 -> 标签管理"})
@RestController
public class TagController {
    @Autowired
    private TagService tagService;

    @ApiOperation("增加标签")
    @RequestMapping("/management/tag/add")
    public MsgUtils addTag(Tag tag, String token){
        return this.tagService.addTag(tag, token);
    }

    @ApiOperation("删除标签")
    @RequestMapping("/management/tag/delete")
    public MsgUtils deleteTag(String tag_id, String token){
        return this.tagService.deleteTag(tag_id, token);
    }

    @ApiOperation("更新标签")
    @RequestMapping("/management/tag/update")
    public MsgUtils updateTag(Tag tag, String token){
        return this.tagService.updateTag(tag, token);
    }

    @ApiOperation("查询标签")
    @RequestMapping("/management/tag/query")
    public MsgUtils queryTag(Integer curPage, Integer pageSize, String token){
        return this.tagService.queryTag(curPage, pageSize, token);
    }
}
