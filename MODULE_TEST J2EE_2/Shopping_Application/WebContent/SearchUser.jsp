
<%@page import="com.manthan.beanclass.ProductBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <% String msg=(String) request.getParameter("msg");
	ProductBean productBean =(ProductBean) request.getAttribute("searchedEmployee");
%>
<<jsp:include page="/homeuser"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="./searchprod" method="get">
		<h2>SEARCH product</h2>
		product id <input type="text" name="Product_ID" required>
		<input type="submit">
	</form>
	<div>
		<% if(msg!=null && !msg.isEmpty()){ %><h3 style="color:red"><%=msg %><% } %></h3>
		<% if(productBean!= null){ %>
			<h3>Employee Name:</h3>
			<%=productBean.getProduct_ID() %><br>
			<h3>description</h3>
			<%=productBean.getProduct_ID() %><br>
			<h3>product name</h3>
			<%=productBean.getProductName() %><br>
			
		<% } %>
	</div>
</body>
</html>