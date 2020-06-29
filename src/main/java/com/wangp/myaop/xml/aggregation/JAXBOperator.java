package com.wangp.myaop.xml.aggregation;

import com.wangp.myaop.xml.jaxb.Student;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * @Author wangp
 * @Date 2020/6/29
 * @Version 1.0
 */
@XmlRootElement(name = "operators")
@Data
@Accessors(chain = true)
@XmlType(propOrder = {
        "operator",
        "obj"
})
@XmlAccessorType(XmlAccessType.FIELD)
public class JAXBOperator {
    private Operator operator;
    private Object obj;

    @Data
    @Accessors(chain = true)
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Operator {
        @XmlAttribute(name = "add")
        private String add;
        @XmlAttribute(name = "sub")
        private String sub;
    }
}
