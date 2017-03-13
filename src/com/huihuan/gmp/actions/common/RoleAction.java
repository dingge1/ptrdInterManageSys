package com.huihuan.gmp.actions.common;

import java.util.List;
import javax.annotation.Resource;
import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.actions.base.BaseAction;
import com.huihuan.gmp.json.BaseJson;
import com.huihuan.gmp.services.system.IRoleService;
import com.huihuan.gmp.vo.RoleVo;

public class RoleAction extends BaseAction {

	@Resource
	private IRoleService roleService;
	
	private BaseJson queryJson =new BaseJson();
	
	public BaseJson getQueryJson() {
		return queryJson;
	}

	public void setQueryJson(BaseJson queryJson) {
		this.queryJson = queryJson;
	}
	
	public String getRoles(){
		queryJson =new BaseJson();
		try {
			List list = roleService.getRoles();
			queryJson.setObj(list);
		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}
	
	public String addRole(){
		queryJson =new BaseJson();
		try {
			String name=getHttpRequest().getParameter("name");
			String status=getHttpRequest().getParameter("status");
			int result=roleService.addRole(name, Integer.parseInt(status));
		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}
	
	public String deleteRole(){
		queryJson =new BaseJson();
		try {
			String id=getHttpRequest().getParameter("itemId");
			int result=roleService.deleteRole(Long.parseLong(id));
		} catch (Exception e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}
	
	public String editRole(){
		try {
			String id=getHttpRequest().getParameter("itemId");
			String name=getHttpRequest().getParameter("name");
			String status=getHttpRequest().getParameter("status");
			int result=roleService.editRole(Long.parseLong(id), name, Integer.parseInt(status));
		} catch (Exception e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}
	
	public String getRole(){
		try {
			String id=getHttpRequest().getParameter("itemId");
			RoleVo vo=roleService.getRole(id);
			queryJson.setObj(vo);
		} catch (Exception e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}
}
