package com.huihuan.gmp.services.system;

import java.util.List;
import java.util.Map;

import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.services.common.ICommService;
import com.huihuan.gmp.vo.ModuleVo;

public interface IModuleService extends ICommService{
	public ModuleVo getModuleById(String id) throws ServiceException;

	public Map getModules(String projectId) throws ServiceException;

	public List getModulesForCombobox(String projectId,String interfaceId) throws ServiceException;
	
	public int deleteModule(String id) throws ServiceException;
	
	public int editModule(String id, String name) throws ServiceException;
	
	public ModuleVo addModule(String name, String parent) throws ServiceException;
}
