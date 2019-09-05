<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>GET BY CATEGORY</title>
</head>
<body>
<h1>GET BY CATEGORY </h1>
<form action="MenuController" method="get">
	<input type="hidden" name="action" value="getBycategory"> 
	CATEGORY <input type="text" name="category"/><br>
	<input type="submit" value="get">
</form>
<pre>${menu }</pre>
<a href="Admin.jsp">go back</a>

</body>
</html>