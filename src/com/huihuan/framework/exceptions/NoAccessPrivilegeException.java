/**
 * Copyright (c) 2000-2010 China Foreign Exchange Trade System 
 *                         & National Interbank Funding Center.All Rights Reserved.
 * File name:      NoAccessPrivilegeException.java
 * Date:           2011-9-2
 * Description:    // 用于详细说明此程序文件完成的主要功
 *                 // 能与其他模块或函数的接口，输出值、
 *                 // 取值范围、含义及参数间的关系
 * Modify History:     Date             Programmer       Notes
 *                    ---------        ---------------  ---------
 *                    2011-9-2             何指剑                         Initial
 **********************************************************************
 */
package com.huihuan.framework.exceptions;

/**
 * Created on 2011-9-2
 * <p>Title:       中国外汇交易中心_[子系统统名]_[模块名]/p>
 * <p>Description: [描述该类概要功能介绍]</p>
 * @version        1.0
 */
public class NoAccessPrivilegeException extends Exception{
  public NoAccessPrivilegeException(){
    super("No User Session");
  }
  
  public NoAccessPrivilegeException(String msg){
    super(msg);
  }
}
