package com.manthan.serveletsforjsp;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
@WebServlet("/Search")
public class Search extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String input=req.getParameter("search");
		System.out.println(input);
		String dir="D:\\Upload";
		File maindir= new File(dir);
		if(maindir.exists()&& maindir.isDirectory()) {
			File arr[]= maindir.listFiles();
			for(File F: arr) {
				if(F.isFile()&&F.getName().substring(F.getName().lastIndexOf(".")).equals(".pdf")) {
					System.out.println(F.getName().substring(F.getName().lastIndexOf(".")));
					PDDocument files = PDDocument.load(F);
					PDFTextStripper pdf = new PDFTextStripper();
					String text = pdf.getText(files);
					//System.out.println(text);
					String[] textArr=text.split("\\r?\\n");
					for(String s:textArr)
					{


						if(s.contains(input)) {
							String text2=pdf.getText(files);
							System.out.println("found");
							System.out.println(F.getName()+""+F.getName().substring(F.getName().lastIndexOf(".")));
							req.setAttribute("message", text2);
							req.getRequestDispatcher("/result").forward(req, resp);
							
							
							break;
						}
					}

					files.close();
					//					req.setAttribute("message", text);
					//					req.getRequestDispatcher("/result").forward(req, resp);
				}
			}

		}


	}
}
