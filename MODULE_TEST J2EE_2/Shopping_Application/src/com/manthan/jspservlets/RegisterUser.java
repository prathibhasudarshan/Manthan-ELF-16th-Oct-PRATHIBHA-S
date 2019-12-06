package com.manthan.jspservlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manthan.beanclass.UserBean;
import com.manthan.dao.UserDAO;
import com.manthan.util.UserMgr;


@WebServlet("/registeruserServletJsp")
public class RegisterUser extends HttpServlet {
	
	private UserDAO dao=UserMgr.getDaoManager();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		HttpSession session=req.getSession(false);
		if(session!=null){
			//EmployeeInfoBeans beans=(EmployeeInfoBeans) req.getAttribute("employeeInfoBean");
			
			//get the form data
			
			int User_ID=Integer.parseInt(req.getParameter("User_ID"));
			
			String UserName=(req.getParameter("UserName"));
			String Email=(req.getParameter("Email"));
			
			String Password=req.getParameter("Password");
			UserBean userBean =new UserBean();
			userBean.setUser_Id(User_ID);
			userBean.setUserName(UserName);
			userBean.setEmail(Email);
			userBean.setPassword(Password);
			
			if(dao.register(userBean)) {
			
		
				req.setAttribute("msg", "USER Added!!...Enjoy");
			}else {
				req.setAttribute("msg", "USER added");
			}
			req.getRequestDispatcher("./adduser").forward(req, resp);
		}else {
			req.setAttribute("msg", "Please!!! Login First");
			req.getRequestDispatcher("/loginuserjsp").include(req, resp);
		}//end of if-else()
	
	}// end of doPost()

}
