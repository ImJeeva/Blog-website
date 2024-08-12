<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="CSS/loginn.css">
</head>
<body>

    <div class="navbar">
     <div class="logo">Blogging Website</div>
        <form action="searchServlet.jsp">
        <div class="search">
             <input type="text" placeholder="Search..." class="search">
             <button><img alt="img" src="Images/search.png" width="20px" height="20px"></button>
            
        </form>

        </div>
        <div class="nav-links">
        <%  %>
            <a href="login.jsp">Login</a>
            <a href="signin.jsp">Sign in</a>          
            <a href="contact.html">Contact</a>
        </div>
    </div>
    

    <footer>
    <p>&copy;2024 Blogging Platform.</p>
    </footer>
    

<form action=" LoginServlet " class="form">
<h1>LOGIN</h1>
<input type="email"  name="email" class="box" placeholder="enter email" required="">
<input type="password" name="password" class="box" placeholder=" enter password" required="">
<input type="submit" value="LOGIN" id="submit">
<p>You don't have a account?<a href="signin.jsp">  Sign in </a> </p>
</form>

</body>
</html>