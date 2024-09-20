package com.blog.controler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.DAO.PostDAO;
import com.blog.DAOImplement.PostDAOImpl;
import com.blog.model.Post;

@WebServlet("/search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PostDAO postDAO;

	@Override
	public void init() throws ServletException {
		postDAO = new PostDAOImpl();

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String search = request.getParameter("search");

		if (search != null && !search.isEmpty()) {
			List<Post> searchResult = postDAO.search(search);

			request.setAttribute("searchResult", searchResult);
			request.getRequestDispatcher("Search.jsp").forward(request, response);

		}

	}

}
