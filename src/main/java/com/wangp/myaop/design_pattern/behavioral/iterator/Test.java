package com.wangp.myaop.design_pattern.behavioral.iterator;

/**
 * <pre>
 * classname Test
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/26 22:46
 **/
public class Test {

    public static void main(String[] args) {
        Course course1 = new Course("Java基础");
        Course course2 = new Course("Java进阶");
        Course course3 = new Course("Spring框架");
        Course course4 = new Course("Python精讲");
        Course course5 = new Course("算法课程");
        Course course6 = new Course("前端课程");
        CourseAggregate courseAggregate = new CourseAggregateImpl();
        courseAggregate.addCourse(course1);
        courseAggregate.addCourse(course2);
        courseAggregate.addCourse(course3);
        courseAggregate.addCourse(course4);
        courseAggregate.addCourse(course5);
        courseAggregate.addCourse(course6);
        System.out.println("------课程列表-------");
        printCourse(courseAggregate);

        courseAggregate.removeCourse(course3);
        courseAggregate.removeCourse(course4);
        System.out.println("----删除之后的课程-----");
        printCourse(courseAggregate);
    }

    private static void printCourse(CourseAggregate courseAggregate) {
        CourseIterator courseIterator = courseAggregate.getCourseIterator();
        while (!courseIterator.isLastCourse()) {
            Course course = courseIterator.nextCourse();
            System.out.println(course.getName());
        }
    }
}
