package com.wangp.myaop.xml.jdom;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

/**
 * @Author wangp
 * @Date 2020/6/24
 * @Version 1.0
 */
public class JDOMReadDemo {
    public static void main(String[] args) {
        SAXBuilder saxBuilder = new SAXBuilder();
        try {
            FileInputStream in = new FileInputStream(new File("./test.xml"));
            Document document = saxBuilder.build(in);
            Element rootElement = document.getRootElement();
            List<Element> bookList = rootElement.getChildren();
            for (Element element : bookList) {
                System.out.println("第 " + (bookList.indexOf(element)+ 1)  + "本书！");
                List<Attribute> attrs = element.getAttributes();
                for (Attribute attr : attrs) {
                    System.out.println(attr.getName() + " = " + attr.getValue());
                }
                List<Element> children = element.getChildren();
                for (Element child : children) {
                    System.out.println(child.getName() + ":" + child.getValue());
                    List<Attribute> attributes = child.getAttributes();
                    for (Attribute attribute : attributes) {
                        System.out.println(attribute.getName() + "=" + attribute.getValue());
                    }
                }

                System.out.println("----------------------------");
            }
        } catch (Exception e) {

        }
    }
}
