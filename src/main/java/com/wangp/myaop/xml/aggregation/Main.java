package com.wangp.myaop.xml.aggregation;

import com.wangp.myaop.xml.XmlData;
import com.wangp.myaop.xml.XmlOperation;
import com.wangp.myaop.xml.dom4j.DOM4JOperation;

import java.util.Arrays;
import java.util.List;

/**
 * @Author wangp
 * @Date 2020/6/26
 * @Version 1.0
 */
public class Main {

    public void parseXml(String filePath,XMLAggregation aggregation){
        DOM4JOperation operation = new DOM4JOperation(filePath);
        XmlData xmlData = operation.readXMLData();
        List<String> operators = getOperator(xmlData);

    }

    private List<String> getOperator(XmlData xmlData) {
        if(!xmlData.getNodeName().equals("operator")){
            List<XmlData> childList = xmlData.getChild();
            for (XmlData data : childList) {
                getOperator(data);
            }
        }
        String name = xmlData.getAttributes().get("name");
        String field = xmlData.getAttributes().get("field");
        return Arrays.asList(name,field);
    }
}
