package com.wangp.myaop.util;

import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author wangp
 * @Date 2020/4/17
 * @Version 1.0
 */
public class UnderLine2Camel<T, R> {

    public R copyProperties(T t, R r) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class sourceClass = t.getClass();
        Class targetClass = r.getClass();

        Field[] sourceFields = sourceClass.getDeclaredFields();
        Field[] targetFields = targetClass.getDeclaredFields();
        for (Field sourceField : sourceFields) {
            sourceField.setAccessible(true);
            String sourceFieldName = sourceField.getName();
            Method sourceGetMethod = sourceClass.getMethod("get" + sourceFieldName.substring(0, 1).toUpperCase() + sourceFieldName.substring(1));
            for (Field targetField : targetFields) {
                if (targetField.getName().equals(D2C(sourceFieldName))) {
                    targetField.setAccessible(true);
                    String targetFieldName = targetField.getName();
                    Method targetSetMethod = targetClass.getMethod("set" + targetFieldName.substring(0, 1).toUpperCase() + targetFieldName.substring(1), targetField.getType());
                    Object invoke = sourceGetMethod.invoke(sourceClass);
                    targetSetMethod.invoke(targetClass,invoke);
                    break;
                }
            }
        }
        return r;
    }

    private String D2C(String sourceFieldName) {
        String res = "";
        String[] s = sourceFieldName.split("_");
        for (int i = 0; i < s.length; i++) {
            if (i == 0) {
                res += s[i];
            } else {
                res += s[i].substring(0, 1).toUpperCase()+s[i].substring(1);
            }
        }
        return res;
    }

    @Data
    static class StudentLine {
        private String stu_name;
        private Integer stu_age;
    }

    @Data
    static class StudentCamel {
        private String stuName;
        private Integer stuAge;
    }

    @Data
    static class Student{
        private String stuName;
        private Integer stuAge;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        UnderLine2Camel<StudentLine, StudentCamel> underLIne2Camel = new UnderLine2Camel<>();
        StudentLine studentLine = new StudentLine();
        studentLine.setStu_age(12);
        studentLine.setStu_name("张三");
        StudentCamel studentCamel = new StudentCamel();
        studentCamel.setStuAge(124);
        studentCamel.setStuName("hello");
//        underLIne2Camel.copyProperties(studentLine,studentCamel);
        Student stu = new Student();
        BeanUtils.copyProperties(studentCamel,stu);
        System.out.println(stu);
    }
}
