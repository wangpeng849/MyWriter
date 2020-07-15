package com.wangp.myaop.xuyu;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author wangp
 * @Date 2020/7/15
 * @Version 1.0
 */
@Mapper
@Repository
public interface XuyuMapper {
    List<Xuyu> query();

    Integer insertXuyu(@Param("id") Integer id, @Param("company") String company, @Param("workUnit") String workUnit, @Param("controlProject") String controlProject,
                       @Param("xuyu2List") List<Xuyu2> xuyu2List);

    Integer insertXuyu2(@Param("id") Integer id, @Param("xuyu2List") List<Xuyu2> xuyu2List);
}
