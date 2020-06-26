package com.wangp.myaop.xml.sax;

import com.wangp.myaop.xml.XmlOperation;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * @Author wangp
 * @Date 2020/6/24
 * @Version 1.0
 */
public class SAXOperation extends XmlOperation {


    public SAXOperation(String filePath) {
        super(filePath);
    }

    @Override
    public void readXml() {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = spf.newSAXParser();
            SAXParseHandler handler = new SAXParseHandler();
            saxParser.parse(filePath, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeXml() {

    }
}
