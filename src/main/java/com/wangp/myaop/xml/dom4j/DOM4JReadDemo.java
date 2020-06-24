package com.wangp.myaop.xml.dom4j;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 * @Author wangp
 * @Date 2020/6/24
 * @Version 1.0
 */
public class DOM4JReadDemo {

    public static void main(String[] args) {
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(new File("./test.xml"));
            Element rootElement = document.getRootElement();
            Iterator it = rootElement.elementIterator();
            while (it.hasNext()) {
                Element element = (Element) it.next();
                List<Attribute> attributes = element.attributes();
                for (Attribute attribute : attributes) {
                    System.out.println("属性: "+attribute.getName() + " = " + attribute.getValue());
                }
                Iterator cit = element.elementIterator();
                while(cit.hasNext()){
                    Element child = (Element) cit.next();
                    System.out.println("子节点：" + child.getName());
                    List <Attribute>childAttribute = child.attributes();
                    for (Attribute c : childAttribute) {
                        System.out.println("属性: "+c.getName() + " = " + c.getValue());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
