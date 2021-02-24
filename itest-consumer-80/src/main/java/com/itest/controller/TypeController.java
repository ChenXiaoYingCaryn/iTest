package com.itest.controller;

import com.itest.pojo.Article;
import com.itest.pojo.Type;
import com.itest.service.TypeService;
import com.itest.utils.MsgUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author ChanV
 * @create 2021-02-24-10:36
 */
@Api(tags = {"后台管理 -> 产品管理"})
@RestController
public class TypeController {

    @Autowired
    private TypeService typeService;

    @ApiOperation("增加产品")
    @RequestMapping("/management/type/add")
    public MsgUtils addType(Type type, String token){
        return this.typeService.addType(type, token);
    }

    @ApiOperation("删除产品")
    @RequestMapping("/management/type/delete")
    public MsgUtils deleteType(String type_id, String token){
        return this.typeService.deleteType(type_id, token);
    }

    @ApiOperation("更新产品")
    @RequestMapping("/management/type/update")
    public MsgUtils updateType(Type type, String token){
        return this.typeService.updateType(type, token);
    }

    @ApiOperation("查询产品")
    @RequestMapping("/management/type/query")
    public MsgUtils queryType(Integer curPage, Integer pageSize, String token){
        return this.typeService.queryType(curPage, pageSize, token);
    }

    @ApiOperation("更新产品")
    @RequestMapping("/management/type/updateImg")
    public MsgUtils updateTypeImg( MultipartFile type_image, String type_id,String token){
        return this.typeService.updateTypeImg(type_image, type_id, token);
    }
}
