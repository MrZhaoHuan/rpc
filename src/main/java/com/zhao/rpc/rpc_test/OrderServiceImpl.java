package com.zhao.rpc.rpc_test;

import java.util.Date;

/**
 * @创建人 zhaohuan
 * @邮箱 1101006260@qq.com
 * @创建时间 2018-06-27 23:27
 * @描述  订单服务实现类
 */
public class OrderServiceImpl implements OrderService{
    @Override
    public Order queryOrder(int id) {
        Order order = new Order();
        order.setId(id);
        order.setTime(new Date());
        order.setUserId("user" + id);
        return order;
    }
}