package com.wangp.myaop.xuyu.methodIntros;

import java.lang.reflect.Method;
import java.util.Map;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.MethodIntrospector;
import org.springframework.core.MethodIntrospector.MetadataLookup;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.stereotype.Component;

/**
 * <pre>
 * classname TestHandler
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/26 14:08
 **/
@Component
public class MyTestHandler implements ApplicationContextAware, SmartInitializingSingleton {

    private ApplicationContext applicationContext;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterSingletonsInstantiated() {
        String[] beanDefinitionNames = applicationContext.getBeanNamesForType(Object.class, false, true);
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = applicationContext.getBean(beanDefinitionName);

            // referred to ：org.springframework.context.event.EventListenerMethodProcessor.processBean
            Map<Method, TestAnnotation> annotatedMethods = null;
            try {
                annotatedMethods = MethodIntrospector.selectMethods(bean.getClass(),
                        (MetadataLookup<TestAnnotation>) method -> AnnotatedElementUtils
                                .findMergedAnnotation(method, TestAnnotation.class));
            } catch (Throwable ex) {
                ex.printStackTrace();
            }
            if (annotatedMethods == null || annotatedMethods.isEmpty()) {
                continue;
            }
            for (Map.Entry<Method, TestAnnotation> methodMagicAroundEntry : annotatedMethods.entrySet()) {
                Method method = methodMagicAroundEntry.getKey();
                TestAnnotation testAnnotation = methodMagicAroundEntry.getValue();

                if (testAnnotation == null) {
                    continue;
                }
                String name = testAnnotation.value();

                if (name.trim().length() == 0) {
                    throw new RuntimeException(
                            "test name invalide, for[" + bean.getClass() + "#" + method.getName() + "] .");
                }
                method.setAccessible(true);
                try {
                    //执行该方法
                    Object returnValue = method.invoke(bean);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
