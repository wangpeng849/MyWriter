package com.wangp.myaop.xml;

import com.wangp.myaop.xml.dom.DOMOperation;
import com.wangp.myaop.xml.dom4j.DOM4JOperation;
import com.wangp.myaop.xml.jdom.JDOMOperation;
import com.wangp.myaop.xml.sax.SAXOperation;

/**
 * @Author wangp
 * @Date 2020/6/26
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        String filePath = "./test.xml";
//        XmlOperation op1 = new DOMOperation(filePath);
        XmlOperation op2 = new DOM4JOperation(filePath);
//        XmlOperation op3 = new SAXOperation(filePath);
//        XmlOperation op4 = new JDOMOperation(filePath);
//        System.out.println("****dom****");
//        op1.readXml();
        System.out.println("\n\n****dom4j****");
        op2.readXml();
//        System.out.println("\n\n****sax****");
//        op3.readXml();
//        System.out.println("\n\n****jdom****");
//        op4.readXml();


//        System.out.println("***dom4j***写入xml");
//        String filePath = "./writeXml.xml";
//        XmlOperation xmlOperation = new DOM4JOperation(filePath);
//        xmlOperation.writeXml();
    }
}
