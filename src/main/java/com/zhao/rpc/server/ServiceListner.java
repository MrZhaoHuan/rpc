package com.zhao.rpc.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @创建人 zhaohuan
 * @邮箱 1101006260@qq.com
 * @创建时间 2018-06-27 21:54
 * @描述
 */
public class ServiceListner {

    /**
     * 监听客户端socket连接
     * @throws IOException
     */
    public static void start(){
        try{
            ServerSocket serverSocket = new ServerSocket(28080);
            // 轮询监听客户端请求
            while (true) {
                Socket socket = serverSocket.accept();
                // 启动1个线程去处理客户端请求
                new Thread(new ServerHandler(socket)).start();
            }
        }catch (Exception ex){
             throw new RuntimeException(ex);
        }
    }
}