package com.huihuan.gmp.actions.common;

import java.util.List;
import javax.annotation.Resource;
import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.actions.base.BaseAction;
import com.huihuan.gmp.json.BaseJson;
import com.huihuan.gmp.services.system.IUserService;
import com.huihuan.gmp.vo.RoleVo;
import com.huihuan.gmp.vo.UserVo;

public class UserAction extends BaseAction {

	@Resource
	private IUserService userService;
	
	private BaseJson queryJson =new BaseJson();
	
	public BaseJson getQueryJson() {
		return queryJson;
	}

	public void setQueryJson(BaseJson queryJson) {
		this.queryJson = queryJson;
	}
	
	public String getUsers(){
		queryJson =new BaseJson();
		String roleId=getHttpRequest().getParameter("roleId");
		try {
			List list = userService.getUsers(roleId);
			queryJson.setObj(list);
		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}
	
	public String getUser(){
		queryJson =new BaseJson();
		String id=getHttpRequest().getParameter("itemId");
		try {
			UserVo vo = userService.getUser(id);
			queryJson.setObj(vo);
		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}
	
	public String addUser(){
		queryJson =new BaseJson();
		try {
			String username=getHttpRequest().getParameter("username");
			String password=getHttpRequest().getParameter("password");
			String name=getHttpRequest().getParameter("name");
			String roleId=getHttpRequest().getParameter("roleId");
			int i=userService.addUser(username, password, name, roleId);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "jsonResult";
	}
	
	public String deleteUser(){
		queryJson =new BaseJson();
		try {
			String id=getHttpRequest().getParameter("itemId");
			int result=userService.deleteUser(id);
		} catch (Exception e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}
	
	public String editUser(){
		try {
			String id=getHttpRequest().getParameter("itemId");
			String username=getHttpRequest().getParameter("username");
			String password=getHttpRequest().getParameter("password");
			String name=getHttpRequest().getParameter("name");
			String roleId=getHttpRequest().getParameter("roleId");
			int result=userService.editUser(id, username, password, name, roleId);
		} catch (Exception e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}
}
