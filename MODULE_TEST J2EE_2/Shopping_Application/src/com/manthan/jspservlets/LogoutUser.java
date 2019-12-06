package com.manthan.jspservlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/logoutuser")
public class LogoutUser extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession(false);
		if (session!=null) {
			session.invalidate();
			
			req.setAttribute("logoutMsg", "You are Logged out!!");
			req.getRequestDispatcher("./loginuserjsp").include(req, resp);
			
		} else {
			req.setAttribute("logoutMsg", "You are Logged out!!");
			req.getRequestDispatcher("./loginuserjsp").include(req, resp);
		}
	}

}
