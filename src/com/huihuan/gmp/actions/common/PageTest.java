package com.huihuan.gmp.actions.common;

import java.sql.Timestamp;

import com.huihuan.gmp.daos.BaseDAO;
import com.huihuan.gmp.entity.Page;
import com.huihuan.gmp.entity.Users;

public class PageTest  {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		BaseDAO ba=new BaseDAO();
//		Page page=new Page();
//		String name="";
//		String url="";
//		String params="";
//		String result="";
//		String results="";
//		String devUser="12";
//		String devusername="";
//		String itemId="1";

//		page.setAddtime(123456);
//		page.setAuthorUid(Integer.parseInt(devUser));
//		page.setAuthorUsername(devusername);
//		page.setCatId(0);
//		page.setItemId(Integer.parseInt(itemId));
//		page.setPageContent(content);
//		page.setPageTitle(name);
//		page.setSNumber(99);
//		ba.save(page);
//
//	}
public static void main(String[] args){
	BaseDAO baseDAO=new BaseDAO();
	Users user=baseDAO.findById(1, Users.class);
	System.out.println(user.getName());

	 
	 


	 
	 
	
}
}
