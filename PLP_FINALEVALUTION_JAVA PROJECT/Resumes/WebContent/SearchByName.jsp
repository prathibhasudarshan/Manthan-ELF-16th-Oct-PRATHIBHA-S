<%@page import="java.io.File"%>
<%@page import="java.util.ArrayList"%><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%ArrayList<File> array =(ArrayList<File>) request.getAttribute("filesearch"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: lightblue">
<form action="./searchresume" method="get" align="center">
		<h1 style="margin-left: 50PX; margin-top: 70PX">SEARCH RESUME</h1>
<p>Search Resume</p>
<p><input type="text" name="searchbyname" /></p>
<p> <input type="submit"  value="submit" /></p>
</form>
<%if(array!=null) {%>

	<%
		for(File f:array){
	%>
	  
	  <p><%=f.getName()%></p>
	  <a href="ListOfFiles.jsp?filename=<%=f.getName()%>" >LIST OF FILES WHERE YOU CAN DOWNLOAD</a>
	  <br/>
	  
	<%
	}
	%>
<%} %>

</body>
</html>