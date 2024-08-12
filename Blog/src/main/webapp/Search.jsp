<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.blog.model.Post,com.blog.model.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search</title>
    <link rel="stylesheet" href="CSS/viewpost.css">

</head>
<body>
    
    <div class="navbar">
     <div class="logo" >Blogging Website</div>
        <form action="search" method="post">
        <div class="search">
             <input type="text" placeholder="Search..." name="search">
             <button><img alt="img" src="Images/search.png" width="20px" height="20px"></button>
            
        </form>
        </div>
        
        <div class="nav-links">
        <% User user=(User) session.getAttribute("logedUser"); %>       
            <a href="#"> Welcome <%= user.getName() %>!</a>          
            <a href="index.jsp">Logout</a>
            <a href="contact.html">Contact</a>
        </div>
    </div>
    
            <section class="gallery fade-in">
            	<%
            	
                List<Post> searchResult = (List<Post>) request.getAttribute("searchResult");%>
                <% user=(User) session.getAttribute("logedUser"); %>
            	 <% if (searchResult != null) {
                    for (Post post : searchResult) {
                 %>
           		
                        <div class="gallery-item">
                        
                            <div class="gallery-item-info">
                                <h3><%= post.getTitle() %></h3>
                                <p><%= post.getContent() %></p>
                                <% if (post.getImagePath() != null) { %>
                                    <img src="<%= post.getImagePath() %>" alt="Image"> <br>
                                <% } %>
                                <% if (post.getVideoPath() != null) { %>
                                    <video controls>
                                        <source src="<%= post.getVideoPath() %>" type="video/mp4">
                                    </video>
                                <% } %>
                                
                              <% if ("admin".equals(user.getRole())) { %>
				    <br>
				    <a href="updatepost?postId=<%= post.getPostId() %>" class="btn">Update</a>
				     
				    <a href="DeletePost?postId=<%= post.getPostId() %>" class="btn" onclick="return confirmDelete();">Delete</a>
					
				<% } %>
				<br>
				<a href="viewpost?id=<%= post.getPostId() %>" class="btn" target="_blank">View Details</a> <!-- Opens in new tab -->	
                            </div>
                        </div>
           		<%
                    }
                }
            %>
        </section>
</body>
</html>