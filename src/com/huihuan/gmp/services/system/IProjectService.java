package com.huihuan.gmp.services.system;

import java.util.List;

import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.services.common.ICommService;
import com.huihuan.gmp.vo.ProjectVo;

public interface IProjectService extends ICommService{

	public List getProjects() throws ServiceException;

	public ProjectVo getProject(String id) throws ServiceException;
	
	public int addProject(String name,String url, int status) throws ServiceException;
	
	public int deleteProject(Long id) throws ServiceException;
	
	public int editProject(Long id,String name,String url, int status) throws ServiceException;
}
