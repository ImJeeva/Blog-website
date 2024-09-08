<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>
<link rel="stylesheet" href="CSS/signUp.css">

</head>
<body>
 <div class="navbar">
     <div class="logo">Blogging Website</div>
        <form action="#">
        <div class="search">
             <input type="text" placeholder="Search..." class="search">
             <button><img alt="img" src="Images/search.png" width="20px" height="20px"></button>
            
        </form>

        </div>
        <div class="nav-links">
        <%  %>
            <a href="login.jsp">Login</a>
            <a href="signup.jsp">Sign up</a>          
            <a href="contact.html">Contact</a>
        </div>
    </div>
    

    <footer>
    <p>&copy;2024 Blogging Platform.</p>
    </footer>

  <form action="SignUpServlet" class="form">
	<h1>Sign Up</h1>
	<input type="name"  name="name" class="box" placeholder="Name" required>
	<input type="email" name="email" class="box" placeholder="email" required>
	<input type="password" name="password" class="box" placeholder=" enter password" required>
	<input type="password" name="confirmPassword" class="box" placeholder=" enter password again" required>
	<input type="name" name="role" class="box" placeholder=" user or admin" required>
	<input type="submit" value="LOGIN" id="submit">	
	<P>Do you have a account?<a href="login.jsp">  LOGIN</a></p>
	
</form>

</body>
</html>