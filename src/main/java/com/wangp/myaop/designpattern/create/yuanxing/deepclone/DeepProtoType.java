package com.wangp.myaop.designpattern.create.yuanxing.deepclone;

import lombok.Data;

import java.io.*;

/**
 * @author farling-wangp
 * @version 1.0
 * @date 2020/3/4 18:55
 */
@Data
public class DeepProtoType implements Serializable,Cloneable {
    public String name;
    public DeepCloneTarget deepCloneTarget;//引用类型

    DeepProtoType(){
        super();
    }

    //深拷贝1 ：克隆方法

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object deep = null;
        //这里完成基本数据类型的数据和string的clone
        deep = super.clone();
        //对引用类型的属性单独处理
        DeepProtoType deepProtoType = (DeepProtoType) deep;
        deepProtoType.deepCloneTarget = (DeepCloneTarget)deepCloneTarget.clone();
        return deepProtoType;
    }


    //深拷贝  方式二
    //通过对象的序列化实现深拷贝  （推荐）
    public Object deepClone(){
        //创建流对象
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;

        try{
            //序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);//把当前对象以

            // 对象流的方式输出
            //反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);

            DeepProtoType copyObj = (DeepProtoType) ois.readObject();

            return copyObj;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
