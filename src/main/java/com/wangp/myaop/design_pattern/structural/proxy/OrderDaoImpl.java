package com.wangp.myaop.design_pattern.structural.proxy;

/**
 * <pre>
 * classname OrderDaoImpl
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/24 22:41
 **/
public class OrderDaoImpl implements IOrderDao {

    @Override
    public int insert(Order o) {
        System.out.println("Dao添加order成功");
        return 1;
    }
}
