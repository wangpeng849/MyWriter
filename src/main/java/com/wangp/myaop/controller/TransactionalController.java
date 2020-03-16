package com.wangp.myaop.controller;

import com.wangp.myaop.entity.transcation.Student;
import com.wangp.myaop.entity.transcation.Teacher;
import com.wangp.myaop.mapper.StudentMapper;
import com.wangp.myaop.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.transaction.reactive.TransactionalOperator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author wangp
 * @Date 2020/3/13
 * @Version 1.0
 */
@RestController
public class TransactionalController {

    @Autowired
    StudentMapper studentMapper;
    @Autowired
    TeacherMapper teacherMapper;

    @GetMapping("transactional")
    @Transactional
    public String testTransactional(){
        Student student = new Student();
        student.setName("testS");
        student.setAge(12);
        student.setSex("M");

        Teacher teacher = new Teacher();
        teacher.setAge(22);
        teacher.setName("testT");
        try {
            studentMapper.insertStu(student);
            teacherMapper.insertTea(teacher);
//            int i = 1 / 0;

        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return "error";
        }
        return "ok";
    }

    @GetMapping("sqlstr")
    public String sqlStr(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","test");
        map.put("age",12);
        map.put("sex","M");
        map.put("go","2019-12-12 8:12");
        StringBuffer sqlStr = new StringBuffer();
        StringBuffer sqlValueStr = new StringBuffer();
        Set<String> set = map.keySet();
        for (String s : set) {
            sqlStr.append(s + ",");
            Object o = map.get(s);
            if(o instanceof Integer) {
                sqlValueStr.append(  o + ",");
            }else{
                sqlValueStr.append("\'" + o + "\'" + ",");
            }
        }
        String str1 = sqlStr.toString().substring(0, sqlStr.length() -1);
        String str2 = sqlValueStr.toString().substring(0, sqlValueStr.length() - 1);
        studentMapper.insertSql(str1,str2);
        return "ok";
    }
}
