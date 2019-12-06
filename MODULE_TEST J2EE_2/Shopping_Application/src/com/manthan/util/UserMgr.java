package com.manthan.util;

import com.manthan.dao.UserDAO;
import com.manthan.dao.UserDAOImpl;

public class UserMgr {
	private UserMgr() { //restricting others to make object......

	}
	public static UserDAO getDaoManager() {
		return new UserDAOImpl();
	}
	

}
