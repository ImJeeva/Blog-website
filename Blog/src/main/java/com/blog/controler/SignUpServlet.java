package com.blog.controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blog.DAO.UserDAO;
import com.blog.DAOImplement.UserDAOImplement;
import com.blog.model.User;

@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO userDAOImp;

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		userDAOImp = new UserDAOImplement();

		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String confirmPassword = req.getParameter("confirmPassword");
		String role = req.getParameter("role");

		if (password.equals(confirmPassword)) {
			int t = userDAOImp.addUser(new User(name, password, email, role));
			System.out.println(t);

			if (t != 0) {
				HttpSession session = req.getSession();
				session.setAttribute("role", role);
				res.sendRedirect("login.jsp");
				System.out.println(role);
			}

		} else {
			res.sendRedirect("PasswordError.jsp");
		}

	}

}
