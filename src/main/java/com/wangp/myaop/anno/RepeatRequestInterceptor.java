package com.wangp.myaop.anno;

import java.time.Duration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * <pre>
 * classname RepeatRequestInterceptor
 * description
 * </pre>
 *
 * @author wangpeng
 * @date 2020/10/20 19:59
 **/
@Component
public class RepeatRequestInterceptor extends HandlerInterceptorAdapter {

    private static final String REPEAT_REQUEST_INTERCEPTION =
            "client_adapter_service:repeat_request:url:%s:mid:%s";

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return super.preHandle(request, response, handler);
        }
        //如果需要拦截
        boolean interception = false;
        long durationTime = 60;
        RepeatRequestInterception repeatRequestInterception =
                ((HandlerMethod) handler).getMethodAnnotation(RepeatRequestInterception.class);
        if (repeatRequestInterception != null) {
            interception = repeatRequestInterception.isInterception();
            durationTime = repeatRequestInterception.durationTime();
        }
        if (!interception) {
            return super.preHandle(request, response, handler);
        }
        StringBuffer requestURL = request.getRequestURL();
        Integer mid = 123;
        String redisKey = String.format(REPEAT_REQUEST_INTERCEPTION, requestURL, mid);
        Object repeatRequest = stringRedisTemplate.opsForValue().get(redisKey);
        if (repeatRequest == null) {
            stringRedisTemplate.opsForValue().set(redisKey, "true", Duration.ofSeconds(durationTime));
            return super.preHandle(request, response, handler);
        } else {
            return false;
        }
    }
}
