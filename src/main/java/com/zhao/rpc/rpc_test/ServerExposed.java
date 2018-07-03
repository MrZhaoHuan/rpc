package com.zhao.rpc.rpc_test;

import com.zhao.rpc.server.ServiceListner;
import com.zhao.rpc.server.ServiceProvider;

/**
 * @创建人 zhaohuan
 * @邮箱 1101006260@qq.com
 * @创建时间 2018-06-27 23:28
 * @描述  服务端暴露服务
 */
public class ServerExposed {
    public static void main(String[] args) throws NoSuchMethodException {
        //先反过来测试,因为步骤1会阻塞，步骤2代码没法执行
        //2.暴露服务
        ServiceProvider.exposed(OrderService.class.getName(), new OrderServiceImpl());

        //1.rpc监听开始
        ServiceListner.start();
    }
}
