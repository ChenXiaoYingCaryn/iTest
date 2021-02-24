package com.itest.service.impl;

import com.itest.dao.TypeDao;
import com.itest.pojo.Type;
import com.itest.service.TypeService;
import com.itest.utils.JWTUtils;
import com.itest.utils.MsgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ChanV
 * @create 2021-02-24-10:18
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeDao typeDao;

    @Override
    public MsgUtils addType(Type type, String token) {
        try {
            JWTUtils.verify(token);
            this.typeDao.addType(type);
            return MsgUtils.build(200, "增加手机型号成功");
        }catch (Exception e){
            return MsgUtils.build(100, e.getMessage());
        }
    }

    @Override
    public MsgUtils deleteType(String type_id, String token) {
        try {
            JWTUtils.verify(token);
            this.typeDao.deleteType(type_id);
            return MsgUtils.build(200, "手机型号删除成功");
        }catch (Exception e){
            return MsgUtils.build(100, e.getMessage());
        }
    }

    @Override
    public MsgUtils updateType(Type type, String token) {
        try {
            JWTUtils.verify(token);
            this.typeDao.updateType(type);
            return MsgUtils.build(200, "手机型号更新成功");
        }catch (Exception e){
            return MsgUtils.build(100, e.getMessage());
        }
    }

    @Override
    public MsgUtils queryType(Integer curPage, Integer pageSize, String token) {
        try {
            JWTUtils.verify(token);
            List<Type> types = this.typeDao.queryType(curPage, pageSize);
            return MsgUtils.build(200, "手机型号查询成功", types);
        }catch (Exception e){
            return MsgUtils.build(100, e.getMessage());
        }
    }
}
