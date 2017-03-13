package com.huihuan.gmp.actions.base;

import com.huihuan.gmp.services.common.ICommService;

/**
 * 
 * 文件名稱：CommonBaseAction
 * 描述: 基本操作的Action基类,登录/登出等
 * @author Zhang Xiaofeng
 * @create 2012-4-10
 * 中国外汇交易中心
 */
public class CommonBaseAction extends BaseAction {
	
	protected ICommService commService;
	
	public ICommService getCommService() {
		return commService;
	}

	public void setCommService(ICommService commService) {
		this.commService = commService;
	}
	
}
