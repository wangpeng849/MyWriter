package com.wangp.myaop.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.math.BigInteger;

@Mapper
public interface RobotMapper {
    @Select("select count(*) from robot where type=#{type}")
    int getCount(String type);

    @Select("select count(*) from robot")
    int getAllCount();
}
