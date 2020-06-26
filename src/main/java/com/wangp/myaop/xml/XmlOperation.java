package com.wangp.myaop.xml;

/**
 * @Author wangp
 * @Date 2020/6/26
 * @Version 1.0
 */
public abstract class XmlOperation {
    protected String filePath;

    public XmlOperation(String filePath) {
        this.filePath = filePath;
    }

    public abstract void readXml();

    public abstract void writeXml();
}
