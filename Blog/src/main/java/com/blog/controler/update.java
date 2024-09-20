package com.blog.controler;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.blog.DAO.PostDAO;
import com.blog.DAOImplement.PostDAOImpl;
import com.blog.model.Post;

/**
 * Servlet implementation class update
 */
@WebServlet("/update")
@MultipartConfig
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PostDAO postDAO;

	@Override
	public void init() throws ServletException {
		postDAO = new PostDAOImpl();

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Post post = new Post();
		int postId = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		Part imagePart = request.getPart("imagePath");
		Part videoPart = request.getPart("videoPath");

		String imageUrl = null;
		String videoUrl = null;

		// Directory for uploads
		String uploadDir = getServletContext().getRealPath("/") + "uploads";
		File uploadDirFile = new File(uploadDir);
		if (!uploadDirFile.exists()) {
			uploadDirFile.mkdirs(); // Create the directory if it does not exist
		}

		// Upload image and video files to the server
		if (imagePart != null && imagePart.getSize() > 0) {
			imageUrl = "uploads/" + imagePart.getSubmittedFileName();
			imagePart.write(uploadDir + File.separator + imagePart.getSubmittedFileName());
		}
		if (videoPart != null && videoPart.getSize() > 0) {
			videoUrl = "uploads/" + videoPart.getSubmittedFileName();
			videoPart.write(uploadDir + File.separator + videoPart.getSubmittedFileName());
		}
		System.out.println("hi");
		System.out.println(title + "," + content + "," + imagePart + "," + videoPart);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog", "root", "Imjeeva@888");
			String query = "Update post set title=?,content=?,imagepath=?,videopath=? where postId=?";
			PreparedStatement pStatement = conn.prepareStatement(query);
			pStatement.setString(1, title);
			pStatement.setString(2, content);
			pStatement.setString(3, imageUrl);
			pStatement.setString(4, videoUrl);
			pStatement.setInt(5, postId);
			int x = pStatement.executeUpdate();
			System.out.println(post.getTitle() + "," + post.getContent());

			response.sendRedirect("ListPost");
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}
