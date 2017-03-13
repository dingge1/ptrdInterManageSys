/**
 * Copyright (c) 2000-2010 China Foreign Exchange Trade System 
 *                         & National Interbank Funding Center.All Rights Reserved.
 * File name:      CfetsConfigurer.java
 * Date:           2011-9-11
 * Description:    // 用于详细说明此程序文件完成的主要功
 *                 // 能与其他模块或函数的接口，输出值、
 *                 // 取值范围、含义及参数间的关系
 * Modify History:     Date             Programmer       Notes
 *                    ---------        ---------------  ---------
 *                    2011-9-11             何指剑                         Initial
 **********************************************************************
 */
package com.huihuan.framework.configurer;

import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import com.huihuan.common.util.DesThreeUtil;
import com.huihuan.gmp.actions.authority.AjaxAuthorityInterceptor;

/**
 * Created on 2011-9-11
 * <p>Title:       中国外汇交易中心_[子系统统名]_[模块名]/p>
 * <p>Description: [描述该类概要功能介绍]</p>
 * @version        1.0
 */
public class CfetsConfigurer extends PropertyPlaceholderConfigurer{
	private static final Log log = LogFactory.getLog(CfetsConfigurer.class);
  @Override
  protected void processProperties(ConfigurableListableBeanFactory beanFactory,Properties props)
    throws BeansException{
    String password = props.getProperty("hibernate.connection.password");
    String s2=DesThreeUtil.filePassEncrypt("12345678");
    log.info(s2);
    if(password!=null && !password.trim().equals("")){
      props.setProperty("hibernate.connection.password", DesThreeUtil.filePassDecrypt(password));
    }
    super.processProperties(beanFactory, props);
  }
}
