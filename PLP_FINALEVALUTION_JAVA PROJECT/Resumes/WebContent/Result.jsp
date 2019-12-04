<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%String msg=(String) request.getAttribute("message");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: lightpink">
	<div id="Result">
		<h3><%=msg %></h3>
	</div>
	
</body>
</html>