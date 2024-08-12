package com.blog.DAOImplement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.blog.DAO.UserDAO;
import com.blog.model.User;

public class UserDAOImplement implements UserDAO {
	Connection connection;
	PreparedStatement pStatement;
	
	public UserDAOImplement() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/blog","root","Imjeeva@888");
			
			
	 	} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public int addUser(User user) {
		String query="Insert into `user` (`name`,`password`,`email`,`role`) values  (?,?,?,?)";
		try {
			pStatement=connection.prepareStatement(query);
			pStatement.setString(1,user.getName());
			pStatement.setString(2,user.getPassword());
			pStatement.setString(3,user.getEmail());
			pStatement.setString(4,user.getRole());
			int x=pStatement.executeUpdate();
			return x;
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}
	
	public User getUser(String email) {
		String query="Select * from User where email=?";
		User user=null;
		
		try {
			pStatement=connection.prepareStatement(query);
			pStatement.setString(1,email );
			ResultSet res=pStatement.executeQuery();
			
			if(res.next()) {
				user=print(res);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public User print(ResultSet res) throws Exception {
		User user=new User();
	    user.setUserID(res.getInt("userId")); 
		user.setName(res.getString("name"));
		user.setEmail(res.getString("email"));
		user.setPassword(res.getString("password"));
		user.setRole(res.getString("role"));
		
		return user;
	}
	
	
	public void updateUser(User user) {
		String query="UPDATE user set password=? where email=?";
		try {
			pStatement =connection.prepareStatement(query);
			pStatement.setString(1,user.getPassword());
			pStatement.setString(2,user.getEmail() );
			int x=pStatement.executeUpdate();
			System.out.println(" User password Updated.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	

}
