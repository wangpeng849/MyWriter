package com.wangp.myaop.xml.part1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Author wangp
 * @Date 2020/6/24
 * @Version 1.0
 */

//@XmlRootElement申明Xml的根元素
//@XmlAttribute申明Xml根元素中的属性名
//@XmlAccessorType申明访问的类型是字段
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "d")
@XmlAccessorType(XmlAccessType.FIELD)
public class City {
    @XmlAttribute(name = "d1")
    private String cityId;
    @XmlAttribute(name = "d2")
    private String cityName;
    @XmlAttribute(name = "d3")
    private String cityCode;
    @XmlAttribute(name = "d4")
    private String province;
}
