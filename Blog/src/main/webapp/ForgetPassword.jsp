<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forget Password</title>
<link rel="stylesheet" href="CSS/ForgetPassword.css">
</head>
<body>

<form action ="ForgetPassword" class="form">

  <h1>Forget Password</h1>
    <input type="email" name="email" placeholder="Vaild EmailId"  required="" class="box">
    <input type="password" name="password" placeholder="New Password" required="" class="box">
    <input type="password" name="confirmPassword" placeholder="Confirm Password" required="" class="box" >
    <input type="submit" value="Confirm" id="submit">
</form>


</body>
</html>