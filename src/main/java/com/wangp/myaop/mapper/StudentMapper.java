package com.wangp.myaop.mapper;

import com.wangp.myaop.entity.transcation.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author wangp
 * @Date 2020/3/13
 * @Version 1.0
 */
@Mapper
public interface StudentMapper {
    @Insert("insert into student (name,age,sex) values (#{student.name},#{student.age},#{student.sex})")
    int insertStu(@Param("student") Student student);

    @Insert("insert into student (${sqlStr}) values (${sqlValueStr})")
    int insertSql(@Param("sqlStr") String sqlStr,@Param("sqlValueStr") String sqlValueStr);
}
