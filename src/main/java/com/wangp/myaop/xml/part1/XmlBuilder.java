package com.wangp.myaop.xml.part1;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;

/**
 * @Author wangp
 * @Date 2020/6/24
 * @Version 1.0
 */
public class XmlBuilder {
    public static Object xmlStr2Object(Class<?> clazz, String xmlStr) throws Exception {
        //利用JAXBContext将类转为一个实例
        JAXBContext context = JAXBContext.newInstance(clazz);
        //xml 转为对象的接口
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Reader reader = new StringReader(xmlStr);
        Object xmlObject = unmarshaller.unmarshal(reader);
        reader.close();
        return xmlObject;
    }
}
