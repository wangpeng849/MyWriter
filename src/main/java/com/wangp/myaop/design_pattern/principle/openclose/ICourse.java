package com.wangp.myaop.design_pattern.principle.openclose;

/**
 * <pre>
 * classname ICource
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/9 15:10
 **/
public interface ICourse {

    Integer getId();

    String getName();

    Double getPrice();

//    Double getDiscountPrice(); 新接口方法，违背开闭原则

}
