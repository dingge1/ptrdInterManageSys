package com.huihuan.gmp.actions.common;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.actions.base.BaseAction;
import com.huihuan.gmp.json.BaseJson;
import com.huihuan.gmp.services.system.IVersionService;
import com.huihuan.gmp.services.system.IVersionService;
import com.huihuan.gmp.vo.VersionVo;
import org.apache.commons.beanutils.BeanUtils;

public class VersionAction extends BaseAction {

	@Resource
	private IVersionService versionService;
	
	private BaseJson queryJson =new BaseJson();
	
	public BaseJson getQueryJson() {
		return queryJson;
	}

	public void setQueryJson(BaseJson queryJson) {
		this.queryJson = queryJson;
	}
	
	public String getVersion(){
		queryJson =new BaseJson();
		try {
			String id=getHttpRequest().getParameter("itemId");
			VersionVo vo=versionService.getVersion(id);
			queryJson.setObj(vo);
		} catch (Exception e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}
	
	public String getVersions(){
		queryJson =new BaseJson();
		try {
			String projectId=getHttpRequest().getParameter("projectId");
			List list = versionService.getVersions(projectId);
			queryJson.setObj(list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
		return "jsonResult";
	}
	
	public String getVersionsForSelect(){
		queryJson =new BaseJson();
		try {
			String projectId=getHttpRequest().getParameter("projectId");
			List list = versionService.getVersionsForSelect(projectId);
			queryJson.setObj(list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
		return "jsonResult";
	}
	
	public String addVersion(){
		queryJson =new BaseJson();
		try {

			String name=getHttpRequest().getParameter("name");
			String code=getHttpRequest().getParameter("code");
			String status=getHttpRequest().getParameter("status");
			String project=getHttpRequest().getParameter("projectId");
			VersionVo vo=new VersionVo();
			vo.setCode(code);
			vo.setName(name);
			vo.setStatus(status);
			vo.setProject(project);
			int result=versionService.addVersion(vo);
		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}
	
	public String deleteVersion(){
		queryJson =new BaseJson();
		try {
			String id=getHttpRequest().getParameter("itemId");
			int result=versionService.deleteVersion(id);
		} catch (Exception e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}
	
	public String editVersion(){
		try {
			String id=getHttpRequest().getParameter("itemId");
			String name=getHttpRequest().getParameter("name");
			String code=getHttpRequest().getParameter("code");
			String status=getHttpRequest().getParameter("status");
			VersionVo vo=new VersionVo();
			vo.setCode(code);
			vo.setId(id);
			vo.setName(name);
			vo.setStatus(status);
			int result=versionService.editVersion(vo);
		} catch (Exception e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}
}
