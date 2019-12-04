package com.manthan.serveletsforjsp;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/upload22")
@MultipartConfig
public class FileUpload extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(ServletFileUpload.isMultipartContent(request)){
			try {
				List <FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				for(FileItem item : multiparts){
					if(!item.isFormField()){
						String name = new File(item.getName()).getName();
						item.write( new File("D:\\Upload" + File.separator + name));
					}
				}


				//	                System.out.println(filePart.getName());
				//	    			System.out.println(filePart.getSize());
				//	    			System.out.println(filePart.getContentType());
				//	    			
				//	    			// obtains input stream of the upload file
				//	    			inputStream = filePart.getInputStream();
				//File uploaded successfully
				request.setAttribute("msg", "SUCCESS");
			} catch (Exception ex) {
				request.setAttribute("msg", "FILE DINT UPLOAD  " + ex);
			}         		
		}else{

			request.setAttribute("msg","FILE NOT FOUND");
		}
		request.getRequestDispatcher("/upload2").forward(request, response);

	}
	//	 if (pdfFileBytes != null) {
	//         pdfFileBytes.close();
	//     }
	//     if (writer != null) {
	//         writer.close();
	//     }
}


