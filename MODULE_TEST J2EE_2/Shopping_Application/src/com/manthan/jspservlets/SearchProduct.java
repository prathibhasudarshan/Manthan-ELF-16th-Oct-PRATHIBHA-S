package com.manthan.jspservlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manthan.beanclass.ProductBean;
import com.manthan.dao.ProductDAO;
import com.manthan.dao.ProductImp;


@WebServlet("/searchprod")
public class SearchProduct extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession(false);
		
		if(session!=null){
			int Product_ID=Integer.parseInt(req.getParameter("Product_ID"));
			
		ProductDAO dao=new ProductImp();
		ProductBean productBean=dao.search(Product_ID);
			
			
			
			if(productBean!=null) {
				req.setAttribute("searchedEmployee", productBean);
			}else {
				req.setAttribute("msg", " Id not found");
			}
			req.getRequestDispatcher("./searchproduct").forward(req, resp);
			
		}else {
			req.setAttribute("msg", "Please!!! Login First");
			req.getRequestDispatcher("/loginuserjsp").include(req, resp);
		}
	}//end of doGet()
	

}
