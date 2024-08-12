<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.blog.model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upload Post</title>
<link rel="stylesheet" href="CSS/uploadpost.css">
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

		 <a href="#"> Welcome <%=user.getName()%>!</a>
		 <a href="Home.jsp">Home</a>
		 <a href="index.jsp">Logout</a>
		 <a href="contact.html">Contact</a>
	</div>
	</div>


	<form action="createpostservlet" class="form" method="post" enctype="multipart/form-data">
		<h1>Create new post</h1>
		<label class="tags">Tittle:</label>
		<input type="text" name="title"class="tags pad">
	    <label class="tags">Content:</label>
		<textarea cols="35" rows="4" name="content" class="tags"></textarea>
		<label class="tags">Upload image:</label>
		<input type="file"name="image" class="tags click">
		<label class="tags ">Upload video:</label>  
		<input type="file" name="video" class="tags click"><br>
		<input type="submit" value="Create Post" class="tags click submit">

	</form>


	<footer>
		<p>&copy;2024 Blogging Platform.</p>
	</footer>

</body>
</html>