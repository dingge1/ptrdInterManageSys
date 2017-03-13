package com.huihuan.gmp.services.system.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class dfs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

// 2014年8月交易后项目组成立
Map<String, Object> postrade = new HashMap<String, Object>();
// 设置项目组组长
postrade.put("项目组组长", "王垚");

// 添加技术经理
List<String> technicalManagers = new ArrayList<String>();
technicalManagers.add("黄兴");
technicalManagers.add("金磊磊");
postrade.put("技术经理", technicalManagers);

// 添加需求工程师
List<String> requirementEngineers = new ArrayList<String>();
requirementEngineers.add("卢梦瑜");
postrade.put("需求工程师", requirementEngineers);

// 添加数据库工程师
List<String> databaseEngineer = new ArrayList<String>();
databaseEngineer.add("胡玉乐");
postrade.put("数据库工程师", databaseEngineer);

// 添加开发工程师
List<String> developmentManager = new ArrayList<String>();
developmentManager.add("李长荣");
developmentManager.add("赵银龙");
developmentManager.add("熊万强");
developmentManager.add("王金炎");
developmentManager.add("施洲琪");
developmentManager.add("何川");
postrade.put("软件开发工程师", developmentManager);

//ZhongHui.put("交易后项目组", postrade);
	}

}
