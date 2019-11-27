package com.manthan.servelets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manthan.bean.userinfobean;
import com.manthan.dao.UserDao;

import com.manthan.util.Daomgr;



@WebServlet("/login1")
public class loginservlet extends HttpServlet {
	
	UserDao dao=Daomgr.getDaoIns();
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String username=req.getParameter("username");
		String pw=req.getParameter("pw");

		
		
		userinfobean userinfobean=dao.authenticate(username, pw);

		if (userinfobean != null) {
			HttpSession session=req.getSession(true);
			session.setAttribute("userinfobean", userinfobean);
			req.getRequestDispatcher("./home").forward(req, resp);


		} else {
			req.setAttribute("msg", "invalid ");
			req.getRequestDispatcher("./loginform").forward(req, resp);
		}


	}

}
