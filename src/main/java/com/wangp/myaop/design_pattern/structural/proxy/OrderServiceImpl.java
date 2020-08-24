package com.wangp.myaop.design_pattern.structural.proxy;

/**
 * <pre>
 * classname OrderServiceImpl
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/24 22:42
 **/
public class OrderServiceImpl implements IOrderService {

    private IOrderDao iOrderDao;

    @Override
    public int saveOrder(Order order) {
        iOrderDao = new OrderDaoImpl();
        System.out.println("Service注入Dao存储order");
        return iOrderDao.insert(order);
    }
}
