package com.wangp.myaop.xml.sax;

import com.sun.org.apache.xml.internal.resolver.readers.SAXParserHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * @Author wangp
 * @Date 2020/6/24
 * @Version 1.0
 */
public class SAXReadDemo {
    public static void main(String[] args) {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        try{
            SAXParser saxParser = spf.newSAXParser();
            SAXParseHandler handler = new SAXParseHandler();
            saxParser.parse("./test.xml",handler);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
