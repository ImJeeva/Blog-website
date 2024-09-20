<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.blog.model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<link rel="stylesheet" href=CSS/homepage.css>
</head>
<body>
	<div class="navbar">
		<div class="logo">Blogging Website</div>
		<form action="#">
			<div class="search">
				<input type="text" placeholder="Search...">
				<button>
					<img alt="img" src="Images/search.png" width="20px" height="20px">
				</button>
		</form>

	</div>
	<div class="nav-links">
		<%
		User user = (User) session.getAttribute("logedUser");
		%>


		<a href="#"> Welcome <%=user.getName()%>!
		</a> <a href="index.jsp">Logout</a> <a href="contact.html">Contact</a>
	</div>
	</div>
	<form action=" LoginServlet " class="form">

		<h1>Dashboard</h1>
		<a href="ListPost" class="box"> view post</a> 
		<a href="uploadpost.jsp" class="box"> upload post</a>
			
	</form>


	<footer>
		<p>&copy;2024 Blogging Platform.</p>
	</footer>


</body>
</html>