package com.huihuan.gmp.services.system;

import java.util.List;
import java.util.Map;

import com.huihuan.framework.exceptions.ServiceException;
import com.huihuan.gmp.services.common.ICommService;
import com.huihuan.gmp.vo.InterfaceVo;

public interface IInterfaceService extends ICommService{

	public InterfaceVo getInterfaceById(String id) throws ServiceException;
	
	public Map getInterfaces(String projectId,String moduleId,String versionId,String devUserId,String queryPage,String pageSize) throws ServiceException;
	
	public int addInterface(InterfaceVo vo) throws ServiceException;
	
	public int deleteInterface(String id) throws ServiceException;
	
	public int editInterface(InterfaceVo vo) throws ServiceException;
	
	public String getResultByUrl(String url) throws ServiceException;
}
