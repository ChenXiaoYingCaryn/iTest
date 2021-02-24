package com.itest.service;

import com.itest.pojo.Type;
import com.itest.utils.MsgUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author ChanV
 * @create 2021-02-24-10:16
 */
public interface TypeService {

    /**
     * 增加手机型号
     * @param type
     * @return
     */
    MsgUtils addType(Type type, String token);

    /**
     * 删除手机型号
     * @param type_id
     * @return
     */
    MsgUtils deleteType(String type_id, String token);

    /**
     * 更新手机型号
     * @param type
     * @return
     */
    MsgUtils updateType(Type type, String token);

    /**
     * 查询手机型号
     * @param curPage
     * @param pageSize
     * @return
     */
    MsgUtils queryType(Integer curPage, Integer pageSize, String token);

    /**
     * 更新手机型号图片
     * @param type_image
     * @param type_id
     * @return
     */
    MsgUtils updateTypeImg(MultipartFile type_image, String type_id, String token);

}
