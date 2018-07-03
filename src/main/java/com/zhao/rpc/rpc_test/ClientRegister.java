package com.zhao.rpc.rpc_test;

import com.zhao.rpc.client.ServiceContainer;
import com.zhao.rpc.client.ServiceProxy;

/**
 * @创建人 zhaohuan
 * @邮箱 1101006260@qq.com
 * @创建时间 2018-06-27 23:28
 * @描述  客户端注册服务
 */
public class ClientRegister {
    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException {
        //注册服务
        ServiceProxy.register(OrderService.class);
        //使用服务
        OrderService service = ServiceContainer.getService(OrderService.class);
        Order order = service.queryOrder(2);
        System.out.println(order);
    }
}
