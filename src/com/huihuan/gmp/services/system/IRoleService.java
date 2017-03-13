package com.huihuan.gmp.services.system;

import java.util.List;

import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.services.common.ICommService;
import com.huihuan.gmp.vo.RoleVo;

public interface IRoleService extends ICommService{

	public RoleVo getRole(String id) throws ServiceException;

	public List getRoles() throws ServiceException;
	
	public int addRole(String name, int status) throws ServiceException;
	
	public int deleteRole(Long id) throws ServiceException;
	
	public int editRole(Long id,String name, int status) throws ServiceException;
}
