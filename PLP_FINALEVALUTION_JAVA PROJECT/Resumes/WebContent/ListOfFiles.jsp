<%@page import="java.io.*"%>
<%@page import="java.util.*"%>
<%!        public void GetDirectory(String a_Path, Vector a_files, Vector a_folders) {
                File l_Directory = new File(a_Path);
                File[] l_files = l_Directory.listFiles();

                for (int c = 0; c < l_files.length; c++) {
                    if (l_files[c].isDirectory()) {
                        a_folders.add(l_files[c].getName());
                    } else {
                        a_files.add(l_files[c].getName());
                    }
                }


            }
        %>

<%
            Vector l_Files = new Vector(), l_Folders = new Vector();
            GetDirectory("D:\\Upload", l_Files, l_Folders);

            //folders should be left out... 
            //for( int a = 0 ; a<l_Folders.size() ; a++ ) 
            //out.println( "[<b>"+l_Folders.elementAt(a).toString() + "</b>]<br>") ; 

            //generate files as XML 
            out.println("<resume>");
			out.println();
			
            for (int a = 0; a < l_Files.size(); a++) {
            	
                out.println("<file>    " + l_Files.elementAt(a).toString() + "</file> <a href='./downloads' >  Download  </a> <br>");
            }

            out.println("</resume>");
        %>
