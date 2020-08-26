package com.wangp.myaop.xuyu.applicationctx;

import java.util.Map;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * <pre>
 * classname TestHandler
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/26 11:32
 **/
@Component
public class TestHandler implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Map<String, Object> beansWithAnnotation = event.getApplicationContext().getBeansWithAnnotation(Test.class);
        System.out.println(beansWithAnnotation);
    }
}
