package com.huihuan.framework.filter;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.dispatcher.mapper.ActionMapping;
import org.apache.struts2.dispatcher.mapper.DefaultActionMapper;

/**
 * struts漏洞修复，加强对actoin，redirect，redirectAction的过滤
 * Copyright © 2000-2010 China Foreign Exchange Trade System & National Interbank Funding Center.All Rights Reserved.
 * File name：CfetsDefaultActionMapper
 * Date: 2013-7-23
 * Author: zhangxiaofeng
 * Description：解决strtus2的S2-016,S2-017漏洞
 * Modify History:
 * 2013-7-23 zhangxiaofeng Initial
 */
public class CfetsDefaultActionMapper extends DefaultActionMapper {

	@Override
	public void handleSpecialParameters(HttpServletRequest arg0, ActionMapping arg1) {
		Iterator keyIter = arg0.getParameterMap().keySet().iterator();
		while(keyIter.hasNext())
		{
			String key = keyIter.next().toString();
			if(key.contains("action:") || key.contains("redirect:") || key.contains("redirectAction:"))
			{
				System.out.println("Security Alert! someone try to use remote command execution,request ip:"+arg0.getRemoteAddr());
				return;
			}
		}
		super.handleSpecialParameters(arg0, arg1);
	}

}
