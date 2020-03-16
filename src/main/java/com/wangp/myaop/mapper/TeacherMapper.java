package com.wangp.myaop.mapper;

import com.wangp.myaop.entity.transcation.Student;
import com.wangp.myaop.entity.transcation.Teacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author wangp
 * @Date 2020/3/13
 * @Version 1.0
 */
@Mapper
public interface TeacherMapper {
    @Insert("insert into teacher (name,age) values (#{teacher.name},#{teacher.age})")
    int insertTea(@Param("teacher") Teacher teacher);
}
