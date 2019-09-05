<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome ${username }</h1>
${msg }

<ul>
	<li><a href="OrderController?action=getmenu">place order</a>
	<li><a href="OrderController?action=vieworder">view order</a>
	<li><a href="OrderController?action=getbill">view bill</a>
</ul>

			
<a href="UserController?action=logout">logout</a>
</body>
</html>