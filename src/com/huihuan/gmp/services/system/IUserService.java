package com.huihuan.gmp.services.system;

import java.util.List;

import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.services.common.ICommService;
import com.huihuan.gmp.vo.UserVo;

public interface IUserService extends ICommService{
	
	public UserVo getUser(String id) throws ServiceException;
	
	public List getUsers(String roleId) throws ServiceException;
	
	public int addUser(String username, String password, String name, String roleId) throws ServiceException;
	
	public int deleteUser(String id) throws ServiceException;
	
	public int editUser(String id, String username, String password, String name, String roleId) throws ServiceException;
}
