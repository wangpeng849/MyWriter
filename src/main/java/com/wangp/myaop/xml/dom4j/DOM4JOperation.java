package com.wangp.myaop.xml.dom4j;

import com.wangp.myaop.xml.XmlOperation;
import com.wangp.myaop.xml.part1.XmlOperator;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.*;

/**
 * @Author wangp
 * @Date 2020/6/24
 * @Version 1.0
 */
public class DOM4JOperation extends XmlOperation {

    public DOM4JOperation(String filePath) {
        super(filePath);
    }

    @Override
    public void readXml() {
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(new File(filePath));
            Element rootElement = document.getRootElement();
//            Iterator it = rootElement.elementIterator();
//            while (it.hasNext()) {
//                Element element = (Element) it.next();
//                System.out.println("根节点："+element.getName());
//                List<Attribute> attributes = element.attributes();
//                for (Attribute attribute : attributes) {
//                    System.out.println("属性: " + attribute.getName() + " = " + attribute.getValue());
//                }
//                Iterator cit = element.elementIterator();
//                while (cit.hasNext()) {
//                    Element child = (Element) cit.next();
//                    System.out.println("子节点：" + child.getName());
//                    List<Attribute> childAttribute = child.attributes();
//                    for (Attribute c : childAttribute) {
//                        System.out.println("属性: " + c.getName() + " = " + c.getValue());
//                    }
//                }
//                System.out.println("----------------------");
//            }
            printElement(rootElement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeXml() {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("UNIT_ID", "849183239");
        dataMap.put("UNIT_CODE", "C_06_26");
        dataMap.put("UNIT_NAME", "名称");
        dataMap.put("ADDRESS", "地点");
        try {
            //1.创建document
            Document document = DocumentHelper.createDocument();
            //2.创建根元素
            Element root = document.addElement("root");
            root.addComment("根元素root创建");
            //3.完成添加元素，并返回添加的元素
            Element company = root.addElement("company");
            //设置元素属性
            company.addAttribute("unitId", "unitId");
            company.addAttribute("unitCode", "unitCode");
            company.addAttribute("unitName", "unitName");
            company.addAttribute("address", "address");
            //添加子节点
            company.addElement("unit_id").addText((String) dataMap.get("UNIT_ID"));
            company.addElement("unit_code").addText((String) dataMap.get("UNIT_CODE"));
            company.addElement("unit_name").addText((String) dataMap.get("UNIT_NAME"));
            company.addElement("address").addText((String) dataMap.get("ADDRESS"));

            // 创建输出流
            Writer out = new PrintWriter(filePath, "utf-8");
            //格式化
            OutputFormat format = new OutputFormat("\t", true);
            format.setTrimText(true);

            XMLWriter xmlWriter = new XMLWriter(out, format);
            //把document对象写到out流中
            xmlWriter.write(document);
            out.close();
            xmlWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printElement(Element element){
        System.out.println("节点："+element.getName());
        List<Attribute> attributes = element.attributes();
        System.out.println("文本值："+element.getText().trim());
        System.out.println("属性Key-value：");
        for (Attribute attribute : attributes) {
            System.out.println(attribute.getName() + "-" + attribute.getValue());
        }
        System.out.println(element.getName()+"的子节点：\n[");
        Iterator it = element.elementIterator();
        if(!it.hasNext()) {
            System.out.println("None");
            System.out.println("]");
            return;
        }
        while(it.hasNext()){
            printElement((Element) it.next());
        }
        System.out.println("]");
    }
}
