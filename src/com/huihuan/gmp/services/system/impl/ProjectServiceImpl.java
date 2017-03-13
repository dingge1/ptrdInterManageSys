package com.huihuan.gmp.services.system.impl;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import antlr.Version;

import com.huihuan.common.util.DateUtil;
import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.entity.Item;
import com.huihuan.gmp.entity.Module;
import com.huihuan.gmp.entity.Project;
import com.huihuan.gmp.entity.Versions;
import com.huihuan.gmp.services.common.impl.CommServiceImpl;
import com.huihuan.gmp.services.system.IModuleService;
import com.huihuan.gmp.services.system.IProjectService;
import com.huihuan.gmp.services.system.IVersionService;
import com.huihuan.gmp.vo.ProjectVo;

import org.apache.commons.beanutils.BeanUtils;

@Service(value="projectService")
public class ProjectServiceImpl extends CommServiceImpl implements IProjectService {

	private Log log = LogFactory.getLog(ProjectServiceImpl.class);
	@Resource
	private IModuleService moduleService;
	@Resource
	private IVersionService versionService;
	@Override
	public List getProjects()  throws ServiceException{
		// TODO Auto-generated method stub
		List<Project> list = baseDAO.findByHQL("from Project");
		return list;
	}

	@Override
	public int addProject(String name, String url, int status)
			throws ServiceException {
		// TODO Auto-generated method stub
		Project project=new Project();
		Item item=new Item();
		item.setUid(1);
		item.setUsername("ding");
		item.setItemName(name);
		item.setAddtime((int) (new java.util.Date().getTime()));
		item.setItemDescription("");
		item.setItemDomain("");
		item.setPassword("");
		item.setLastUpdateTime(0);
		project.setName(name);
		project.setUrl(url);
		project.setStatus(0);
		baseDAO.save(project);
		baseDAO.save(item);
		return 0;
	}

	@Override
	public int deleteProject(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		Project project=baseDAO.findById(id, Project.class);
		Item item=baseDAO.findById(Integer.parseInt(id.toString()), Item.class);
		List<Versions> version=  baseDAO.findByProperty("project", project, Versions.class);
		List<Module> mlist=baseDAO.findByProperty("project", project, Module.class);
		if(mlist.size()>0){
			for(Module module:mlist){
				if(module.getModule()==null){
					moduleService.deleteModule(module.getId().toString());
				}
			}
		}
		if(version.size()>0){
			for(Versions vs:version){		
			     versionService.deleteVersion(vs.getId().toString());
			}
		}
		baseDAO.delete(project);
		baseDAO.delete(item);
		return 0;
	}

	@Override
	public int editProject(Long id, String name, String url, int status)
			throws ServiceException {
		// TODO Auto-generated method stub
		Project project=baseDAO.findById(id, Project.class);
		Item item=baseDAO.findById(Integer.parseInt(id.toString()), Item.class);
		project.setName(name);
		item.setItemName(name);
		project.setUrl(url);
		project.setStatus(status);
		baseDAO.save(project);
		baseDAO.save(item);
		return 0;
	}

	@Override
	public ProjectVo getProject(String id) throws ServiceException {
		// TODO Auto-generated method stub
		Project project=baseDAO.findById(Long.parseLong(id), Project.class);
		ProjectVo vo=new ProjectVo();
		try {
			BeanUtils.copyProperties(vo, project);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}
}
