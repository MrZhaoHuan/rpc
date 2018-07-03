package com.zhao.rpc.client;

import com.zhao.rpc.RequestParamEntity;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

/**
 * @创建人 zhaohuan
 * @邮箱 1101006260@qq.com
 * @创建时间 2018-06-27 19:57
 * @描述 代理某个服务-socket调用服务端
 */
public class ServiceProxy {
    /*
     *@描述  注册服务(根据接口名)
     *@创建时间 2018/6/27 20:21
     **/
    public static void register(String interfaceName) {
        try {
            Class clz = Class.forName(interfaceName);
            //注册服务到容器中
            ServiceContainer.addService(clz, generateProxy(clz));
        } catch (ClassNotFoundException ex) {
            throw new IllegalArgumentException("参数错误:没有接口" + interfaceName);
        }
    }

    /*
     *@描述  注册服务(根据接口class对象)
     *@创建时间 2018/6/27 20:21
     **/
    public static void register(Class interfaceClass) {
        if (!interfaceClass.isInterface()) {
            throw new IllegalArgumentException("参数错误:interfaceClass不是接口");
        }
        //注册服务到容器中
        ServiceContainer.addService(interfaceClass, generateProxy(interfaceClass));
    }

    /*
     *@描述  产生代理类(socket请求服务实现类)
     *@创建时间 2018/6/27 20:24
     **/
    private static Object generateProxy(Class service) {
        //接口信息
        Object proxyService = Proxy.newProxyInstance(service.getClassLoader(), new Class[]{service}, new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                try {
                    //ip和端口可以读取配置文件
                    Socket clientSocket = new Socket("127.0.0.1", 28080);
                    ObjectOutputStream clientOut = new ObjectOutputStream(clientSocket.getOutputStream());
                    //发送数据
                    RequestParamEntity entity = new RequestParamEntity();
                    entity.setInterfaceName(service.getName());
                    entity.setMethodName(method.getName());
                    entity.setMethodParamType(method.getParameterTypes());
                    entity.setMethodParamValues(args);
                    clientOut.writeObject(entity);
                    //同步接受结果
                    ObjectInputStream resultIn = new ObjectInputStream(clientSocket.getInputStream());
                    Object readObject = resultIn.readObject();
                    if (readObject instanceof Exception) {
                        throw new RuntimeException(((Exception)readObject).getMessage());
                    }
                    return readObject;
                } catch (Exception ex) {
                    throw new RuntimeException(ex.getMessage());
                }
            }
        });
        return proxyService;
    }

}