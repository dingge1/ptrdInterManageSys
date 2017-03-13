package com.huihuan.gmp.actions.common;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.actions.base.BaseAction;
import com.huihuan.gmp.entity.Project;
import com.huihuan.gmp.json.BaseJson;
import com.huihuan.gmp.services.system.IModuleService;
import com.huihuan.gmp.services.system.IProjectService;
import com.huihuan.gmp.vo.ProjectVo;

import org.apache.commons.beanutils.BeanUtils;

public class ProjectAction extends BaseAction {

	@Resource
	private IProjectService projectService;
	
	private BaseJson queryJson =new BaseJson();
	
	public BaseJson getQueryJson() {
		return queryJson;
	}

	public void setQueryJson(BaseJson queryJson) {
		this.queryJson = queryJson;
	}
	
	public String getProject(){
		queryJson =new BaseJson();
		try {
			String id=getHttpRequest().getParameter("itemId");
			ProjectVo vo=projectService.getProject(id);
			queryJson.setObj(vo);
		} catch (Exception e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}
	
	public String getProjects(){
		queryJson =new BaseJson();
		try {
			List<Project> list = projectService.getProjects();
			List results=new ArrayList();
			for(Project p:list){
				ProjectVo vo=new ProjectVo();
				BeanUtils.copyProperties(vo, p);
				results.add(vo);
			}
			queryJson.setObj(results);
		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "jsonResult";
	}
	
	public String addProject(){
		queryJson =new BaseJson();
		try {
			String name=getHttpRequest().getParameter("name");
			String url=getHttpRequest().getParameter("url");
			String status=getHttpRequest().getParameter("status");
			int result=projectService.addProject(name, url, Integer.parseInt(status));
		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}
	
	public String deleteProject(){
		queryJson =new BaseJson();
		try {
			String id=getHttpRequest().getParameter("itemId");
			int result=projectService.deleteProject(Long.parseLong(id));
		} catch (Exception e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}
	
	public String editProject(){
		try {
			String id=getHttpRequest().getParameter("itemId");
			String name=getHttpRequest().getParameter("name");
			String url=getHttpRequest().getParameter("url");
			String status=getHttpRequest().getParameter("status");
			int result=projectService.editProject(Long.parseLong(id), name, url, Integer.parseInt(status));
		} catch (Exception e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}
}
