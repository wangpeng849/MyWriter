package com.wangp.myaop.xml;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class XmlData {
    private String nodeName;
    private String text;
    private Map<String, String> attributes;
    private List<XmlData> child;
}
