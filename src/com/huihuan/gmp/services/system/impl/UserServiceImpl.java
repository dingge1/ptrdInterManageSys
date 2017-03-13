package com.huihuan.gmp.services.system.impl;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.huihuan.common.util.DateUtil;
import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.entity.Project;
import com.huihuan.gmp.entity.Role;
import com.huihuan.gmp.entity.User;
import com.huihuan.gmp.entity.Users;
import com.huihuan.gmp.services.common.impl.CommServiceImpl;
import com.huihuan.gmp.services.system.IProjectService;
import com.huihuan.gmp.services.system.IRoleService;
import com.huihuan.gmp.services.system.IUserService;
import com.huihuan.gmp.vo.UserVo;

@Service(value="userService")
public class UserServiceImpl extends CommServiceImpl implements IUserService {

	private Log log = LogFactory.getLog(UserServiceImpl.class);

	@Override
	public List getUsers(String roleId) throws ServiceException {
		// TODO Auto-generated method stub
		String hql="from Users ";
		List params=new ArrayList();
		if(roleId!=null){
			hql+="where role.id=?";
			params.add(Long.parseLong(roleId));
		}
		List<Users> list;
		if(params.size()==0){
			list=baseDAO.findByHQL(hql);
		}else{
			list=baseDAO.findByHQL(hql, params.toArray());
		}
		List resultList=new ArrayList();
		for(Users user:list){
			UserVo vo=new UserVo();
			vo.setId(user.getId());
			vo.setName(user.getName());
			vo.setPassword(user.getPassword());
			if(user.getRole()!=null){
				vo.setRoleId(user.getRole().getName());
			}
			vo.setUsername(user.getUsername());
			resultList.add(vo);
		}
		return resultList;
	}

	@Override
	public int addUser(String username, String password, String name,
			String roleId) throws ServiceException {
		// TODO Auto-generated method stub
		Users user=new Users();
		user.setUsername(username);
		user.setPassword(password);
		user.setName(name);
		Role role=baseDAO.findById(Long.parseLong(roleId), Role.class);
		user.setRole(role);
		baseDAO.save(user);
		return 0;
	}

	@Override
	public int deleteUser(String id) throws ServiceException {
		// TODO Auto-generated method stub
		User user=baseDAO.findById(Long.parseLong(id), User.class);
		baseDAO.delete(user);
		return 0;
	}

	@Override
	public int editUser(String id, String username, String password, String name,
			String roleId) throws ServiceException {
		// TODO Auto-generated method stub
		Users user=baseDAO.findById(Long.parseLong(id), Users.class);
		if(username!=null){
			user.setUsername(username);
		}
		if(password!=null){
			user.setPassword(password);
		}
		if(name!=null){
			user.setName(name);
		}
		if(roleId!=null){
			Role role=baseDAO.findById(Long.parseLong(roleId), Role.class);
			user.setRole(role);
		}
		baseDAO.update(user);
		return 0;
	}

	@Override
	public UserVo getUser(String id) throws ServiceException {
		// TODO Auto-generated method stub
		Users user=baseDAO.findById(Long.parseLong(id), Users.class);
		UserVo vo=new UserVo();
		vo.setId(user.getId());
		vo.setName(user.getName());
		vo.setPassword(user.getPassword());
		if(user.getRole()!=null){
			vo.setRoleId(user.getRole().getId()+"");
		}
		vo.setUsername(user.getUsername());
		return vo;
	}
	
}
