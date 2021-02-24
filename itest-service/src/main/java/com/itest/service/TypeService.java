package com.itest.service;

import com.itest.config.FeignMultipartSupportConfig;
import com.itest.pojo.Article;
import com.itest.pojo.Type;
import com.itest.utils.MsgUtils;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author ChanV
 * @create 2021-02-24-10:29
 */
@Component
@FeignClient(value = "ITEST-MANAGEMENT", configuration = FeignMultipartSupportConfig.class)
public interface TypeService {

    @PostMapping("/management/type/add")
    public MsgUtils addType(@Param(value = "type") Type type, @RequestParam(value = "token")String token);

    @PutMapping("/management/type/delete")
    public MsgUtils deleteType(@RequestParam(value = "type_id") String type_id, @RequestParam(value = "token") String token);

    @PutMapping("/management/type/update")
    public MsgUtils updateType(@Param(value = "type") Type type, @RequestParam(value = "token") String token);

    @GetMapping("/management/type/query")
    public MsgUtils queryType(@RequestParam(value = "curPage") Integer curPage, @RequestParam(value = "pageSize") Integer pageSize, @RequestParam(value = "token") String token);

    @PostMapping(value = "/management/type/updateImg", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public MsgUtils updateTypeImg(@RequestPart("type_image") MultipartFile type_image, @RequestParam(value = "type_id") String type_id, @RequestParam(value = "token") String token);

}
