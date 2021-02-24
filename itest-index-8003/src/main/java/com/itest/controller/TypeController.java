package com.itest.controller;

import com.itest.service.TypeService;
import com.itest.utils.MsgUtils;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ChanV
 * @create 2021-02-24-15:46
 */
@RestController
@RequestMapping("/index/type")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @RequestMapping(value = "/phone", method = RequestMethod.GET)
    public MsgUtils queryPhone(@RequestParam Integer curPage, @RequestParam Integer pageSize){
        return this.typeService.queryPhone(curPage, pageSize);
    }

    @RequestMapping(value = "/pad", method = RequestMethod.GET)
    public MsgUtils queryPad(@RequestParam Integer curPage, @RequestParam Integer pageSize){
        return this.typeService.queryPad(curPage, pageSize);
    }

    @RequestMapping(value = "/laptop", method = RequestMethod.GET)
    public MsgUtils queryLaptop(@RequestParam Integer curPage, @RequestParam Integer pageSize){
        return this.typeService.queryLaptop(curPage, pageSize);
    }

}
