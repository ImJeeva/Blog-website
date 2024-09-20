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

@WebServlet("/createpostservlet")
@MultipartConfig
public class CreatePostServlet extends HttpServlet  {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		    String title = req.getParameter("title");
	        String content = req.getParameter("content");
	        Part imagePart = req.getPart("image");
	        Part videoPart = req.getPart("video");

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
	        System.out.println(title+","+content+","+imagePart+","+videoPart);
	        
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog", "root", "Imjeeva@888");

	            String sql = "INSERT INTO post (title, content, imagepath, videopath) VALUES (?, ?, ?, ?)";
	            PreparedStatement statement = conn.prepareStatement(sql);
	            statement.setString(1, title);
	            statement.setString(2, content);
	            statement.setString(3, imageUrl);
	            statement.setString(4, videoUrl);

	            int  x=statement.executeUpdate();
	            System.out.println(x);
	            conn.close();

	            res.sendRedirect("ListPost");
	        } catch (Exception e) {
	            e.printStackTrace();
	            res.sendRedirect("newpost.jsp?error=Failed to create post. Try again.");
	        }
	}

}

