package com.manthan.servelets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout1")


public class logout extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session=req.getSession(false);
	if(session!=null) {
		session.invalidate();
		req.getRequestDispatcher("./loginform1").include(req, resp);
	}
	else
	{
		req.getRequestDispatcher("./loginform1").include(req, resp);
	}
	}
}
