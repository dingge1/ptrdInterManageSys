package com.huihuan.gmp.services.system.impl;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.huihuan.common.util.DateUtil;
import com.huihuan.common.util.StringUtil;
import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.entity.Project;
import com.huihuan.gmp.entity.Versions;
import com.huihuan.gmp.services.common.impl.CommServiceImpl;
import com.huihuan.gmp.services.system.IProjectService;
import com.huihuan.gmp.services.system.IVersionService;
import com.huihuan.gmp.vo.ProjectVo;
import com.huihuan.gmp.vo.VersionVo;
import org.apache.commons.beanutils.BeanUtils;

@Service(value="versionService")
public class VersionServiceImpl extends CommServiceImpl implements IVersionService {

	private Log log = LogFactory.getLog(VersionServiceImpl.class);

	@Override
	public List getVersions(String projectId) throws ServiceException {
		// TODO Auto-generated method stub
		List list = baseDAO.findBySQLForVO("select versions.id as id,project.name as project,versions.name as name,versions.code as code,versions.status as status " +
				"from versions LEFT JOIN project on versions.PROJECT_ID=project.ID where versions.project_id=?", 
				VersionVo.class, new Object[]{projectId});
		return list;
	}
	
	@Override
	public List getVersionsForSelect(String projectId) throws ServiceException {
		// TODO Auto-generated method stub
		List list = baseDAO.findBySQLForVO("select versions.id as id,CONCAT(versions.code,versions.name) as name " +
				"from versions LEFT JOIN project on versions.PROJECT_ID=project.ID where versions.project_id=?", 
				VersionVo.class, new Object[]{projectId});
		return list;
	}

	@Override
	public VersionVo getVersion(String id) throws ServiceException {
		// TODO Auto-generated method stub
		Versions version=baseDAO.findById(Long.parseLong(id), Versions.class);
		VersionVo vo=new VersionVo();
		vo.setCode(version.getCode());
		vo.setId(version.getId()+"");
		vo.setName(version.getName());
		vo.setProject(version.getProject().getName());
		vo.setStatus(version.getStatus()+"");
		return vo;
	}

	@Override
	public int addVersion(VersionVo vo) throws ServiceException {
		// TODO Auto-generated method stub
		Versions version=new Versions();
		version.setCode(vo.getCode());
		version.setName(vo.getName());
		if(!StringUtil.isEmpty(vo.getProject())){
			version.setProject(baseDAO.findById(Long.parseLong(vo.getProject()), Project.class));
		}
		version.setStatus(Integer.parseInt(vo.getStatus()));
		baseDAO.save(version);
		return 0;
	}

	@Override
	public int deleteVersion(String id) throws ServiceException {
		// TODO Auto-generated method stub
//		System.out.println(id);
		Versions version=baseDAO.findById(Long.parseLong(id), Versions.class);
//		System.out.println("version:"+version.getId());
		baseDAO.delete(version);
		return 0;
	}

	@Override
	public int editVersion(VersionVo vo) throws ServiceException {
		// TODO Auto-generated method stub
		Versions version=baseDAO.findById(Long.parseLong(vo.getId()), Versions.class);
		version.setCode(vo.getCode());
		version.setName(vo.getName());
		if(!StringUtil.isEmpty(vo.getProject())){
			version.setProject(baseDAO.findById(Long.parseLong(vo.getProject()), Project.class));
		}
		version.setStatus(Integer.parseInt(vo.getStatus()));
		baseDAO.update(version);
		return 0;
	}

}
