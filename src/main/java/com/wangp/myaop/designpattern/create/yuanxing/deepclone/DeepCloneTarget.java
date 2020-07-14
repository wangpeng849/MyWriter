package com.wangp.myaop.designpattern.create.yuanxing.deepclone;

import lombok.Data;

import java.io.Serializable;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/3/4 18:52
 */
@Data
public class DeepCloneTarget implements Serializable,Cloneable {
    private static final long serialVersionUID = 1L;
    private String cloneName;
    private String cloneClass;

    public DeepCloneTarget(String cloneName, String cloneClass) {
        this.cloneName = cloneName;
        this.cloneClass = cloneClass;
    }

    //该类的属性都是string 因此这里使用默认的克隆方法即可
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
