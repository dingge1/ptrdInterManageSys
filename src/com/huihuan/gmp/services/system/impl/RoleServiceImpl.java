package com.huihuan.gmp.services.system.impl;
import java.lang.reflect.InvocationTargetException;
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
import com.huihuan.gmp.services.common.impl.CommServiceImpl;
import com.huihuan.gmp.services.system.IProjectService;
import com.huihuan.gmp.services.system.IRoleService;
import com.huihuan.gmp.vo.RoleVo;
import org.apache.commons.beanutils.BeanUtils;

@Service(value="roleService")
public class RoleServiceImpl extends CommServiceImpl implements IRoleService {

	private Log log = LogFactory.getLog(RoleServiceImpl.class);

	@Override
	public List getRoles()  throws ServiceException{
		// TODO Auto-generated method stub
		List<Role> list = baseDAO.findByHQL("from Role");
		List resultList=new ArrayList();
		for(Role role :list){
			RoleVo vo=new RoleVo();
			try {
				BeanUtils.copyProperties(vo, role);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resultList.add(vo);
		}
		return resultList;
	}

	@Override
	public int addRole(String name, int status)
			throws ServiceException {
		// TODO Auto-generated method stub
		Role item=new Role();
		item.setName(name);
		item.setStatus(0);
		baseDAO.save(item);
		return 0;
	}

	@Override
	public int deleteRole(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		Role item=baseDAO.findById(id, Role.class);
		baseDAO.delete(item);
		return 0;
	}

	@Override
	public int editRole(Long id, String name, int status)
			throws ServiceException {
		// TODO Auto-generated method stub
		Role item=baseDAO.findById(id, Role.class);
		item.setName(name);
		item.setStatus(0);
		baseDAO.save(item);
		return 0;
	}

	@Override
	public RoleVo getRole(String id) throws ServiceException {
		// TODO Auto-generated method stub
		Role role=baseDAO.findById(Long.parseLong(id), Role.class);
		RoleVo vo=new RoleVo();
		try {
			BeanUtils.copyProperties(vo, role);
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
