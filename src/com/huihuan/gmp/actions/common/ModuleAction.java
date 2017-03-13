package com.huihuan.gmp.actions.common;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.actions.base.BaseAction;
import com.huihuan.gmp.json.BaseJson;
import com.huihuan.gmp.services.system.IModuleService;
import com.huihuan.gmp.vo.ModuleVo;

public class ModuleAction extends BaseAction {

	@Resource
	private IModuleService moduleService;
	
	private BaseJson queryJson =new BaseJson();
	
	public BaseJson getQueryJson() {
		return queryJson;
	}

	public void setQueryJson(BaseJson queryJson) {
		this.queryJson = queryJson;
	}
	
	public String getModule(){
		queryJson =new BaseJson();
		String id=getHttpRequest().getParameter("itemId");
		try {
			ModuleVo vo = moduleService.getModuleById(id);
			queryJson.setObj(vo);
		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}
	
	public void getModules(){
		try {
			String selectProjectId=getHttpRequest().getParameter("selectProjectId");
			Map map = moduleService.getModules(selectProjectId);
			getHttpResponse().setCharacterEncoding("UTF-8");
			ObjectMapper mapper = new ObjectMapper();
			String s;
			s = mapper.writeValueAsString(map);
			getHttpResponse().getWriter().write(s);
			getHttpResponse().flushBuffer();
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getModulesForComboTree(){
		try {
			String projectId=getHttpRequest().getParameter("projectId");
			String interfaceId=getHttpRequest().getParameter("interfaceId");
			List list = moduleService.getModulesForCombobox(projectId,interfaceId);
			getHttpResponse().setCharacterEncoding("UTF-8");
			ObjectMapper mapper = new ObjectMapper();
			String s;
			s = mapper.writeValueAsString(list);
			getHttpResponse().getWriter().write(s);
			getHttpResponse().flushBuffer();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String deleteModule(){
		queryJson =new BaseJson();
		try {
			String id=getHttpRequest().getParameter("id");
			int result=moduleService.deleteModule(id);
		} catch (Exception e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}
	
	public String addModule(){
		try {
			String name=getHttpRequest().getParameter("name");
			String parent=getHttpRequest().getParameter("parent");
			ModuleVo vo=moduleService.addModule(name,parent);
			queryJson.setObj(vo);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "jsonResult";
	}
	
	public String editModule(){
		try {
			String id=getHttpRequest().getParameter("id");
			String name=getHttpRequest().getParameter("name");
			int result=moduleService.editModule(id,name);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "jsonResult";
	}
}
