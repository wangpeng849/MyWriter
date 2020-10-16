package com.wangp.myaop.anno;

import java.util.Map;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

@ComponentScan
public class AnnotationUtilsDemo {

    private static void annotationUtilsDemo() {
        //获取类注解
        SingletonComponent singletonComponentAnnotation = AnnotationUtils
                .findAnnotation(SimpleSingletonService.class, SingletonComponent.class);

        System.out.println("@SingletonComponent : " + singletonComponentAnnotation);
        System.out.println(
                "@SingletonComponent value: " + AnnotationUtils.getValue(singletonComponentAnnotation, "value"));
        System.out.println("----------------------------------------------");
        Scope scopeAnnotation = AnnotationUtils.findAnnotation(SimpleSingletonService.class, Scope.class);
        System.out.println("@Scope : " + scopeAnnotation);
        System.out.println("@Scope value: " + AnnotationUtils.getValue(scopeAnnotation, "scopeName"));
        System.out.println("----------------------------------------------");
        //获取@AliasFor Marge 后的注解，直接调用 AnnotationUtils的方法不会组合@AliasFor的值
        Component componentAnnotation = AnnotatedElementUtils
                .findMergedAnnotation(SimpleSingletonService.class, Component.class);
        System.out.println("@Component : " + componentAnnotation);
        System.out.println("@Component value: " + AnnotationUtils.getValue(componentAnnotation, "value"));
    }

    //获取所有Annotation注解的类对象，获取Meta Annotation
    private static void getAllAnnotations() {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
            context.register(AnnotationUtilsDemo.class);
            context.refresh();
            //@SingletonComponent 继承了 @Component 所以存在实例
            Map<String, Object> beans = context.getBeansWithAnnotation(SingletonComponent.class);
            for (Object bean : beans.values()) {
                System.out.println("bean : " + bean);
                Component componentAnnotation = AnnotatedElementUtils
                        .findMergedAnnotation(bean.getClass(), Component.class);
                System.out.println(componentAnnotation);
            }
        }
    }

    public static void main(String[] args) {
        AnnotationUtilsDemo.annotationUtilsDemo();
        System.out.println("----------------------------------------------");
        AnnotationUtilsDemo.getAllAnnotations();
    }
}
