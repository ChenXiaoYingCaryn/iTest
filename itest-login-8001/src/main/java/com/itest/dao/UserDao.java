package com.itest.dao;

import com.itest.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author ChanV
 * @create 2021-02-21-14:53
 */
@Mapper
@Repository
public interface UserDao {

    /**
     * 用户登陆
     * @param user_id
     * @param user_pwd
     * @return
     */
    @Select("SELECT * FROM tb_user WHERE user_id = #{user_id} AND user_pwd = #{user_pwd}")
    User userLogin(@Param("user_id") String user_id, @Param("user_pwd") String user_pwd);

    /**
     * 用户注册
     * @param user
     */
    @Insert("INSERT INTO tb_user (user_id,user_pwd,user_name,user_sex,user_email) " +
            " VALUES (#{user.user_id},#{user.user_pwd},#{user.user_name},#{user.user_sex},#{user.user_email})")
    void userRegister(@Param("user") User user);
}
