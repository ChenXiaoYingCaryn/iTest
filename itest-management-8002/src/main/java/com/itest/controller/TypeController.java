package com.itest.controller;

import com.itest.pojo.Type;
import com.itest.service.TypeService;
import com.itest.utils.MsgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ChanV
 * @create 2021-02-24-10:24
 */
@RestController
@RequestMapping("/management/type")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public MsgUtils addType(@RequestBody Type type, @RequestParam String token){
        return this.typeService.addType(type, token);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.PUT)
    public MsgUtils deleteType(@RequestParam String type_id, @RequestParam String token){
        return this.typeService.deleteType(type_id, token);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public MsgUtils updateType(@RequestBody Type type, @RequestParam String token){
        return this.typeService.updateType(type, token);
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public MsgUtils queryType(@RequestParam Integer curPage, @RequestParam Integer pageSize, @RequestParam String token){
        return this.typeService.queryType(curPage, pageSize, token);
    }

}
