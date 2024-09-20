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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDAO userDAO;

	@Override
	public void init() throws ServletException {
		userDAO = new UserDAOImplement();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		System.out.println(email + " ," + password);
		User loggedUser = userDAO.getUser(email);
		/* String tt = loggedUser.getPassword(); */

		if (loggedUser.getPassword() != null && loggedUser.getPassword().equals(password)) {
			HttpSession session = req.getSession();
			session.setAttribute("logedUser", loggedUser);
			String role = loggedUser.getRole();

			if (role.equalsIgnoreCase("user")) {
				res.sendRedirect("ListPost");
			} else {
				res.sendRedirect("Home.jsp");
			}

		}

		else {
			res.sendRedirect("PasswordError.jsp");
		}

	}

}
