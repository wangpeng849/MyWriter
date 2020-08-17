package com.wangp.myaop.design_pattern.creational.singleton;

public enum EnumInstance {
    /**
     * 实例化
     */
    INSTANCE;

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static EnumInstance getInstance() {
        return INSTANCE;
    }

}
