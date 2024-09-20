package com.blog.controler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.model.Post;

/**
 * Servlet implementation class ListPost
 */
@WebServlet("/ListPost")
public class ListPost extends HttpServlet {
	private static final long serialVersionUID = 2698194270731226755L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Post> posts = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog", "root", "Imjeeva@888");

            String query = "SELECT * FROM post ";
            PreparedStatement statement = conn.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();
            System.out.println("data getting");
            while (resultSet.next()) {
                Post post = new Post();
                post.setPostId(resultSet.getInt("postId"));
                post.setTitle(resultSet.getString("title"));
                post.setContent(resultSet.getString("content"));
                post.setImagePath(resultSet.getString("imagePath"));
                post.setVideoPath(resultSet.getString("videoPath"));              
                posts.add(post);
            }
            conn.close();

            request.setAttribute("posts", posts);
            System.out.println(posts+" "+"from listpost");
            request.getRequestDispatcher("viewpost.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("index.jsp?error=Failed to load posts.");
        }
    }
}
