<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu page</title>
</head>
<body>
<h3>WHAT DO YOU WISH?</h3>
<ul>

	<li><a href="menu_add.jsp">Add menu</a>
	<li><a href="item_add.jsp">Add item</a>
	<LI><H5>GET Menu :</H5>
	<OL>
		<LI><a href="getmenubyid.jsp">BY ID</a>
		<LI><a href="getmenubycategory.jsp">BY CATEGORY</a>
		<LI><a href="MenuController?action=getAll">ALL Menu</a>	
	</OL>
	
</ul>
${msg }
<a href="index.jsp">go back</a>
</body>
</html>