
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
        </div>
        </form>

        <div class="nav-links">
            <a href="login.jsp">Login</a>
            <a href="signup.jsp">Sign up</a>          
            <a href="contact.html">Contact</a>
        </div>
    </div>

    <footer>
        <p>&copy;2024 Blogging Platform.</p>
    </footer>

    <form id="signupForm" action="SignUpServlet" class="form" method="post">
        <h1>Sign Up</h1>
        <input type="name" name="name" class="box" placeholder="Name" required>
        <input type="email" name="email" class="box" placeholder="email" required>
        <input type="password" name="password" id="password" class="box" placeholder="Enter password" required>
        <input type="password" name="confirmPassword" id="confirmPassword" class="box" placeholder="Enter password again" required>
        <input type="name" name="role" class="box" placeholder="User or admin" required>
		<input type="submit" value="LOGIN" id="submit">
        <!-- Error message placeholder -->
        <p id="error-message" style="color: red; display: none;">Passwords do not match!</p>

        
        <p>Do you have an account? <a href="login.jsp">LOGIN</a></p>
    </form>

    <script>
        document.getElementById('signupForm').addEventListener('submit', function(event) {
            var password = document.getElementById('password').value;
            var confirmPassword = document.getElementById('confirmPassword').value;

            if (password !== confirmPassword) {
                event.preventDefault(); // Prevent form submission
                document.getElementById('error-message').style.display = 'block'; // Show error message
            } else {
                document.getElementById('error-message').style.display = 'none'; // Hide error message if passwords match
            }
        });
    </script>

</body>
</html>





