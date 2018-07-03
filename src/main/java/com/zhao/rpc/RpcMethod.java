package com.zhao.rpc;

import java.util.Arrays;
import java.util.List;

/**
 * @创建人 zhaohuan
 * @邮箱 1101006260@qq.com
 * @创建时间 2018-06-27 22:46
 * @描述
 */
public class   RpcMethod {
    public static final  String GET = "GET";
    public static final  String POST = "POST";

    public static List supportMethodList(){
          return Arrays.asList(GET,POST);
    }
}
