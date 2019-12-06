<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% String msg=(String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="./registeruserServletJsp" method="post">
		<table>
			<tr>
				<td>user id</td>
				<td><input type="number" name="User_ID" required></td>
			</tr>
			<tr>
				<td>USER Name:</td>
				<td><input type="text" name="UserName" required></td>
			</tr>
			<tr>
				<td>email</td>
				<td><input type="text" name="Email" required></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="text" name="Password" required></td>
			</tr>
			
				
			<tr>
				<td><input type="submit" value="register"></td>
			</tr>
		</table>

	</form>
	
	<div>
		<% if(msg!=null && !msg.isEmpty()){ %><h3 style="color:red"><%=msg %><% } %></h3>
	</div>
	
</body>
</html>