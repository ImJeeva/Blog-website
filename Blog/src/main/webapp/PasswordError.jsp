<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Password Error</title>
<link rel="stylesheet" href="CSS/PError.css">
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
            <a href="signup.jsp">SignUP </a>          
            <a href="contact.html">Contact</a>
        </div>
    </div>
    

    <footer>
    <p>&copy;2024 Blogging Platform.</p>
    </footer>




<div class="form">
<h2>You are enter wrong Email or password</h2>

<a href="login.jsp" id="link"><button class="box a"> Try again</button></a>
<a href="ForgetPassword.jsp" id="link"><button class="box a ">Forget password</button></a>

</div>

</body>
</html>