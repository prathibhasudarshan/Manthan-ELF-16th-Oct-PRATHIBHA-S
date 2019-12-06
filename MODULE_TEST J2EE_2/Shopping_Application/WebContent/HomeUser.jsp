<%@page import="com.manthan.beanclass.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
    <% UserBean userBean=(UserBean)session.getAttribute("userBean"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Hello <%= userBean.getUserName() %></h1>
<a href="SearchUser.jsp">SEARCH product</a><br><br>

<a href="./seeAll">SEE ALL </a><br><br>

<a href="./logoutuser">LOGOUT </a><br><br>
</body>
</html>