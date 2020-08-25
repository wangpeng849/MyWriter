package com.wangp.myaop.design_pattern.behavioral.templatemethod;

/**
 * <pre>
 * classname PythonCourse
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/25 22:14
 **/
public class PythonCourse extends ACourse {

    @Override
    void packageCourse() {
        System.out.println("提供python代码");
        System.out.println("提供课程图片和素材");
    }
}
