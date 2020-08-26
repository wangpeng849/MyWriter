package com.wangp.myaop.xuyu.methodIntros;

import org.springframework.stereotype.Component;

/**
 * <pre>
 * classname TestExecutor
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/26 14:11
 **/
@Component
public class TestExecutor {

    @TestAnnotation("first")
    public void hello() {
        System.out.println("hello ----- world");
    }

    @TestAnnotation("second")
    public void test() {
        System.out.println("hi ----- goodbye");
    }
}
