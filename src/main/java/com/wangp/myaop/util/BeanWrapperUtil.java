package com.wangp.myaop.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import lombok.Data;
import org.springframework.beans.BeanWrapperImpl;

/**
 * <pre>
 * classname BeanWrapperUtil
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/18 9:39
 **/
public class BeanWrapperUtil {

    public static void getProperty() throws InvocationTargetException, IllegalAccessException {
        Student student = new Student();
        student.setName("bbb");
        student.setScore(123);

        BeanWrapperImpl beanWrapper = new BeanWrapperImpl(student);
        PropertyDescriptor name = beanWrapper.getPropertyDescriptor("name");

        Object getName = name.getReadMethod().invoke(student);
        System.out.println(getName);
        name.getWriteMethod().invoke(student, "ccc");
        Object setName = name.getReadMethod().invoke(student);
        System.out.println(setName);

    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        BeanWrapperUtil.getProperty();
    }

}

@Data
class Person {

    private String name = "aaa";
}

@Data
class Student extends Person {

    private Integer score;
}
