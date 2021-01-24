package com.wangp.myaop.controller;

import org.apache.ibatis.annotations.Mapper;
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
}
