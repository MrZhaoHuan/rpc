package com.zhao.rpc;

import java.io.Serializable;

/**
 * @创建人 zhaohuan
 * @邮箱 1101006260@qq.com
 * @创建时间 2018-06-27 22:06
 * @描述
 */
public class RequestParamEntity implements Serializable{
    private static final long serialVersionUID = 1L;
    private String requestMethod="GET";
    private String protocol="RPC";  //请求协议
    private String interfaceName; //接口全路径名
    private String methodName;  //方法名
    private Class[] methodParamType;  //方法参数类型
    private Object[] methodParamValues;  //方法参数值

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class[] getMethodParamType() {
        return methodParamType;
    }

    public void setMethodParamType(Class[] methodParamType) {
        this.methodParamType = methodParamType;
    }

    public Object[] getMethodParamValues() {
        return methodParamValues;
    }

    public void setMethodParamValues(Object[] methodParamValues) {
        this.methodParamValues = methodParamValues;
    }
}
