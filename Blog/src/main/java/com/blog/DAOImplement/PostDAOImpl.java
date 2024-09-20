package com.blog.DAOImplement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.blog.DAO.PostDAO;
import com.blog.model.Post;

public class PostDAOImpl implements PostDAO {
	Connection connection;
	PreparedStatement pStatement;

	public PostDAOImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog", "root", "Imjeeva@888");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deltePostById(int postId) {
		String query = "DELETE from post where postId=?";
		try {
			pStatement = connection.prepareStatement(query);
			pStatement.setInt(1, postId);
			int x = pStatement.executeUpdate();
			System.out.println("id " + x + " +is " + "deleted");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void updatePostById(int postId) {
		Post post = null;
		post = new Post();
		String update = "Update post set title=?,content=?,imagepath=?,videopath=? where postId=?";
		System.out.println("jiiii");

		try {
			pStatement = connection.prepareStatement(update);
			pStatement.setString(1, post.getTitle());
			pStatement.setString(2, post.getContent());
			pStatement.setString(3, post.getImagePath());
			pStatement.setString(4, post.getVideoPath());
			pStatement.setInt(5, postId);
			int x = pStatement.executeUpdate();
			System.out.println(post.getTitle() + "," + post.getContent());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Post> search(String search) {
		List<Post> posts = new ArrayList<Post>();
		Post post = new Post();
		String query = "Select * from post where title LIKE ? ";

		try {
			pStatement = connection.prepareStatement(query);
			pStatement.setString(1, "%" + search + "%");
			ResultSet res = pStatement.executeQuery();

			if (res.next()) {
				post.setPostId(res.getInt("postId"));
				post.setTitle(res.getString("title"));
				post.setContent(res.getString("content"));
				post.setImagePath(res.getString("imagePath"));
				post.setVideoPath(res.getString("videoPath"));
				posts.add(post);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return posts;

	}

}
