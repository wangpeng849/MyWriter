package com.wangp.myaop.controller;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <pre>
 * classname UserMapper
 * description
 * </pre>
 *
 * @author wangpeng
 * @date 2021/1/14 14:43
 **/
@Mapper
public interface UserMapper {

    @Select("select * from tb_user where id = 1")
    User getUser();

    @Insert("INSERT INTO `tb_user` (`name`, `age`, `sex`, `phone`) VALUES (#{user.name}, #{user.age}, #{user.sex}, #{user.phone})")
    void addUser(@Param("user") User user);
}
