package com.huihuan.framework.exceptions;

/**
 * session异常定义类
 * Copyright © 2000-2010 China Foreign Exchange Trade System & National Interbank Funding Center.All Rights Reserved.
 * File name：NoSessionException
 * Date: 2013-6-6
 * Author: Admin
 * Description：
 * Modify History:
 * 2013-6-6 Admin Initial
 */
public class NoSessionException extends Exception {
	
	public NoSessionException() {
		super("No session found,relogin to try.");
	}

	public NoSessionException(String msg) {
		super(msg);
	}
}
