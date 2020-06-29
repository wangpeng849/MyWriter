package com.wangp.myaop.xml.jaxb;

import com.google.common.collect.Lists;
import com.wangp.myaop.xml.aggregation.JAXBOperator;

import javax.xml.bind.*;
import java.io.*;

/**
 * @Author wangp
 * @Date 2020/6/29
 * @Version 1.0
 */
public class XMLUtils {

    public static String convertToXML(Object object){
        StringWriter sw = new StringWriter();
        try {
            // 利用jdk中自带的转换类实现
            JAXBContext context = JAXBContext.newInstance(object.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
            marshaller.marshal(object,sw);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return sw.toString();
    }

    /**
     * 将对象根据路径转换成xml文件
     *
     * @param obj
     * @param path
     */
    public static String convertToXml(Object obj, String path) {
        FileWriter fw = null;
        try {
            // 利用jdk中自带的转换类实现
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            // 格式化xml输出的格式
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            // 将对象转换成输出流形式的xml
            // 创建输出流
            fw = new FileWriter(path);
            marshaller.marshal(obj, fw);
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
        return fw.toString();
    }


    /**
     * 将String类型的xml转换成对象
     *
     * @param clazz
     * @param xmlStr
     * @return
     */
    public static Object convertXmlStrToObject(Class clazz, String xmlStr) {
        Object xmlObject = null;
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            // 进行将Xml转成对象的核心接口
            Unmarshaller unmarshaller = context.createUnmarshaller();
            StringReader sr = new StringReader(xmlStr);
            xmlObject = unmarshaller.unmarshal(sr);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return xmlObject;
    }

    /**
     * 将file类型的xml转换成对象
     *
     * @param clazz
     * @param xmlPath
     * @return
     */
    public static Object convertXmlFileToObject(Class clazz, String xmlPath) {
        Object xmlObject = null;
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            FileReader fr = null;
            fr = new FileReader(xmlPath);
            xmlObject = unmarshaller.unmarshal(fr);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return xmlObject;
    }

    public static void main(String[] args) {
//        String zhangsan = convertToXML(new Student()
//                .setName(new Student.Name().setFrom("From").setTo("To").setValue("张三"))
//                .setAge(12).setSalary(10));
//        String lisi = convertToXml(new Student().setName("lisi").setAge(12).setSalary(10), "generateXml.xml");
//        System.out.println(zhangsan);
//        System.out.println(lisi);

//        Object o = convertXmlStrToObject(Student.class, zhangsan);
//        System.out.println(o);
//        Object o = convertXmlFileToObject(Student.class, "./generateXml.xml");
//        System.out.println(o);

        String s = convertToXML(new JAXBOperator().setObj(new Student()
                .setName(new Student.Name().setFrom("From").setTo("To").setValue("张三")).setAge(12).setSalary(10))
                .setOperator(new JAXBOperator.Operator().setAdd("open").setSub("close")));
        System.out.println(s);
    }
}
