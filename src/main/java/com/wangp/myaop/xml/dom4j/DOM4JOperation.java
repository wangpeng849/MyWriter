package com.wangp.myaop.xml.dom4j;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wangp.myaop.xml.XmlData;
import com.wangp.myaop.xml.XmlOperation;
import jdk.internal.org.xml.sax.SAXException;
import lombok.Data;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.quartz.xml.XMLSchedulingDataProcessor;

import java.io.*;
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

    String format = "";

    public void printElement(Element element) {
        System.out.println(format + "节点：" + element.getName());
        List<Attribute> attributes = element.attributes();
        System.out.println(format + "文本值：" + element.getText().trim());
        System.out.print(format + "属性Key-value：");
        for (Attribute attribute : attributes) {
            System.out.print(attribute.getName() + "-" + attribute.getValue() + "\t");
        }
        System.out.println("");
        System.out.println(format + element.getName() + "的子节点：\n" + format + "[");
        Iterator it = element.elementIterator();
        if (!it.hasNext()) {
            System.out.println(format + "None");
            System.out.println(format + "]");
            if (format.length() > 3) format = format.substring(0, format.length() - 4);
            return;
        }
        while (it.hasNext()) {
            format += "    ";
            printElement((Element) it.next());
        }
        System.out.println(format + "]");
        if (format.length() > 3) format = format.substring(0, format.length() - 4);
    }

    /**
     * 读取XMl数据  写入对象
     *
     * @return
     */
    public  XmlData readXMLData() {
        SAXReader saxReader = new SAXReader();
        XmlData xmlData = null;
        try {
            Document document = saxReader.read(new File(filePath));
            Element rootElement = document.getRootElement();
//            printElement(rootElement);
            xmlData = acquireXmlData(rootElement);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xmlData;
    }

    public   XmlData acquireXmlData(Element root) {
        XmlData xmlData = new XmlData();
        xmlData.setNodeName(root.getName());
        xmlData.setText(root.getText().trim());
        List<Attribute> attributes = root.attributes();
        Map<String, String> att = new HashMap<>();
        for (Attribute attribute : attributes) {
            att.put(attribute.getName(), attribute.getValue());
        }
        xmlData.setAttributes(att);
        List<XmlData> childrenList = new ArrayList();
        List<Element> elements = root.elements();
        for (Element element : elements) {
            childrenList.add(acquireXmlData(element));
        }
        xmlData.setChild(childrenList);
        return xmlData;
    }

    /**
     * 将XML数据 写入文件
     *
     * @param xmlData
     */
    private  void writeXMLData(XmlData xmlData,Element root) {
        if (root == null) return;
        try {
            root.addText(xmlData.getText());
            for (Map.Entry<String, String> entry : xmlData.getAttributes().entrySet()) {
                root.addAttribute(entry.getKey(), entry.getValue());
            }
            List<XmlData> childList = xmlData.getChild();
            for (XmlData data : childList) {
                Element element = root.addElement(data.getNodeName());
                writeXMLData(data,element);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public  void writeXMLData(XmlData xmlData, String fileName) {
        if (fileName == null || fileName.length() == 0) throw new NullPointerException("fileName is empty");
        if (!fileName.endsWith(".xml")) fileName += ".xml";
        //1.创建document
        Document document = DocumentHelper.createDocument();
        writeXMLData(xmlData,document.addElement(xmlData.getNodeName()));
        try {
            // 创建输出流
            Writer out = new PrintWriter(fileName, "utf-8");
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



//    public static void main(String[] args){
//        DOM4JOperation dom4JOperation = new DOM4JOperation("./test.xml");
//        XmlData xmlData = dom4JOperation.readXMLData();
//
//        dom4JOperation.writeXMLData(xmlData,"test_write.xml");
//    }

    public  String jsonToPrettyXml(JSONObject json) throws IOException, SAXException {
        Document document = json2Document(json);

        /* 格式化xml */
        OutputFormat format = OutputFormat.createPrettyPrint();

        // 设置缩进为4个空格
        format.setIndent(" ");
        format.setIndentSize(4);

        StringWriter formatXml = new StringWriter();
        XMLWriter writer = new XMLWriter(formatXml, format);
        writer.write(document);

        return formatXml.toString();
    }
    public Document json2Document(JSONObject json){
        Document document = DocumentHelper.createDocument();
        document.setXMLEncoding("utf-8");
        for (String s : json.keySet()) {
            Element root = jsonToElement(json.getJSONObject(s),s);
            document.add(root);
            break;
        }
        return document;
    }
    public Element jsonToElement(JSONObject json, String nodeName) {
        Element node = DocumentHelper.createElement(nodeName);
        for (String key : json.keySet()) {
            Object child = json.get(key);
            if (child instanceof JSONObject) {
                node.add(jsonToElement(json.getJSONObject(key), key));
            }

            else {
                Element element = DocumentHelper.createElement(key);
                element.setText(json.getString(key));
                node.add(element);
            }
        }
        return node;
    }
}
