package com.zhao.rpc.client;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @创建人 zhaohuan
 * @邮箱 1101006260@qq.com
 * @创建时间 2018-06-27 20:16
 * @描述  存放注册的服务
 */
public class ServiceContainer{
    private static  Map<Class,Object> serviceClassMapping = new ConcurrentHashMap();
    public static <T> void  addService(Class<T> clz,T instance){
        serviceClassMapping.put(clz,instance);
    }

    public static <T> T getService(Class<T> clz){
            return  (T)serviceClassMapping.get(clz);
    }
}