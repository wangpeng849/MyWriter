package com.wangp.myaop.designpattern.create.yuanxing.deepclone;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/3/4 19:00
 */
public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        DeepProtoType type = new DeepProtoType();
        type.setName("AAA");
        DeepCloneTarget target  = new DeepCloneTarget("aaa","aaa's class");
        type.setDeepCloneTarget(target);


        //深拷贝
        DeepProtoType typeClone = (DeepProtoType) type.clone();
        System.out.println(type);
        System.out.println(typeClone);
        System.out.println(type.deepCloneTarget == typeClone.deepCloneTarget);


        DeepProtoType typeClone2 = (DeepProtoType) type.deepClone();
        System.out.println(type);
        System.out.println(typeClone2);
        System.out.println(type.deepCloneTarget == typeClone2.deepCloneTarget);



    }
}
