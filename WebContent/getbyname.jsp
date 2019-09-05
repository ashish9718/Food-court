<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>GET BY NAME</title>
</head>
<body>
<h1>GET BY NAME </h1>
<form action="UserController" method="get">
	<input type="hidden" name="action" value="getByName"> 
	USERNAME <input type="text" name="username"/><br>
	<input type="submit" value="get">
</form>
<pre>${user }</pre>
<a href="Admin.jsp">go back</a>

</body>
</html>