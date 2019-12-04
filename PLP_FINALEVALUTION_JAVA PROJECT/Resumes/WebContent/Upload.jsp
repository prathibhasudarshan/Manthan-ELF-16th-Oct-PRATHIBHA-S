<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%String msg =(String)request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>

</style>
</head>
<body style="background-color: lightblue">
	<% if (msg!=null && !msg.isEmpty()) { %>

	<h2><%=msg %></h2>
	<%} %>
	<h1>RESUME FINDER</h1><br><br>
	<a style="margin-left: 350px" href="SearchByName.jsp">SEARCH RESUME BY NAME</a>
	<a style="margin-left: 450px" href="Searchs.jsp">SEARCH A RESUME</a>
	<br>
	<br>
	<h3>Choose File to Upload</h3>
	<form action="./upload22" method="post" enctype="multipart/form-data">
		<input type="file" name="file" /> <input type="submit" value="upload" />
	</form>
</body>
</html>