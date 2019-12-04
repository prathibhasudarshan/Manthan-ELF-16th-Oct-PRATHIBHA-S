package com.manthan.serveletsforjsp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/downloads")
public class Download extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");  
		PrintWriter out = resp.getWriter();  
		String name ="./dummy.pdf";
		String path = "D:\\Upload\\";   
		resp.setContentType("APPLICATION/OCTET-STREAM");   
		resp.setHeader("Content-Disposition","attachment; filename=\"" + name + "\"");   

		FileInputStream fileInputStream = new FileInputStream(path + name);  

		int i;   
		while ((i=fileInputStream.read()) != -1) {  
			out.write(i);   
		}   
		fileInputStream.close();   
		out.close();   
	}  
}



