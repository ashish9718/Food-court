<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User page</title>
</head>
<body>
<h3>WHAT DO YOU WISH?</h3>
<ul>

	<li><a href="Register.jsp">Add user</a>
	<li><a href="login.jsp">Login </a>
	<LI><H5>GET USER :</H5>
	<OL>
		<LI><a href="getbyid.jsp">BY ID</a>
		<LI><a href="getbyname.jsp">BY NAME</a>
		<LI><a href="UserController?action=getAll">ALL USERS</a>	
	</OL>
	
</ul>
${msg }
<a href="index.jsp">go back</a>
</body>
</html>