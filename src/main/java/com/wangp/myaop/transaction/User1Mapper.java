package com.wangp.myaop.transaction;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface User1Mapper {
    @Insert("insert into user1 (name) value (#{user1.name})")
    int insert(@Param("user1") User1 record);
}