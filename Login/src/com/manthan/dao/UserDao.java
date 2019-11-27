package com.manthan.dao;

import com.manthan.bean.userinfobean;


public interface UserDao {
	public userinfobean authenticate(String username,String pw);
	

}
