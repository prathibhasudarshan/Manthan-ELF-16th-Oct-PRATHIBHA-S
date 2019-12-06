<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <% String msg=(String)request.getAttribute("invalidMessage");
String logoutMsg=(String)request.getAttribute("logoutMsg");%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% if(msg!=null) { %>
<%= msg %>
<% } %>
<h5 style="color: blue;">
<h5 style="color: blue;">
<% if(logoutMsg!=null) { %>
<%= logoutMsg %>
<% } %>
</h5>


<fieldset>
<legend>USER LOGIN</legend>
<form action="./loginuser" method="post">
		EMAIL:<input type="text" name="Email"/><br><br>
		Password:<input	type="password" name="Password"/><br> 
		
		<input type="submit" value="submit" /><br>
		
		
	<a style="margin-left: 350px" href="RegisterUser.jsp">REGISTER</a>
	
	<br>
	<br>
	</form>
	</fieldset>
</body>
</html>