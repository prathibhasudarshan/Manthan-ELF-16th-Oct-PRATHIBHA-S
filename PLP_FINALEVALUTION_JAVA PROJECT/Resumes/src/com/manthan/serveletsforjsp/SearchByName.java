package com.manthan.serveletsforjsp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
@WebServlet("/searchresume")
public class SearchByName extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ArrayList<File> filearray= new ArrayList<File>();
	    
	    
	    String s = req.getParameter("searchbyname");
	    File f = new File("D:\\Upload");
	    if(f.exists()&&f.isDirectory()) {
	    	File arg[]= f.listFiles();
	    	for(File filesystem: arg) {
	    		if(filesystem.isFile()){
	    			try {	    				
	    				PDDocument iiii = PDDocument.load(filesystem);
	    				
	    				PDFTextStripper pdfStrippper = new PDFTextStripper();
	    				
	    				String string1 = pdfStrippper.getText(iiii);
	    				
	    				String string2= string1.replace("\n", " ").replace("\r", " ");
	    				
	    				if(string2.contains(s)) {
	    					
	    					System.out.println(filesystem);
	    					filearray.add(filesystem);
	    				}
	    				
	    				
	    			  }
	    		  catch(Exception e)
	    			 {
	    				
	    			 }
	    		}
	    	}
	    	
	    }
		
	    req.setAttribute("filesearch", filearray);
	    req.getRequestDispatcher("./search").forward(req, resp);
	}
	
	
	

}
