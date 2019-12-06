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
import com.manthan.dao.UserDAOImpl;
import com.manthan.util.UserMgr;

@WebServlet("/loginuser")
public class LoginUserServlet extends HttpServlet {
	//UserDAO dao=UserMgr.getDaoManager();
	
	
	UserDAO dao=new UserDAOImpl(); 
	
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Email=(req.getParameter("Email"));
		String Password=(req.getParameter("Password"));
		
		UserBean userBean=dao.authenticate(Email, Password);
		if(userBean!=null)
		{
		HttpSession session=req.getSession(true);
			session.setAttribute("userBean",userBean);
			req.getRequestDispatcher("/homeuser").forward(req, resp);
		}else {
			req.setAttribute("invalidMessage", "Invalid email or password");
			req.getRequestDispatcher("/loginuserjsp").forward(req, resp);
		}

	}

}
