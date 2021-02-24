package com.itest.controller;

import com.itest.pojo.Tag;
import com.itest.pojo.Type;
import com.itest.service.TagService;
import com.itest.utils.MsgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ChanV
 * @create 2021-02-24-13:40
 */
@RestController
@RequestMapping("/management/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public MsgUtils addTag(@RequestBody Tag tag, @RequestParam String token){
        return this.tagService.addTag(tag, token);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.PUT)
    public MsgUtils deleteTag(@RequestParam String tag_id, @RequestParam String token){
        return this.tagService.deleteTag(tag_id, token);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public MsgUtils updateTag(@RequestBody Tag tag, @RequestParam String token){
        return this.tagService.updateTag(tag, token);
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public MsgUtils queryTag(@RequestParam Integer curPage, @RequestParam Integer pageSize, @RequestParam String token){
        return this.tagService.queryTag(curPage, pageSize, token);
    }
}
