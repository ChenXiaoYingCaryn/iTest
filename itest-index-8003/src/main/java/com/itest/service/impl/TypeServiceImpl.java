package com.itest.service.impl;

import com.itest.dao.TypeDao;
import com.itest.pojo.Type;
import com.itest.service.TypeService;
import com.itest.utils.MsgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ChanV
 * @create 2021-02-24-15:44
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeDao typeDao;

    @Override
    public MsgUtils queryPhone(Integer curPage, Integer pageSize) {
        try {
            List<Type> types = this.typeDao.queryPhone(curPage, pageSize);
            return MsgUtils.build(200, "手机查询成功", types);
        }catch (Exception e){
            return MsgUtils.build(100, e.getMessage());
        }
    }

    @Override
    public MsgUtils queryPad(Integer curPage, Integer pageSize) {
        try {
            List<Type> types = this.typeDao.queryPad(curPage, pageSize);
            return MsgUtils.build(200, "平板查询成功", types);
        }catch (Exception e){
            return MsgUtils.build(100, e.getMessage());
        }
    }

    @Override
    public MsgUtils queryLaptop(Integer curPage, Integer pageSize) {
        try {
            List<Type> types = this.typeDao.queryLaptop(curPage, pageSize);
            return MsgUtils.build(200, "电脑查询成功", types);
        }catch (Exception e){
            return MsgUtils.build(100, e.getMessage());
        }
    }
}
