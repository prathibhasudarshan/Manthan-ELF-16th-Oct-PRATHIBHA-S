package com.manthan.dao;

import java.util.List;

import com.manthan.beanclass.UserBean;


public interface UserDAO {
	public UserBean authenticate( String Email,String Password);
	public UserBean search(int User_Id);
	public boolean register(UserBean userBean);
	//public boolean updateEmployee(int empId,Long empMobile);
	//public boolean deleteEmployee();
	public List<UserBean> history();

}
