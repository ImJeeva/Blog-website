package com.blog.controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.DAO.UserDAO;
import com.blog.DAOImplement.UserDAOImplement;
import com.blog.model.User;

@WebServlet("/ForgetPassword")
public class ForgetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserDAO userDAO = new UserDAOImplement();

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String cpassword = req.getParameter("confirmPassword");
		System.out.println("From forget Password " + email + " ," + password);
		if (cpassword.equals(password)) {

			User user = new User();
			user.setEmail(email);
			user.setPassword(password);
			userDAO.updateUser(user);
			res.sendRedirect("login.jsp");

		} else {
			res.sendRedirect("ForgetPassword.jsp");
		}

	}

}
