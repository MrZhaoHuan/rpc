package com.zhao.rpc;

/**
 * @创建人 zhaohuan
 * @邮箱 1101006260@qq.com
 * @创建时间 2018-06-27 22:40
 * @描述   请求参数校验
 */
public class RequestParamValidator {
    public static boolean validParam(RequestParamEntity entity){
        boolean isOk = true;
        if(!RpcMethod.supportMethodList().contains(entity.getRequestMethod())
             || !entity.getProtocol().equals(RpcProtocol.name)
               || (entity.getInterfaceName()==null||entity.getInterfaceName().trim().equals(""))
                 || ( entity.getMethodName()==null || entity.getMethodName().trim().equals(""))
                )
        {
            isOk =false;
        }
        return  isOk;
    }
}