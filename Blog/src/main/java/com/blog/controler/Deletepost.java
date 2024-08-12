package com.blog.controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.DAO.PostDAO;
import com.blog.DAOImplement.PostDAOImpl;

/**
 * Servlet implementation class Deletepost
 */
@WebServlet("/DeletePost")
public class Deletepost extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PostDAO postDAO;
	
	@Override
		public void init() throws ServletException {
		postDAO=new PostDAOImpl();

		}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("postId"));
		postDAO.deltePostById(id);
		
		
		response.sendRedirect("ListPost");
		
	}

}
