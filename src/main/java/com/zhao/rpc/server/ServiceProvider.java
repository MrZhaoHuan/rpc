package com.zhao.rpc.server;

/**
 * @创建人 zhaohuan
 * @邮箱 1101006260@qq.com
 * @创建时间 2018-06-27 19:57
 * @描述 代理某个服务-socket调用服务端
 */
public class ServiceProvider {
    /*
     *@描述  暴露服务(根据接口名和实现类名称)
     *@创建时间 2018/6/27 20:21
     **/
    public static void exposed(String interfaceName,Object instance) {
        try {
            Class clz = Class.forName(interfaceName);
            //存到容器中
            ServiceContainer.addService(clz,instance);
        } catch (ClassNotFoundException ex) {
            throw new IllegalArgumentException("参数错误:没有接口" + interfaceName);
        }
    }
}