package com.zhao.rpc.server;

import com.zhao.rpc.RequestParamEntity;
import com.zhao.rpc.RequestParamValidator;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

public class ServerHandler implements Runnable{
	   private Socket socket;

	   public ServerHandler(Socket socket) {
		   this.socket = socket;
	   }
	   
	   @Override
	   public void run(){
		   ObjectOutputStream serverOut=null;
		   String errorMsg = "";
		try {
			ObjectInputStream serverIn =  new ObjectInputStream(socket.getInputStream());
			serverOut =  new ObjectOutputStream(socket.getOutputStream());
			Object paramObj = serverIn.readObject();
			if(paramObj==null||!(paramObj instanceof RequestParamEntity)){
				errorMsg = "非法请求";
			}else{
				RequestParamEntity paramEntity = (RequestParamEntity)paramObj;
				if(!(RequestParamValidator.validParam(paramEntity))){
					errorMsg = "请检查您的请求参数是否正确";
				}else{
					String method = paramEntity.getMethodName();
					String clazzName = paramEntity.getInterfaceName();
					Object[] methodParamValues = paramEntity.getMethodParamValues();
					Class[] methodParamType = paramEntity.getMethodParamType();
						Class clazz  = null;
						try{
							clazz = Class.forName(clazzName);
						}catch (ClassNotFoundException ex){
							errorMsg = "接口"+clazzName+"不存在";
						}
						if(!clazz.isInterface()){
							errorMsg = "参数错误:"+clazzName+"不是接口";
						}else{
							Object actualService = ServiceContainer.getService(clazz);
							if(null==actualService){
								 errorMsg  = "没有可用的服务:"+clazz;
							}else{
								//todo:子类继承
								Method actualMethod = null;
								actualMethod = actualService.getClass().getDeclaredMethod(method, methodParamType);
								Object result = actualMethod.invoke(actualService, methodParamValues);
								Object result2 = actualMethod.invoke(actualService, methodParamValues);
								Object result3 = actualMethod.invoke(actualService, methodParamValues);
								serverOut.writeObject(result);
							}
						}
				}
			}
		}catch (Exception ex){
				errorMsg = ex.getMessage();
		}finally {
			try {
				if(!errorMsg.equals("")){
					serverOut.writeObject(new IllegalArgumentException(errorMsg));
				}
				socket.close();
			} catch (IOException ioEx) {
				ioEx.printStackTrace();
			}
		}
		   
	   }
}