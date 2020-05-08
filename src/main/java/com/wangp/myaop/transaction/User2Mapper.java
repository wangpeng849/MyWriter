package com.wangp.myaop.transaction;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface User2Mapper {
    @Insert("insert into user2 (name) value (#{user2.name})")
    int insert(@Param("user2") User2 record);
}