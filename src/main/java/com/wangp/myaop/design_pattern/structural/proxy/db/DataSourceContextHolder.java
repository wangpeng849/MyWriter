package com.wangp.myaop.design_pattern.structural.proxy.db;

/**
 * <pre>
 * classname DataSourceContextHolder
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/24 22:49
 **/
public class DataSourceContextHolder {

    private final static ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();

    public static void setDBType(String type) {
        CONTEXT_HOLDER.set(type);
    }

    public static String getDBType() {
        return CONTEXT_HOLDER.get();
    }

    public static void clearDBType() {
        CONTEXT_HOLDER.remove();
    }
}
