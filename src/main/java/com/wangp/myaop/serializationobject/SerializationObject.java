package com.wangp.myaop.serializationobject;

import com.alibaba.fastjson.JSONObject;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;
import lombok.Data;
import org.nustaq.serialization.FSTConfiguration;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Author wangp
 * @Date 2020/1/10
 * @Version 1.0
 */
public class SerializationObject {

    public TargetObject getTargetObject() {
        TargetObject target = new TargetObject();
        target.setName("张三");
        target.setAge(100);
        target.setSex((short) 1);
        target.setStrList(Arrays.asList("aaa", "bbb", "ccc"));
        return target;
    }

    public static byte[] protoStuffSerialize(TargetObject target) {
        Schema<TargetObject> schema = RuntimeSchema.getSchema(TargetObject.class);
        LinkedBuffer buffer = LinkedBuffer.allocate(512);
        //ser  protoStuff[27]
        final byte[] protoStuff = ProtostuffIOUtil.toByteArray(target, schema, buffer);
        buffer.clear();
        //deser    加入反序列后 速度比较慢   但是在序列化的时候是最快又是最小的
        TargetObject targetParse = schema.newMessage();
        ProtostuffIOUtil.mergeFrom(protoStuff, targetParse,schema);
        return protoStuff;
    }

    public static byte[] fastJsonSerialize(TargetObject target) {
        // ser  {bytes[65]}
        String targetStr = JSONObject.toJSON(target).toString();
        byte[] bytes = targetStr.getBytes();
        // deser
        TargetObject targetParse =  JSONObject.parseObject(targetStr,TargetObject.class);
        return bytes;
    }


    public static byte[] fstSerialize(TargetObject target) {
        FSTConfiguration defaultConfiguration = FSTConfiguration.getDefaultConfiguration();
        //ser
        byte[] bytes = defaultConfiguration.asByteArray(target);
        //deser
        TargetObject targetParse = (TargetObject) defaultConfiguration.asObject(bytes);
        return bytes;
    }


    public static void main(String[] args) {
        SerializationObject object = new SerializationObject();
        byte[] bytes = null;
        long start = System.currentTimeMillis();
        for(int i = 0 ; i < 100 ;i ++){
           bytes = protoStuffSerialize(object.getTargetObject());
        }
        long end  = System.currentTimeMillis();
        System.out.println("protoStuff spend time:" + (end-start) + ",序列化byte大小为：" + bytes.length);
        start = System.currentTimeMillis();
        for(int i = 0 ; i < 100 ;i ++){
            bytes = fastJsonSerialize(object.getTargetObject());
        }
        end  = System.currentTimeMillis();
        System.out.println("fastJson spend time:" + (end-start) + ",序列化byte大小为：" + bytes.length);
        start = System.currentTimeMillis();
        for(int i = 0 ; i < 100 ;i ++){
            bytes = fstSerialize(object.getTargetObject());
        }
        end  = System.currentTimeMillis();
        System.out.println("fst spend time:" + (end-start) + ",序列化byte大小为：" + bytes.length);
    }
}

@Data
class TargetObject implements Serializable {
    private String name;
    private Integer age;
    private short sex;
    private List<String> strList;
}
