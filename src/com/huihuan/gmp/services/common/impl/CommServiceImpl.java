package com.huihuan.gmp.services.common.impl;
import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.huihuan.gmp.daos.BaseDAO;
import com.huihuan.gmp.services.common.ICommService;

@Service(value="commService")
public class CommServiceImpl implements ICommService {

	private Log log = LogFactory.getLog(CommServiceImpl.class);

	@Resource
	protected BaseDAO baseDAO;
}
