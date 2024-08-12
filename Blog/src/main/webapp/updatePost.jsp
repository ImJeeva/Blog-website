<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.blog.model.User ,com.blog.model.Post"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update post</title>
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
		 int post =(Integer) request.getAttribute("postId");
		System.out.println(post+"uploadpost.jsp"); /* checking post data  by server side  */
		%>


		 <a href="#"> Welcome <%=user.getName()%>!</a>
		 <a href="Home.jsp">Home</a>
		 <a href="index.jsp">Logout</a>
		 <a href="contact.html">Contact</a>
	</div>
	</div>


	<form action="update" class="form" method="post" enctype="multipart/form-data">
		<h1>Update post</h1>
		<input type="hidden" name="id" value="<%=post %>">
		<label class="tags">Title:</label>
		<input type="text" name="title"class="tags pad">
	    <label class="tags">Content:</label>
		<textarea cols="35" rows="4" name="content" class="tags"></textarea>
		<label class="tags">Upload image:</label>
		<input type="file"name="imagePath" class="tags click">
		<label class="tags ">Upload video:</label>  
		<input type="file" name="videoPath" class="tags click"><br>
		<input type="submit" value="Update Post" class="tags click submit">

	</form>


	<footer>
		<p>&copy;2024 Blogging Platform.</p>
	</footer>

</body>
</html>