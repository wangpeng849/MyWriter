package com.wangp.myaop.xuyu.applicationctx;

import java.util.Map;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * <pre>
 * classname TestHandler
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/26 11:32
 * <p>
 * ContextRefreshedEvent 与 ApplicationStartedEvent ？
 **/
@Component
public class TestHandler implements ApplicationListener<ApplicationStartedEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        Map<String, Object> beansWithAnnotation = event.getApplicationContext().getBeansWithAnnotation(Test.class);
        beansWithAnnotation.values()
                .forEach(e -> System.out.println("-------register-------" + e + "-------------------"));
    }
}
