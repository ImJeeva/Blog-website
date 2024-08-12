package com.blog.model;

public class User {
	
	private int userID;
	private String name;
	private String password;
	private String email;
	private String role;
	
	
	public User() {
		
	}


	public User(String name, String password, String email, String role) {
		super();
		
		this.name = name;
		this.password = password;
		this.email = email;
		this.role = role;
	}


	public int getUserID() {
		return userID;
	}


	public void setUserID(int userID) {
		this.userID = userID;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}
	public String toString() {
		return userID+" "+name+" "+password+" "+email+" "+role;
	}
	
	

}
