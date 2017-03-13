package com.huihuan.gmp.services.system.impl;
import java.io.IOException;
import java.security.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;

import com.huihuan.common.util.DateUtil;
import com.huihuan.common.util.StringUtil;
import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.entity.Interfaces;
import com.huihuan.gmp.entity.InterfaceModules;
import com.huihuan.gmp.entity.Module;
import com.huihuan.gmp.entity.Page;
import com.huihuan.gmp.entity.Project;
import com.huihuan.gmp.entity.User;
import com.huihuan.gmp.entity.Users;
import com.huihuan.gmp.entity.Versions;
import com.huihuan.gmp.services.common.impl.CommServiceImpl;
import com.huihuan.gmp.services.system.IInterfaceService;
import com.huihuan.gmp.services.system.IProjectService;
import com.huihuan.gmp.vo.InterfaceVo;

@Service(value="interfaceService")
public class InterfaceServiceImpl extends CommServiceImpl implements IInterfaceService {

	private Log log = LogFactory.getLog(InterfaceServiceImpl.class);

	@Override
	public InterfaceVo getInterfaceById(String id) throws ServiceException {
		// TODO Auto-generated method stub
		InterfaceVo vo=null;
		Interfaces inter=baseDAO.findById(Long.parseLong(id), Interfaces.class);
		if(inter!=null){
			vo=new InterfaceVo();
			vo.setId(inter.getId()+"");
			vo.setName(inter.getName());
			vo.setParams(inter.getParams());
			vo.setResult(inter.getResult());
			vo.setStatus(inter.getStatus()+"");
			vo.setUrl(inter.getUrl());
			vo.setMocUrl(inter.getUrl());
			vo.setRmk(inter.getRmk());
			vo.setDevUser(inter.getUsers().getId()+"");
			vo.setVersionId(inter.getVersions().getId()+"");
			vo.setProject(inter.getVersions().getProject().getName());
			vo.setRps(inter.getRps());
		}
		return vo;
	}

	@Override
	public Map getInterfaces(String projectId, String moduleIds,String versionId, String devUserId,String queryPage,String size)
			throws ServiceException {
		// TODO Auto-generated method stub
		Map map=new HashMap();
		int totalSize=0;
		int offset=-1;
		int pageSize=1;
		if(!StringUtil.isEmpty(size)){
			pageSize=Integer.parseInt(size);
		}
		if(!StringUtil.isEmpty(queryPage)){
			offset=(Integer.parseInt(queryPage)-1)*pageSize;
		}
		List<Interfaces> list=null;
		List params=new ArrayList();
		String sql="select " +
				"interfaces.id as id," +
				"(select GROUP_CONCAT(module.name) from module where module.id in " +
				"(select interface_modules.MODULE_ID from interface_modules where interface_modules.INTERFACE_ID =interfaces.ID)" +
				") as module," +
				"versions.id as versionId," +
				"versions.CODE as versionCode," +
				"interfaces.name as name," +
				"project.url as projectUrl," +
				"interfaces.URL as url," +
				"interfaces.URL as mocUrl," +
				"interfaces.params as params," +
				"user.NAME as devUser," +
				"interfaces.status as status " +
				"from interfaces,versions,project,users as user " +
				"where versions.ID=interfaces.VERSION_ID " +
				"and versions.PROJECT_ID=project.ID " +
				"and interfaces.DEV_USER_ID=user.id ";
		if(!StringUtil.isEmpty(versionId)){
			sql+="and versions.id=? ";
			params.add(Long.parseLong(versionId));
		}
		if(!StringUtil.isEmpty(projectId)){
			sql+="and project.id=? ";
			params.add(Long.parseLong(projectId));
		}
		if(!StringUtil.isEmpty(devUserId)){
			sql+="and user.id=? ";
			params.add(Long.parseLong(devUserId));
		}
		if(!StringUtil.isEmpty(moduleIds)){
			moduleIds=moduleIds.replace("[","");
			moduleIds=moduleIds.replace("]","");
			moduleIds=moduleIds.replace("\"","");
			sql+="and interfaces.id in (select INTERFACE_ID from interface_modules where MODULE_ID in ("+moduleIds+"))";
		}
		list=baseDAO.findBySQLForVO(sql, InterfaceVo.class,
				params.toArray(),offset,pageSize);
		totalSize=baseDAO.getTotalSizeForSQL(sql, params.toArray());
		map.put("list", list);
		map.put("totalSize", totalSize);
		return map;
	}

	@Override
	public int addInterface(InterfaceVo vo) throws ServiceException {
		// TODO Auto-generated method stub
		Interfaces inter=new Interfaces();
		Page page=new Page();
		inter.setName(vo.getName());
		inter.setParams(vo.getParams());
		inter.setResult(vo.getResult());
		inter.setStatus(Integer.parseInt(vo.getStatus()));
		inter.setUrl(vo.getUrl());
		inter.setRmk(vo.getRmk());
		inter.setRps(vo.getRps());
		inter.setMolurl(vo.getMocUrl());
//		System.out.println(vo.getParams());
		String params="";
		String rps="";
		JSONArray jsay=JSONArray.fromObject(vo.getParams());
		for(int i=0;i<jsay.size();i++){
			JSONObject jb=(JSONObject) jsay.get(i);
			params+="|";
			for(Object key:jb.keySet()){
				params+=jb.get(key)+" |";
			}
			params+="\n";
		}
		params+="\n";
		JSONArray jrps=JSONArray.fromObject(vo.getRps());
		for(int i=0;i<jrps.size();i++){
			JSONObject jrb=(JSONObject)jrps.get(i);
			rps+="|";
			for(Object key:jrb.keySet()){
				rps+=jrb.get(key)+" |";
			}
			rps+="\n";
		}
		rps+="\n";
		page.setAddtime((int) (new java.util.Date().getTime()));
		if(vo.getModule()!=null&&vo.getModule()!=""){
			JSONArray jmd=JSONArray.fromObject(vo.getModule());
			page.setCatId(Integer.valueOf(jmd.get(jmd.size()-1).toString()));
		}else{
			page.setCatId(0);
		}	
		page.setPageTitle(vo.getName());
		page.setSNumber(99);
		if(!StringUtil.isEmpty(vo.getDevUser())){
			Users user=baseDAO.findById(Long.parseLong(vo.getDevUser()), Users.class);
			inter.setUsers(user);
			page.setAuthorUsername(user.getName());
			page.setAuthorUid(Integer.parseInt(user.getId().toString()));
		}
		if(!StringUtil.isEmpty(vo.getVersionId())){
			Versions version=baseDAO.findById(Long.parseLong(vo.getVersionId()), Versions.class);
			inter.setVersions(version);
			Project project=version.getProject();
			page.setItemId(Integer.parseInt(project.getId().toString()));
			String content="**简要描述：**\n\n"+ "- "+vo.getName()+"\n\n**请求URL：** \n"+"- ` "+project.getUrl()+vo.getUrl()+" `\n\n**模拟URL：**\n"+"- `"+vo.getMocUrl()+"`\n\n"+"**请求方式：**\n"+"- POST\n\n"+"**参数：**\n\n" +
					"|参数名|必选|类型|说明|\n"+"|:----    |:---|:----- |-----   |\n" +params+"**返回示例**\n\n```\n" +vo.getResult()+"\n```\n\n**返回参数说明**\n\n"
					+"|参数名|类型|说明|\n"+"|:-----  |:-----|-----                           |\n"+rps+"**备注**\n\n"+"- "+vo.getRmk()+"\n";
			page.setPageContent(content);
		}else{
			return 1;
		}
		baseDAO.save(inter);
		baseDAO.save(page);
		if(!StringUtil.isEmpty(vo.getModule())){
			try {
				ObjectMapper mapper = new ObjectMapper();
				List<String> moduleIdList=mapper.readValue(vo.getModule(),
						List.class);
				for(String moduleId :moduleIdList){
					InterfaceModules interfaceModules=new InterfaceModules();
					Module module=baseDAO.findById(Long.parseLong(moduleId), Module.class);
					interfaceModules.setModule(module);
					interfaceModules.setInterfaces(inter);
					baseDAO.save(interfaceModules);
				}
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public int deleteInterface(String id) throws ServiceException {
		// TODO Auto-generated method stub
		Interfaces inter=baseDAO.findById(Long.parseLong(id), Interfaces.class);
		System.out.println("delete1");
		Page page=baseDAO.findById(Integer.parseInt(id), Page.class);
		for(Object o :inter.getInterfaceModuleses()){
			baseDAO.delete(o);
		}
		baseDAO.delete(inter);
		System.out.println("delete2");
		baseDAO.delete(page);
		System.out.println("delete3");
		
		return 0;
	}

	@Override
	public int editInterface(InterfaceVo vo) throws ServiceException {
		// TODO Auto-generated method stubInterface inter=new Interface();
		Interfaces inter=baseDAO.findById(Long.parseLong(vo.getId()), Interfaces.class);
		Page page=baseDAO.findById(Integer.parseInt(vo.getId()), Page.class);
		inter.setName(vo.getName());
		inter.setParams(vo.getParams());
		inter.setResult(vo.getResult());
		inter.setStatus(Integer.parseInt(vo.getStatus()));
		inter.setUrl(vo.getUrl());
		inter.setMolurl(vo.getMocUrl());
		inter.setRmk(vo.getRmk());
//		page.setAddtime((int) (new java.util.Date().getTime()));
		if(vo.getModule()!=null&&!vo.getModule().equals("")){
			JSONArray jmd=JSONArray.fromObject(vo.getModule());
			page.setCatId(Integer.valueOf(jmd.get(jmd.size()-1).toString()));
		}else{
			page.setCatId(0);
		}
		page.setPageTitle(vo.getName());
		page.setSNumber(99);
		String params="";
		JSONArray jsay=JSONArray.fromObject(vo.getParams());
		for(int i=0;i<jsay.size();i++){
			JSONObject jb=(JSONObject) jsay.get(i);
			params+="|";
			for(Object key:jb.keySet()){
				params+=jb.get(key)+" |";
			}
			params+="\n";
		}
		params+="\n";
		String rps="";
		JSONArray jrps=JSONArray.fromObject(vo.getRps());
		for(int i=0;i<jrps.size();i++){
			JSONObject jrb=(JSONObject)jrps.get(i);
			rps+="|";
			for(Object key:jrb.keySet()){
				rps+=jrb.get(key)+" |";
			}
			rps+="\n";
		}
		rps+="\n";	
		if(!StringUtil.isEmpty(vo.getDevUser())){
			Users user=baseDAO.findById(Long.parseLong(vo.getDevUser()), Users.class);
			inter.setUsers(user);
			page.setAuthorUsername(user.getName());
			page.setAuthorUid(Integer.parseInt(user.getId().toString()));
		}
		if(!StringUtil.isEmpty(vo.getVersionId())){
			Versions version=baseDAO.findById(Long.parseLong(vo.getVersionId()), Versions.class);
			inter.setVersions(version);
			Project project=version.getProject();
			page.setItemId(Integer.parseInt(project.getId().toString()));
			String content="**简要描述：**\n\n"+ "- "+vo.getName()+"\n\n**请求URL：** \n"+"- ` "+project.getUrl()+vo.getUrl()+" `\n\n**模拟URL：**\n"+"- `"+vo.getMocUrl()+"`\n\n"+"**请求方式：**\n"+"- POST\n\n"+"**参数：**\n\n" +
					"|参数名|必选|类型|说明|\n"+"|:----    |:---|:----- |-----   |\n" +params+"**返回示例**\n\n```\n" +vo.getResult()+"\n```\n\n**返回参数说明**\n\n"
					+"|参数名|类型|说明|\n"+"|:-----  |:-----|-----                           |\n"+rps+"**备注**\n\n"+"- "+vo.getRmk()+"\n";
			page.setPageContent(content);
		}else{
			return 1;
		}
		for(Object o :inter.getInterfaceModuleses()){
			baseDAO.delete(o);
		}
		baseDAO.save(inter);
		baseDAO.update(page);
		if(!StringUtil.isEmpty(vo.getModule())){
			try {
				ObjectMapper mapper = new ObjectMapper();
				List<String> moduleIdList=mapper.readValue(vo.getModule(),
						List.class);
				for(String moduleId :moduleIdList){
					InterfaceModules interfaceModules=new InterfaceModules();
					Module module=baseDAO.findById(Long.parseLong(moduleId), Module.class);
					interfaceModules.setModule(module);
					interfaceModules.setInterfaces(inter);
					baseDAO.save(interfaceModules);
				}
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public String getResultByUrl(String url) throws ServiceException {
		// TODO Auto-generated method stub
		List<Interfaces> list=baseDAO.findByProperty("url", url, Interfaces.class);
		String result="";
		if(list.size()!=0){
			result=list.get(0).getResult();
		}
		return result;
	}

}
