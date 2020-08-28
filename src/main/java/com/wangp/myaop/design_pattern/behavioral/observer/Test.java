package com.wangp.myaop.design_pattern.behavioral.observer;

/**
 * <pre>
 * classname Test
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/28 22:18
 **/
public class Test {

    public static void main(String[] args) {
        Course course = new Course("java设计模式");
        Teacher teacher = new Teacher("Farling");
        Teacher teacher2 = new Teacher("Pp");
        course.addObserver(teacher);
        course.addObserver(teacher2);
        //业务逻辑
        Question question = new Question("wp", "如何提供编码能力");
        course.produceQuestion(course, question);
    }
}
