package com.huihuan.gmp.services.system;

import java.util.List;

import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.services.common.ICommService;
import com.huihuan.gmp.vo.VersionVo;

public interface IVersionService extends ICommService{
	
	public List getVersions(String projectId) throws ServiceException;
	
	public List getVersionsForSelect(String projectId) throws ServiceException;

	public VersionVo getVersion(String id) throws ServiceException;
	
	public int addVersion(VersionVo vo) throws ServiceException;
	
	public int deleteVersion(String id) throws ServiceException;
	
	public int editVersion(VersionVo vo) throws ServiceException;
}
