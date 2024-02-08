<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success</title>
</head>
<body>
	
	<h1>Welcome, ${user.name}</h1>
	<h2>Your Email id is : ${user.email}</h2>
	<h3>Your Password is : ${user.password}</h3>
	<p>${id}</p>
</body>
</html>