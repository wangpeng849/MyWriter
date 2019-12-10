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
public interface NewTestMapper {
    @Select("select * from testvo")
    List<TestVo> test11();

    @Select("select * from testdo")
    List<TestDo> test12();

    @Select("select * from testpo")
    List<TestPo> test13();

    @Select("select * from testjo")
    List<TestJo> test14();

    @Select("select * from testko")
    List<TestKo> test15();

    @Insert("INSERT INTO `testdo` (`username`, `age`, `desc`) VALUES ('zzz', '2', 'asdasdasd')")
    int insert();
}
