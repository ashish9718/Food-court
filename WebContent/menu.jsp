<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.util.List" %>
<%@ page import="com.javaproject.models.Menu" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
List<Menu> list=(List<Menu>)request.getAttribute("list");
%>

<body>

<table border="1" width="80%" height="60%">
	<tr>
		<td>ID
		<td>Category
	</tr>
	
	<% for(Menu u : list){ %>
		<tr>
			<td><%=u.getId() %>
			<td><%=u.getCategory() %>
		</tr>
	<%} %>

</table>
</body>
</html>