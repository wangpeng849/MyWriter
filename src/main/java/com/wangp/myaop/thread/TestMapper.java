package com.wangp.myaop.thread;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author farling
 * @Date 2019/12/10
 */
@Mapper
public interface TestMapper {
    @Select("select * from testvo")
    List<TestVo> test11();

    @Select("select * from testdo")
    List<TestDo> test12();

    @Insert("INSERT INTO `testdo` (`username`, `age`, `desc`) VALUES ('zzz', '2', 'asdasdasd')")
    int insert();
}
