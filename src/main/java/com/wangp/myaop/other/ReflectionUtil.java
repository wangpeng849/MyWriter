package com.wangp.myaop.other;

import java.lang.reflect.Field;
import org.springframework.util.ReflectionUtils;

/**
 * <pre>
 * classname RfTestUtils
 * description
 * </pre>
 *
 * @author wangpeng
 * @date 2020/11/24 9:26
 **/
public class ReflectionUtil {

    public static Object findValue(Object obj, String name, Class<?> type) throws IllegalAccessException {
        Field field = ReflectionUtils.findField(obj.getClass(), name, type);
        assert field != null;
        field.setAccessible(true);
        return field.get(obj);
    }

    public static Object findValue(Object obj, String name) throws IllegalAccessException {
        return findValue(obj, name, null);
    }

    public static void main(String[] args) throws IllegalAccessException {
        User user = new User("zhangsan", 12, 180);
        String name = (String) ReflectionUtil.findValue(user, "name");
        System.out.println(name);
    }
}
