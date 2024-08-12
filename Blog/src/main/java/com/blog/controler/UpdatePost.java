package com.blog.controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.DAO.PostDAO;
import com.blog.DAOImplement.PostDAOImpl;
import com.blog.model.Post;


@WebServlet("/updatepost")
public class UpdatePost extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PostDAO postDAO;
	
	@Override
	public void init() throws ServletException {
		postDAO=new PostDAOImpl();

	}
	



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int postId=Integer.parseInt(request.getParameter("postId"));


		  request.setAttribute("postId", postId);
		  request.getRequestDispatcher("updatePost.jsp").forward(request, response);
		 
		
		
		
		

	}

}
