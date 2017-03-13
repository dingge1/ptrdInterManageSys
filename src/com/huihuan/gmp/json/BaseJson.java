package com.huihuan.gmp.json;

import java.io.Serializable;

/**
 * 
 * Copyright © 2000-2010 China Foreign Exchange Trade System & National Interbank Funding Center.All Rights Reserved.
 * File name：BaseJson
 * Date: 2012-4-25
 * Author: Administrator
 * Description：JSON基础结构，包含响应码和响应消息，反馈给前台页面
 * Modify History:
 */
public class BaseJson implements Serializable,Cloneable {
	
	private String retcode;//响应代码
	private String errorMsg;//错误消息
	
	private Object obj;
	public BaseJson()
	{
		retcode = "0000";
		obj = new Object();
	}
	
	public BaseJson(String retcode){
		this.retcode = retcode;
		obj = new Object();
	}
	
	public String getRetcode() {
		return retcode;
	}
	public void setRetcode(String retcode) {
		this.retcode = retcode;
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

}
