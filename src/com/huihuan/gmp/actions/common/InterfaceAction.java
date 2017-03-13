package com.huihuan.gmp.actions.common;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.codehaus.jackson.map.ObjectMapper;

import com.huihuan.common.util.JsonUtils;
import com.huihuan.common.util.StringUtil;
import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.actions.base.BaseAction;
import com.huihuan.gmp.json.BaseJson;
import com.huihuan.gmp.services.system.IInterfaceService;
import com.huihuan.gmp.services.system.IUserService;
import com.huihuan.gmp.vo.InterfaceVo;

public class InterfaceAction extends BaseAction {

	@Resource
	private IInterfaceService interfaceService;
	
	private BaseJson queryJson =new BaseJson();
	
	public BaseJson getQueryJson() {
		return queryJson;
	}

	public void setQueryJson(BaseJson queryJson) {
		this.queryJson = queryJson;
	}
	
	public String getInterface(){
		queryJson =new BaseJson();
		String id=getHttpRequest().getParameter("itemId");
		try {
			InterfaceVo vo = interfaceService.getInterfaceById(id);
			queryJson.setObj(vo);
		} catch (ServiceException e) {
			// TODO: handle exception
			processException(e, queryJson);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "jsonResult";
	}
	
	public String getInterfaces(){
		queryJson =new BaseJson();
		String projectId=getHttpRequest().getParameter("projectId");
		String moduleIds=getHttpRequest().getParameter("moduleIds");
		String versionId=getHttpRequest().getParameter("versionId");
		String devUserId=getHttpRequest().getParameter("devUserId");
		String queryPage=getHttpRequest().getParameter("queryPage");
		String pageSize=getHttpRequest().getParameter("pageSize");
		try {
			Map map = interfaceService.getInterfaces(projectId, moduleIds,versionId, devUserId,queryPage,pageSize);
			queryJson.setObj(map);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "jsonResult";
	}
	
	public String saveInterface(){
		queryJson =new BaseJson();
		try {
			String itemId=getHttpRequest().getParameter("itemId");
			String versionId=getHttpRequest().getParameter("versionId");
			String module=getHttpRequest().getParameter("module");
			String name=getHttpRequest().getParameter("name");
			String url=getHttpRequest().getParameter("url");
			String params=getHttpRequest().getParameter("params");
			String result=getHttpRequest().getParameter("result");
			String devUser=getHttpRequest().getParameter("devUser");
			String status=getHttpRequest().getParameter("status");
			String rmk=getHttpRequest().getParameter("rmk");
			String rps=getHttpRequest().getParameter("rps");
			String molUrl=getHttpRequest().getParameter("mocUrl");
			InterfaceVo vo=new InterfaceVo();
			vo.setId(itemId);
			vo.setVersionId(versionId);
			vo.setModule(module);
			vo.setName(name);
			vo.setUrl(url);
			vo.setParams(params);
			vo.setResult(result);
			vo.setDevUser(devUser);
			vo.setStatus(status);
			vo.setRmk(rmk);
			vo.setRps(rps);
			vo.setMocUrl(molUrl);
//			System.out.println("itemId"+itemId);
			if(StringUtil.isBlank(itemId)){
				int i=interfaceService.addInterface(vo);
			}else{
				int i=interfaceService.editInterface(vo);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "jsonResult";
	}
	
	public String deleteInterface(){
		queryJson =new BaseJson();
		try {
			String id=getHttpRequest().getParameter("itemId");
			int result=interfaceService.deleteInterface(id);
		} catch (Exception e) {
			// TODO: handle exception
			processException(e, queryJson);
		}
		return "jsonResult";
	}
	
	public String getResultByUrl(){
		try {
			String url=getHttpRequest().getParameter("url");
			String result=interfaceService.getResultByUrl(url);
			getHttpResponse().setContentType("application/json;charset=utf-8");
			getHttpResponse().setCharacterEncoding("UTF-8");
			getHttpResponse().getWriter().write(result);
			//getHttpResponse().getWriter().write("{\"errorMsg\":null,\"obj\":"+result+",\"retcode\":\"0000\"}");
			getHttpResponse().getWriter().flush();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public String getJavaBeanByUrl(){
		try {
			String url=getHttpRequest().getParameter("url");
			String result=interfaceService.getResultByUrl(url);
			getHttpResponse().setContentType("application/json;charset=utf-8");
			getHttpResponse().setCharacterEncoding("UTF-8");
			getHttpResponse().getWriter().write(JsonUtils.parseJson2Java(result));
			//getHttpResponse().getWriter().write("{\"errorMsg\":null,\"obj\":"+result+",\"retcode\":\"0000\"}");
			getHttpResponse().getWriter().flush();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
